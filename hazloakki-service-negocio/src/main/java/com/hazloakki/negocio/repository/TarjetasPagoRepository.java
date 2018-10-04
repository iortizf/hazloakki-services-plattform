package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.TipoTarjetaDto;

public interface TarjetasPagoRepository {

	List<TipoTarjetaDto> findByEstatus(boolean estatus);
}
