package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.TipoTarjetaDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class TarjetasPagoRepositoryImpl extends SpringJdbcDao implements TarjetasPagoRepository {

	private String qrySelectByEstatus = "SELECT * FROM cat_tipo_tarjeta WHERE ESTATUS=?";

	@Override
	public List<TipoTarjetaDto> findByEstatus(boolean estatus) {
		return jdbcTemplate.query(qrySelectByEstatus, new Object[] { estatus },
				BeanPropertyRowMapper.newInstance(TipoTarjetaDto.class));
	}

}
