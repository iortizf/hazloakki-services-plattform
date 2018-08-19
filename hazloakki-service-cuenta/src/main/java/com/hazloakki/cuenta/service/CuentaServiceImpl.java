package com.hazloakki.cuenta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hazloakki.cuenta.api.CuentaException;
import com.hazloakki.cuenta.entity.CuentaEntity;
import com.hazloakki.cuenta.modelo.CuentaDto;
import com.hazloakki.cuenta.repository.CuentaRepository;
import com.hazloakki.cuenta.service.remoto.NegocioApiClient;
import com.hazloakki.cuenta.service.remoto.NegocioDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class CuentaServiceImpl implements CuentaService {

	@Autowired
	private CuentaRepository cuentaRepository;
	@Autowired
	private NegocioApiClient negocioApiClient;


	@Transactional
	@Override
	public CuentaEntity guardarCuenta(CuentaDto cuentaDto) {
		CuentaEntity cuentaEntity = CuentaEntity.from(cuentaDto);
		return cuentaRepository.save(cuentaEntity);
	}

	@Override
	public CuentaEntity obtenerCuenta(String idCuenta) {
		return cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> CuentaException.from("No se encontro la cuenta :" + idCuenta, idCuenta));
	}

	@Transactional
	@Override
	public CuentaEntity modificarCuenta(String idCuenta, CuentaDto cuentaDto) {

		CuentaEntity cuentaOptional = cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> CuentaException.from("No se encontro la cuenta: " + idCuenta, idCuenta));

		cuentaOptional = CuentaEntity.from(cuentaDto);
		cuentaOptional.setId(idCuenta);

		return cuentaRepository.save(cuentaOptional);

	}

	@Override
	public void borrarCuenta(String idCuenta) {

		CuentaEntity cuentaOptional = cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> CuentaException.from("No se encontro la cuenta: " + idCuenta, idCuenta));

		cuentaRepository.delete(cuentaOptional);
	}

	@Override
	public CuentaEntity validaCuenta(String email, String password) {

		return cuentaRepository.findByEmailAndPasswordAndEstatus(email, password, Boolean.TRUE)
				.orElseThrow(() -> CuentaException.from("No se encontro la cuenta, es necesario registrarse!", email));

	}

	@Override
	public List<NegocioDto> obtenerNegociosByCuenta(String idCuenta) {

		List<NegocioDto> negocioList = negocioApiClient.obtenerNegocioByCuenta(idCuenta);

		return negocioList;
	}

}
