package com.hazloakki.negocio.repository;

import java.util.List;

public interface NegocioAccionesRepository {
	
	void guardar(String idNegocio, Integer idAccion);
	void actualizar(String idNegocio, Integer idAccion);
	void eliminar(String idNegocio);
	List<Integer> acciones(String idNegocio);

}
