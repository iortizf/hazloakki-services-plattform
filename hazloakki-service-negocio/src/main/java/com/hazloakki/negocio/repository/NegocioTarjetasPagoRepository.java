package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.TipoTarjetaDto;

public interface NegocioTarjetasPagoRepository{
	
	void guardar(String idNegocio, String idTipoTarjetaPago);
	List<TipoTarjetaDto> findByIdNegocio(String idNegocio);
	void eliminar(String idNegocio);
}
