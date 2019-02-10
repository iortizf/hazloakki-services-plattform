package com.hazloakki.acciones.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.acciones.modelo.AccionesDto;
import com.hazloakki.acciones.service.AccionesService;

@RestController
@RequestMapping("/api/v1/acciones")
public class AccionesController {

	@Autowired
	private AccionesService accionesService;

	@GetMapping
	public List<AccionesDto> leerAcciones() {

		return accionesService.obtenerTodasLasAcciones();
	}
}
