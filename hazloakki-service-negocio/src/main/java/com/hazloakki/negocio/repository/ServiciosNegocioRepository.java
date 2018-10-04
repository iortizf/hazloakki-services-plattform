package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.ServiciosDto;
public interface ServiciosNegocioRepository {
	
	void guardar(String idNegocio, String idServicio);
	List<ServiciosDto> findServicios(String idNegocio);
	void eliminar(String idNegocio);
	
}
