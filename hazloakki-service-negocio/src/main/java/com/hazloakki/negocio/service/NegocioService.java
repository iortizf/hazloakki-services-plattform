package com.hazloakki.negocio.service;

import java.util.List;

import com.hazloakki.negocio.entity.NegocioEntity;
import com.hazloakki.negocio.modelo.NegocioDto;
/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
import com.hazloakki.negocio.service.remotos.OfertaDto;
public interface NegocioService {

	NegocioEntity guardarNegocio(NegocioDto cuentaDto);
	NegocioEntity obtenerNegocio(String idNegocio);
	NegocioEntity modificaNegocio(String idNegocio,NegocioDto cuentaDto);
	void borrarNegocio(String idNegocio);
	
	/*
	 * Remotos
	 */
	List<NegocioEntity> obtenerAllNegociosByCuenta(String idCuenta);
	List<OfertaDto> obtenerAllOfertasByNegocio(String idNegocio);

}
