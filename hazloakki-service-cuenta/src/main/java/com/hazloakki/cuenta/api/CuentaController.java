package com.hazloakki.cuenta.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.cuenta.modelo.CuentaDto;
import com.hazloakki.cuenta.service.CuentaService;
import com.hazloakki.cuenta.service.remoto.NegocioDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/cuentas")
public class CuentaController {
	@Autowired
	private CuentaService cuentaService;

	@PostMapping
	@ResponseStatus(CREATED)
	public CuentaDto crearCuenta(@Valid @RequestBody CuentaDto cuentaDto) {
		return cuentaService.guardarCuenta(cuentaDto).to();
	}

	@GetMapping("/{id}")
	public CuentaDto readCuenta(@PathVariable("id") String idCuenta) {
		return cuentaService.obtenerCuenta(idCuenta).to();
	}

	@PutMapping("/{id}")
	public CuentaDto updateCuenta(@PathVariable("id") String idCuenta, @Valid @RequestBody CuentaDto cuentaDto) {
		return cuentaService.modificarCuenta(idCuenta, cuentaDto).to();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public void borraCuenta(@PathVariable("id") String idCuenta) {
		cuentaService.borrarCuenta(idCuenta);
	}

	@GetMapping("/{email}/{password}")
	@ResponseStatus(OK)
	public CuentaDto loginCuenta(@PathVariable("email") String email, @PathVariable("password") String password) {
		return cuentaService.validaCuenta(email, password).to();
	}
	
	@GetMapping("/{id}/negocios")
	public List<NegocioDto> obtenerNegociosByCuenta(@PathVariable("id") String idCuenta) {
		return cuentaService.obtenerNegociosByCuenta(idCuenta);
	}
	
	@GetMapping("/{id}/negocios/{id}")
	public List<NegocioDto> obtenerNegociosByCuentaAndNegocio(@PathVariable("id") String idCuenta) {
		return null;//cuentaService.obtenerOneNegocioByCuenta(idCuenta);
	}

}
