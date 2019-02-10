package com.hazloakki.ofertas.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hazloakki.ofertas.modelo.ImagenDto;


public interface OfertaImagenService {
	List<ImagenDto> obtenerImagenes(String idOferta);
	List<ImagenDto> guardarImagenes(String idOferta, MultipartFile[] files);
	void eliminarImagen(String idOferta, String idImagen);
	void eliminarImagenesOferta(String idOferta);
}
