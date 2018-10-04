package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.MetodoPagoDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class CatMetodoPagoRepositoryImpl extends SpringJdbcDao implements CatMetodoPagoRepository {

	private String qrySelectAll = "SELECT * FROM cat_metodo_pago";

	@Override
	public List<MetodoPagoDto> findByEstatus(boolean estatus) {
		return jdbcTemplate.query(qrySelectAll, new Object[] {estatus}, BeanPropertyRowMapper.newInstance(MetodoPagoDto.class));
	}

}
