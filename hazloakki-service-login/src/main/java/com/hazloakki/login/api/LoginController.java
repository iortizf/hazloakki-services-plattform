package com.hazloakki.login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.login.modelo.LoginDto;
import com.hazloakki.login.service.LoginService;


/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/authentifications")
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("/{email}/{password}")
	public LoginDto validaCuenta(@PathVariable("email") String email, @PathVariable("password") String password) {
		return loginService.existCuenta(email, password);
	}
	
	
}
