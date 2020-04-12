package com.hazloakki.ubicaciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ubicaciones.clients.ApiNegocio;
import com.hazloakki.ubicaciones.clients.ApiOferta;
import com.hazloakki.ubicaciones.models.NegocioDto;
import com.hazloakki.ubicaciones.models.OfertaDto;

@Service
public class UbicacionServiceImp implements UbicacionService {

	@Autowired
	private ApiOferta apiOferta;
	@Autowired
	private ApiNegocio apiNegocio;
	
	@Override
	public OfertaDto obtenerOferta(String idOferta) {
		return apiOferta.obtenerOfertasById(idOferta);		
	}

	@Override
	public NegocioDto obtenerNegocio(String idNegocio) {
		return apiNegocio.obtenerNegocio(idNegocio);
	}

	@Override
	public void actualizarEstatusOferta(String idOferta, Integer idEstatus) {
		apiOferta.modificarEstatus(idOferta, idEstatus);		
	}	

}
