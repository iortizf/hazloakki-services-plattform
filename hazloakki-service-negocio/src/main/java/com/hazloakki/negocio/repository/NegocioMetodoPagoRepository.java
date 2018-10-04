package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.MetodoPagoDto;

public interface NegocioMetodoPagoRepository {

	void guardar(String idNegocio, String idMetodoPago);

	List<MetodoPagoDto> consultar(String idNegocio);

	void eliminar(String idNegocio);
}
