package com.hazloakki.ubicaciones.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ubicaciones.clients.ObtenerOferta;
import com.hazloakki.ubicaciones.models.NegocioDto;
import com.hazloakki.ubicaciones.models.OfertaDto;

@Service("ubicacionService")
public class UbicacionServiceImp implements UbicacionService {

	@Autowired
	private ObtenerOferta obtenerOferta;
	
	@Override
	public OfertaDto obtenerOferta(String idOferta) {
		return obtenerOferta.obtenerOfertasById(idOferta);		
	}

	@Override
	public NegocioDto obtenerNegocio(String idNegocio) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
