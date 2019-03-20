package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.HorarioDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;

@Repository
public class HorarioRepositoryImp extends SpringJdbcDao implements HorarioRepository {
	
	private String qryInsert = "INSERT INTO (id_negocio, id_dia, abre, cierra, abierto, veinticuatroHrs) VALUES(?,?,?,?,?,?)";
	private String qryUpdateHorario = "UPDATE negocios_horario set id_dia = ?, abre=?, cierra=?, abierto=?, veinticuatroHrs=? WHERE id_negocio=?";
	private String qryDeleteNegocio = "DELETE FROM negocios_horario WHERE id_negocio = ?";
	private String qryHorarioByNegocio = "SELECT * FROM negocios_horario WHERE id_negocio = ?";

	@Override
	public void guardar(HorarioDto horario) {
		
		jdbcTemplate.update(qryInsert, horario.getIdNegocio(), 
				horario.getIdDia(), horario.getAbre(), 
				horario.getCierra(), horario.isAbierto(), 
				horario.isVeinticuatroHrs());

	}

	@Override
	public void actualizar(HorarioDto horario) {
		jdbcTemplate.update(qryUpdateHorario, horario.getIdDia(), horario.getAbre(), 
				horario.getCierra(), horario.isAbierto(), 
				horario.isVeinticuatroHrs(), horario.getIdNegocio());
	}

	@Override
	public List<HorarioDto> horarioByIdNegocio(String idNegocio) {
		return jdbcTemplate.query(qryHorarioByNegocio, new Object[] { idNegocio },
				BeanPropertyRowMapper.newInstance(HorarioDto.class));
	}

	@Override
	public void eliminarHorarioNegocio(String idNegocio) {
		jdbcTemplate.update(qryDeleteNegocio, idNegocio);		
	}
	

}
