package com.hazloakki.ofertas.service;

import java.util.List;

import com.hazloakki.ofertas.modelo.OfertaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface OfertasService {

	OfertaDto guardarOferta(OfertaDto ofertaDto);
	List<OfertaDto> obtenerOfertasByIdNegocio(String idNegocio);
	OfertaDto modificarOferta(String idOferta, OfertaDto ofertaDto);
	void borrarOferta(String idOferta);
	OfertaDto obtenerOferta(String idOferta);

}
