package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.ImagenDto;

public interface NegocioImagenRepository {
	
	String guardar(String idNegocio, ImagenDto imagenDto);
	void eliminarById(String idNegocio, String idImagen);
	void eliminarByIdNegocio(String idNegocio);
	List<ImagenDto> obtenerByIdNegocio(String idNegocio);
	
}
