package com.hazloakki.negocio.service;

import java.util.List;
import com.hazloakki.negocio.modelo.NegocioDto;
/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
public interface NegocioService {

	NegocioDto guardarNegocio(NegocioDto cuentaDto);
	NegocioDto obtenerNegocio(String idNegocio);
	NegocioDto modificaNegocio(String idNegocio,NegocioDto cuentaDto);
	void borrarNegocio(String idNegocio);
	void modificarEstatus(String idNegocio, Integer idEstatus);
	List<NegocioDto> obtenerAllNegociosByCuenta(String idCuenta);

}
