package com.hazloakki.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.login.modelo.LoginDto;
import com.hazloakki.login.service.remoto.CuentaApiClient;
import com.hazloakki.login.service.remoto.CuentaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private CuentaApiClient cuentaApiClient;
	
	@Override
	public LoginDto existCuenta(String email, String password) {
		
		LoginDto loginDto  =null;
		CuentaDto cuentaDto = cuentaApiClient.validaCuentaExist(email, password);
		Optional<CuentaDto> optionalProject = Optional.ofNullable(cuentaDto);
		
		if(optionalProject.isPresent()) {
			loginDto  = new LoginDto();
			loginDto.setIdCuenta(cuentaDto.getIdCuenta());
			loginDto.setNombre(cuentaDto.getNombre());
			loginDto.setApellidos(cuentaDto.getApellidos());
			loginDto.setTelefono(cuentaDto.getTelefono());
			loginDto.setEstatus(cuentaDto.isEstatus());
			loginDto.setFecha(cuentaDto.getFecha());
			loginDto.setEmail(cuentaDto.getEmail());
		}
		
		return loginDto;
	}

}
