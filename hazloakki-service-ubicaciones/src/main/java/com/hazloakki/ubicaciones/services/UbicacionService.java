package com.hazloakki.ubicaciones.services;


import com.hazloakki.ubicaciones.models.NegocioDto;
import com.hazloakki.ubicaciones.models.OfertaDto;

public interface UbicacionService {
	
	OfertaDto obtenerOferta(String idOferta);
	NegocioDto obtenerNegocio(String idNegocio);
	void actualizarEstatusOferta(String idOferta, Integer idEstatus);
}
