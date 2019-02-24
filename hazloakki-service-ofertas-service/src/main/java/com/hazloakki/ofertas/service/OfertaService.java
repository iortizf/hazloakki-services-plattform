package com.hazloakki.ofertas.service;

import java.util.List;

import com.hazloakki.ofertas.modelo.ConfiguracionDto;
import com.hazloakki.ofertas.modelo.OfertaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface OfertaService {

	OfertaDto guardar(OfertaDto ofertaDto);
	List<OfertaDto> obtenerByIdNegocio(String idNegocio);
	void modificar(String id, OfertaDto ofertaDto);
	void borrar(String id);
	OfertaDto obtenerById(String id);
	ConfiguracionDto obtenerConfig(String id);
	ConfiguracionDto guardarConfig(String id, ConfiguracionDto config);
	void modificarConfig(String id, ConfiguracionDto config);

}
