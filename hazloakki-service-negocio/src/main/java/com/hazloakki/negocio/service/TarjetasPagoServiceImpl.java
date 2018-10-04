package com.hazloakki.negocio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.negocio.modelo.TipoTarjetaDto;
import com.hazloakki.negocio.repository.TarjetasPagoRepository;

@Service
public class TarjetasPagoServiceImpl implements TarjetasPagoService {

	@Autowired
	private TarjetasPagoRepository tarjetasPagoRepository;

	@Override
	public List<TipoTarjetaDto> obtenerTipoTarjetaActivas() {
		List<TipoTarjetaDto> tipoTarjetaEntities = tarjetasPagoRepository.findByEstatus(Boolean.TRUE);
		List<TipoTarjetaDto> tipoTarjetaDtos = new ArrayList<>();

		for (TipoTarjetaDto entity : tipoTarjetaEntities) {
			tipoTarjetaDtos.add(entity);
		}

		return tipoTarjetaDtos;
	}

}
