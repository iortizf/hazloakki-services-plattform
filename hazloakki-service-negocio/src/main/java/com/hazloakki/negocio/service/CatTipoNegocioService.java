package com.hazloakki.negocio.service;

import java.util.List;

import com.hazloakki.negocio.modelo.CatCategoriaNegocioDto;

public interface CatTipoNegocioService {
	
	List<CatCategoriaNegocioDto> obtenerTipoNegocioAll();
	CatCategoriaNegocioDto obtenerTipoNegocioById(Integer idCategoria);
}
