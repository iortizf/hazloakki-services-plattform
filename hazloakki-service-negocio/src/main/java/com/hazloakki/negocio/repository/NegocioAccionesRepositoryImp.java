package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.persist.SpringJdbcDao;

@Repository
public class NegocioAccionesRepositoryImp extends SpringJdbcDao implements NegocioAccionesRepository {

	private String qryInsertNegocioAcciones = "INSERT INTO negocios_acciones (id_negocio, id_accion) VALUES( ?, ?)";
	private String qrySelectAccionesNegocio = "SELECT id_accion FROM negocios_acciones  WHERE id_negocio = ?";
	private String qryDeleteAccionesNegocio = "DELETE FROM negocios_acciones WHERE id_negocio = ?";
	private String qryUpdateAccionesNegocio = "UPDATE negocios_acciones SET id_accion=? WHERE id_negocio = ?";
	
	@Override
	public void guardar(String idNegocio, Integer idAccion) {
		jdbcTemplate.update(qryInsertNegocioAcciones, idNegocio, idAccion);
	}

	@Override
	public void eliminar(String idNegocio) {
		jdbcTemplate.update(qryDeleteAccionesNegocio, idNegocio);
	}

	@Override
	public List<Integer> acciones(String idNegocio) {
		return jdbcTemplate.query(qrySelectAccionesNegocio, new Object[] { idNegocio }, (rs, rowNum) -> rs.getInt("id_accion"));
	}

	@Override
	public void actualizar(String idNegocio, Integer idAccion) {
		jdbcTemplate.update(qryUpdateAccionesNegocio, idAccion, idNegocio);		
	}

}
