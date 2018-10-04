package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.ServiciosDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class CatServiciosRepositoryImpl extends SpringJdbcDao implements CatServiciosRepository {

	private String qrySelect = "SELECT * FROM cat_servicios";

	@Override
	public List<ServiciosDto> findByEstatus(boolean estatus) {
		return jdbcTemplate.query(qrySelect, new Object[] { estatus },
				BeanPropertyRowMapper.newInstance(ServiciosDto.class));
	}

}
