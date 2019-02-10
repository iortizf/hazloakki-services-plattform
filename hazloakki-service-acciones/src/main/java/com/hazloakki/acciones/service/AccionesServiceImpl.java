package com.hazloakki.acciones.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.acciones.entity.AccionesEntity;
import com.hazloakki.acciones.modelo.AccionesDto;
import com.hazloakki.acciones.repository.AccionesRepository;

@Service
public class AccionesServiceImpl implements AccionesService {

	@Autowired
	private AccionesRepository accionesRepository;

	@Override
	public List<AccionesDto> obtenerTodasLasAcciones() {

		List<AccionesDto> accionesDtos = new ArrayList<>();
		List<AccionesEntity> accionesEntities = accionesRepository.findByEstatus(Boolean.TRUE);

		if (accionesEntities.isEmpty()) {

		}
		for (AccionesEntity accionesEntity : accionesEntities) {
			accionesDtos.add(accionesEntity.to());
		}

		return accionesDtos;
	}

}
