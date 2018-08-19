package com.hazloakki.cuenta.service;

import java.util.List;

import com.hazloakki.cuenta.entity.CuentaEntity;
import com.hazloakki.cuenta.modelo.CuentaDto;
import com.hazloakki.cuenta.service.remoto.NegocioDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface CuentaService {

	CuentaEntity guardarCuenta(CuentaDto cuentaDto);
	CuentaEntity obtenerCuenta(String idCuenta);
	CuentaEntity modificarCuenta(String idCuenta, CuentaDto cuentaDto);
	void borrarCuenta(String idCuenta);
	CuentaEntity validaCuenta(String email, String password);
	List<NegocioDto> obtenerNegociosByCuenta(String idCuenta);
	
}
