package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.ServiciosDto;

public interface CatServiciosRepository {

		List<ServiciosDto> findByEstatus(boolean estatus);
}
