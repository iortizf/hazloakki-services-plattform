package com.hazloakki.negocio.repository;

import java.util.List;

import com.hazloakki.negocio.modelo.HorarioDto;

public interface HorarioRepository {
	
	void guardar(HorarioDto horario);
	void actualizar(HorarioDto horario);
	List<HorarioDto> horarioByIdNegocio(String idNegocio);
	void eliminarHorarioNegocio(String idNegocio);

}
