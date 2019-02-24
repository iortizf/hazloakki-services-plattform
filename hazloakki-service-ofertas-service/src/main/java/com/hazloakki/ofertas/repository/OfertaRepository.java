package com.hazloakki.ofertas.repository;

import java.util.List;

import com.hazloakki.ofertas.modelo.Configuracion;
import com.hazloakki.ofertas.modelo.Oferta;

public interface OfertaRepository{

	Oferta guardar(Oferta nuevaOferta);
	List<Oferta> obtenerByIdNegocio(String idNegocio);
	void modificar(Oferta oferta);
	void eliminar(String id);
	Oferta obtenerById(String id);
	Configuracion obtenerConfig(String id);
	Configuracion guardarConfig(String id, Configuracion config);
}
