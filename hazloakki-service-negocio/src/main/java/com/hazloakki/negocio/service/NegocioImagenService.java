package com.hazloakki.negocio.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hazloakki.negocio.modelo.ImagenDto;

public interface NegocioImagenService {
	List<ImagenDto> obtenerImagenes(String idNegocio);
	List<ImagenDto> guardarImagenes(String idNegocio, MultipartFile[] files, String imgprofile);
	void eliminarImagen(String idNegocio,String idImagen);
	void eliminarImagenesNegocio(String idNegocio);
	void imagenPerfil(String idNegocio,String idImagen);
}
