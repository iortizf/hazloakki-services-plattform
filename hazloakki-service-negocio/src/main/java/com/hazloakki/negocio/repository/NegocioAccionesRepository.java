package com.hazloakki.negocio.repository;

import java.util.List;

public interface NegocioAccionesRepository {
	
	void guardar(String idNegocio, String idAccion);
	void eliminar(String idNegocio);
	List<String> acciones(String idNegocio);

}
