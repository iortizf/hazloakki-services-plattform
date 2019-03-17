package com.hazloakki.ofertas.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.ofertas.modelo.CatalogoDto;
import com.hazloakki.ofertas.service.CatalogoService;

@RestController
@RequestMapping("/api/v1/ofertas/catalogos")
public class CatalogoOfertaController {
	
	
	@Autowired
	private CatalogoService catalogoService;
	
	
	@GetMapping("/{idCatalogo}")
	private CatalogoDto obtenerCatalogo(
			@PathVariable("idCatalogo") Integer idCatalogo) {
		return catalogoService.obtenerById(idCatalogo);
	}

}
