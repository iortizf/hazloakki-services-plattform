package com.hazloakki.ofertas.service;

import com.hazloakki.ofertas.modelo.CatalogoDto;

public interface CatalogoService {
	
	void guardar(CatalogoDto catDto);
	CatalogoDto obtenerById(Integer idCatalogo);
	
}
