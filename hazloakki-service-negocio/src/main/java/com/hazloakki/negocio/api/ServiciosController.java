package com.hazloakki.negocio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.negocio.modelo.ServiciosDto;
import com.hazloakki.negocio.service.ServiciosService;

@RestController
@RequestMapping("/api/v1/catalogos/servicios")
@CrossOrigin(origins = "*")
public class ServiciosController {

	@Autowired
	private ServiciosService serviciosService;

	@GetMapping
	public List<ServiciosDto> serviciosToNegocios() {

		return serviciosService.obtenerServiciosActivo();
	}
}
