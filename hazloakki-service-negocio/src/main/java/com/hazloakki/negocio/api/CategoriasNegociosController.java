package com.hazloakki.negocio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.negocio.modelo.CatCategoriaNegocioDto;
import com.hazloakki.negocio.service.CatTipoNegocioService;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/catalogos/negocios")
@CrossOrigin(origins = "*")
public class CategoriasNegociosController {
	
	@Autowired
	private CatTipoNegocioService catTipoNegocioService;

	@GetMapping("/categorias")
	public List<CatCategoriaNegocioDto> readAllTipoNegocio() {
		return catTipoNegocioService.obtenerTipoNegocioAll();
	}
	
	@GetMapping("/categorias/{id}")
	public CatCategoriaNegocioDto readTipoNegocio(@PathVariable("id") Integer idCategoria) {
		return catTipoNegocioService.obtenerTipoNegocioById(idCategoria);
	}

}
