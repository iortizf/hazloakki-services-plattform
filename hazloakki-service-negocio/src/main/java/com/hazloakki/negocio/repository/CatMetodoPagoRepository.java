package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.MetodoPagoDto;

public interface CatMetodoPagoRepository {

	public List<MetodoPagoDto> findByEstatus(boolean estatus);
}
