package com.hazloakki.catalogos.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.catalogos.entity.CatTipoNegocioEntity;
import com.hazloakki.catalogos.service.CatTipoNegocioService;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/catalogos")
public class CatalogosController {
	
	@Autowired
	private CatTipoNegocioService catTipoNegocioService;

	@GetMapping("/negocios/categorias")
	public List<CatTipoNegocioEntity> readAllTipoNegocio() {
		return catTipoNegocioService.obtenerTipoNegocioAll();
	}
	
	@GetMapping("/negocios/categorias/{id}")
	public CatTipoNegocioEntity readTipoNegocio(@PathVariable("id") Integer idCategoria) {
		return catTipoNegocioService.obtenerTipoNegocioById(idCategoria);
	}

}
