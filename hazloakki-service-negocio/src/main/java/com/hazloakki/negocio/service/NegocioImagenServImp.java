package com.hazloakki.negocio.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.hazloakki.negocio.modelo.ImagenDto;

@Service
public class NegocioImagenServImp implements NegocioImagenService {

	private static String AWS_URL = "https://s3.amazonaws.com/";
	private static String AWS_BUCKET_NAME = "hazloakki-business";
	private static String PROFILE_SUFIX = "_profile";

	@Autowired
	private AmazonS3 s3client;

	@Override
	public List<ImagenDto> obtenerImagenes(String idNegocio) {

		List<ImagenDto> images = new ArrayList<>();
		List<S3ObjectSummary> s3ObjSummaries = getListObjectsByPrefix(idNegocio + "/");

		for (S3ObjectSummary item : s3ObjSummaries) {
			if (!item.getKey().endsWith("/")) {
				ImagenDto img = new ImagenDto();
				img.setIdNegocio(idNegocio);
				img.setIdImagen(item.getKey().substring(item.getKey().indexOf("/") + 1));
				img.setRutaImagen(AWS_URL + AWS_BUCKET_NAME + "/" + item.getKey());
				img.setPerfil(img.getIdImagen().indexOf(PROFILE_SUFIX) > 0);
				images.add(img);
			}

		}

		return images;
	}

	@Transactional
	@Override
	public List<ImagenDto> guardarImagenes(String idNegocio, MultipartFile[] files, String imgprofile) {

		List<ImagenDto> imgSaved = new ArrayList<>();

		if (files != null) {
			for (MultipartFile multipartFile : files) {
				String originalFileName = multipartFile.getOriginalFilename();
				String format = originalFileName.substring(originalFileName.lastIndexOf("."));
				String idImagen = String.valueOf(UUID.randomUUID());

				ImagenDto imagen = new ImagenDto();
				if (imgprofile.equals(originalFileName)) {
					idImagen += PROFILE_SUFIX + format;
					imagen.setPerfil(true);
				} else {
					idImagen += format;
				}
				String path = uploadFileToS3(idNegocio, idImagen, multipartFile);
				imagen.setIdImagen(idImagen);
				imagen.setIdNegocio(idNegocio);
				imagen.setRutaImagen(path);
				imgSaved.add(imagen);
			}
		}

		return imgSaved;
	}

	@Override
	public void eliminarImagen(String idNegocio, String idImagen) {
		deleteFileFromS3Bucket(idNegocio + "/" + idImagen);
	}

	@Override
	public void eliminarImagenesNegocio(String idNegocio) {
		List<S3ObjectSummary> s3ObjSummaries = getListObjectsByPrefix(idNegocio + "/");

		for (S3ObjectSummary item : s3ObjSummaries) {
			if (!item.getKey().endsWith("/")) {
				deleteFileFromS3Bucket(item.getKey());
			}
		}		
	}
	
	@Override
	public void imagenPerfil(String idNegocio, String idImagen) {
		List<S3ObjectSummary> s3ObjSummaries = getListObjectsByPrefix(idNegocio + "/");
		String currentImageKey = idNegocio+"/"+idImagen;
		
		if(s3ObjSummaries!=null && s3ObjSummaries.size()>0) {
			String currentImgProfile = s3ObjSummaries
					.stream()
					.filter(img -> img.getKey().contains(PROFILE_SUFIX))
					.map( img -> img.getKey())
					.findAny().orElse(null);
			if(currentImgProfile!=null && !currentImgProfile.equals(currentImageKey) ) {
				String renameFile = currentImgProfile.replace(PROFILE_SUFIX, "");
				CopyObjectRequest copyCurreProfileObjRequest = new CopyObjectRequest(AWS_BUCKET_NAME, 
						currentImgProfile , AWS_BUCKET_NAME, renameFile);
				s3client.copyObject(copyCurreProfileObjRequest);
				s3client.deleteObject(new DeleteObjectRequest(AWS_BUCKET_NAME, currentImgProfile));
				
				renameFile = currentImageKey.replace(".", "_profile.");
				CopyObjectRequest copyNewProfileObjRequest = new CopyObjectRequest(AWS_BUCKET_NAME, 
						currentImageKey , AWS_BUCKET_NAME, renameFile);
				s3client.copyObject(copyNewProfileObjRequest);
				s3client.deleteObject(new DeleteObjectRequest(AWS_BUCKET_NAME, currentImageKey));
				
			}
		}
		
	}

	private List<S3ObjectSummary> getListObjectsByPrefix(String prefix) {
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(AWS_BUCKET_NAME)
				.withPrefix(prefix);

		ObjectListing objects = s3client.listObjects(listObjectsRequest);

		return objects.getObjectSummaries();
	}

	private String uploadFileToS3(String idNegocio, String idImagen, MultipartFile multipartFile) {
		String fileUrl = "";
		try {
			if (!s3client.doesBucketExistV2(AWS_BUCKET_NAME)) {
				s3client.createBucket(new CreateBucketRequest(AWS_BUCKET_NAME));
			}
			File file = convertMultiPartToFile(multipartFile);
			String fileName = idNegocio + "/" + idImagen;
			fileUrl = AWS_URL + AWS_BUCKET_NAME + "/" + fileName;
			uploadFileTos3bucket(fileName, file);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}

	private void uploadFileTos3bucket(String fileName, File file) {
		s3client.putObject(new PutObjectRequest(AWS_BUCKET_NAME, fileName, file)
				.withCannedAcl(CannedAccessControlList.PublicRead));
	}

	private String deleteFileFromS3Bucket(String fileName) {
		s3client.deleteObject(new DeleteObjectRequest(AWS_BUCKET_NAME, fileName));
		return "Successfully deleted";
	}

	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}

}
