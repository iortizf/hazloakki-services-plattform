package com.hazloakki.negocio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.negocio.modelo.ServiciosDto;
import com.hazloakki.negocio.repository.CatServiciosRepository;

@Service
public class ServiciosServiceImpl implements ServiciosService {

	@Autowired
	private CatServiciosRepository catServiciosRepository;

	@Override
	public List<ServiciosDto> obtenerServiciosActivo() {
		List<ServiciosDto> serviciosEntities = catServiciosRepository.findByEstatus(Boolean.TRUE);
		List<ServiciosDto> serviciosDtos = new ArrayList<>();

		for (ServiciosDto entity : serviciosEntities) {
			serviciosDtos.add(entity);
		}

		return serviciosDtos;
	}

}
