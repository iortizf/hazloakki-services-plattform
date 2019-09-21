package com.hazloakki.ubicaciones.services;

import java.util.List;

import com.hazloakki.ubicaciones.models.NegocioDto;
import com.hazloakki.ubicaciones.models.OfertaDto;

public interface UbicacionService {
	
	OfertaDto obtenerOferta(String idOferta);
	NegocioDto obtenerNegocio(String idNegocio);
}
