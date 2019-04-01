package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.ServiciosDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class ServiciosNegocioRepositoryImpl extends SpringJdbcDao implements ServiciosNegocioRepository {

	private String qryNegociosServicios = "INSERT INTO negocios_servicios (id_negocio,id_servicio) VALUES(?,?)";
	private String qrySelectServiciosNegocioByNegocio = "select * from negocios_servicios a, cat_servicios  b "
			+ " where a.id_servicio = b.id"
			+ " and a.id_negocio = ?";

	private String qryUpdateServicio = "UPDATE negocios_servicios SET id_servicio=?";
	private String qryDelete = "DELETE FROM negocios_servicios WHERE id_negocio=?";

	@Override
	public void guardar(String idNegocio, String idServicio) {
		jdbcTemplate.update(qryNegociosServicios, idNegocio, idServicio);
	}

	@Override
	public List<ServiciosDto> findServicios(String idNeg) {

		return jdbcTemplate.query(qrySelectServiciosNegocioByNegocio, new Object[] { idNeg },BeanPropertyRowMapper.newInstance(ServiciosDto.class));
	}

	@Override
	public void eliminar(String idNegocio) {
		jdbcTemplate.update(qryDelete, idNegocio);
	}

}
