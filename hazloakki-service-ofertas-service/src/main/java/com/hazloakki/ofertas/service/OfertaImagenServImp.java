package com.hazloakki.ofertas.service;

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
import com.amazonaws.services.s3.model.CreateBucketRequest;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.hazloakki.ofertas.modelo.ImagenDto;

@Service
public class OfertaImagenServImp implements OfertaImagenService {

	private static String AWS_URL = "https://s3.amazonaws.com/";
	private static String AWS_BUCKET_NAME = "hazloakki-offer";

	@Autowired
	private AmazonS3 s3client;

	@Override
	public List<ImagenDto> obtenerImagenes(String idOferta) {

		List<ImagenDto> images = new ArrayList<>();
		List<S3ObjectSummary> s3ObjSummaries = getListObjectsByPrefix(idOferta + "/");

		for (S3ObjectSummary item : s3ObjSummaries) {
			if (!item.getKey().endsWith("/")) {
				ImagenDto img = new ImagenDto();
				img.setIdOferta(idOferta);
				img.setIdImagen(item.getKey().substring(item.getKey().indexOf("/") + 1));
				img.setRutaImagen(AWS_URL + AWS_BUCKET_NAME + "/" + item.getKey());
				images.add(img);
			}

		}

		return images;
	}

	@Transactional
	@Override
	public List<ImagenDto> guardarImagenes(String idOferta, MultipartFile[] files) {

		List<ImagenDto> imgSaved = new ArrayList<>();

		if (files != null) {
			for (MultipartFile multipartFile : files) {
				String originalFileName = multipartFile.getOriginalFilename();
				String format = originalFileName.substring(originalFileName.lastIndexOf("."));
				String idImagen = String.valueOf(UUID.randomUUID())+format;

				ImagenDto imagen = new ImagenDto();
				String path = uploadFileToS3(idOferta, idImagen, multipartFile);
				imagen.setIdImagen(idImagen);
				imagen.setIdOferta(idOferta);
				imagen.setRutaImagen(path);
				imgSaved.add(imagen);
			}
		}

		return imgSaved;
	}

	@Override
	public void eliminarImagen(String idOferta, String idImagen) {
		deleteFileFromS3Bucket(idOferta + "/" + idImagen);
	}

	@Override
	public void eliminarImagenesOferta(String idOferta) {
		List<S3ObjectSummary> s3ObjSummaries = getListObjectsByPrefix(idOferta + "/");

		for (S3ObjectSummary item : s3ObjSummaries) {
			if (!item.getKey().endsWith("/")) {
				deleteFileFromS3Bucket(item.getKey());
			}
		}		
	}
	
	private List<S3ObjectSummary> getListObjectsByPrefix(String prefix) {
		ListObjectsRequest listObjectsRequest = new ListObjectsRequest().withBucketName(AWS_BUCKET_NAME)
				.withPrefix(prefix);

		ObjectListing objects = s3client.listObjects(listObjectsRequest);

		return objects.getObjectSummaries();
	}

	private String uploadFileToS3(String idOferta, String idImagen, MultipartFile multipartFile) {
		String fileUrl = "";
		try {
			if (!s3client.doesBucketExistV2(AWS_BUCKET_NAME)) {
				s3client.createBucket(new CreateBucketRequest(AWS_BUCKET_NAME));
			}
			File file = convertMultiPartToFile(multipartFile);
			String fileName = idOferta + "/" + idImagen;
			fileUrl = AWS_URL + AWS_BUCKET_NAME + "/" + fileName;
			uploadFileToS3bucket(fileName, file);
			file.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileUrl;
	}

	private void uploadFileToS3bucket(String fileName, File file) {
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
