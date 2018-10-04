package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.CatCategoriaNegocioDto;

public interface CatCategoriaNegocioRepository{

	List<CatCategoriaNegocioDto> obtenerCategoriasNegocio();
	CatCategoriaNegocioDto obtenerCategoriaPorId(String idCategoria);
}
