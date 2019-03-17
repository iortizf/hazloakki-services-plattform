package com.hazloakki.ofertas.repository;

import com.hazloakki.ofertas.modelo.Catalogo;

public interface CatalogoRepository {

	void guardar(Catalogo catalogo);
	Catalogo obtenerById(Integer idCatalogo);
}
