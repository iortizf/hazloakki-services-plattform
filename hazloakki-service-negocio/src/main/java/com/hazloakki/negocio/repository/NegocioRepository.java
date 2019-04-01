package com.hazloakki.negocio.repository;

import java.util.List;
import com.hazloakki.negocio.modelo.NegocioDto;

/**
 * @author Jovani Arzate 
 * 2018-07-01 
 * HazloAkki para Empresas v.1
 *
 */

public interface NegocioRepository {

	String guardar(NegocioDto negocioDto);
	NegocioDto findById(String idNegocio);
	List<NegocioDto> findByIdCuentaAndEstatus(String idCuenta, Integer idEstatus);
	void actualizarByIdNegocio(String idNegocio, NegocioDto negocioDto);
	void eliminarByIdNegocio(String idNegocio);	
}
