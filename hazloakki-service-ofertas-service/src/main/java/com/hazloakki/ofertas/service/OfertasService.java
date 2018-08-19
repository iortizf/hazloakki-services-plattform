package com.hazloakki.ofertas.service;

import java.util.List;

import com.hazloakki.ofertas.entity.OfertaEntity;
import com.hazloakki.ofertas.modelo.OfertaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface OfertasService {

	OfertaEntity guardarOferta(OfertaDto cuentaDto);
	OfertaEntity obtenerOfertaByNegocio(String idNegocio);
	OfertaEntity modificarOferta(String idCuenta, OfertaDto cuentaDto);
	void borrarOferta(String idCuenta);
	List<OfertaDto> obtenerOfertas(String idNegocio);

}
