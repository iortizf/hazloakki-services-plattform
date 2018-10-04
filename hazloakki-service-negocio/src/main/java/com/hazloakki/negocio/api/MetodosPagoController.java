package com.hazloakki.negocio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.negocio.modelo.MetodoPagoDto;
import com.hazloakki.negocio.service.MetodoPagoServiceImpl;

@RestController
@RequestMapping("/api/v1/catalogos/metodos/pagos")
public class MetodosPagoController {
	
	@Autowired
	private MetodoPagoServiceImpl metodoPagoServiceImpl;

	@GetMapping
	public List<MetodoPagoDto> metodosPago() {

		return metodoPagoServiceImpl.obtenerMetodosPago();
	}
}
