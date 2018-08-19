package com.hazloakki.catalogos.service;

import java.util.List;

import com.hazloakki.catalogos.entity.CatTipoNegocioEntity;

public interface CatTipoNegocioService {
	
	List<CatTipoNegocioEntity> obtenerTipoNegocioAll();
	CatTipoNegocioEntity obtenerTipoNegocioById(Integer idCategoria);
}
