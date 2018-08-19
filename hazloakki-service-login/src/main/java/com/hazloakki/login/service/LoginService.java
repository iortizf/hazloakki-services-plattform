package com.hazloakki.login.service;

import com.hazloakki.login.modelo.LoginDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public interface LoginService {

	LoginDto existCuenta(String email, String password);

}
