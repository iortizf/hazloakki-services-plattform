package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.MetodoPagoDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class NegocioMetodoPagoRepositoryImpl extends SpringJdbcDao implements NegocioMetodoPagoRepository {

	private String qryInsertMetodosPagoNegocio = "INSERT INTO negocios_metodo_pago (id_negocio,id_pago) VALUES(?,?)";
	private String qrySelectMetodosPagoNegocio = "SELECT * FROM negocios_metodo_pago a, cat_metodo_pago b "
			+ " WHERE a.id_pago=b.id"
			+ " AND ID_NEGOCIO = ?";
	private String qryDelete = "DELETE FROM negocios_metodo_pago WHERE ID_NEGOCIO=?";

	@Override
	public void guardar(String idNegocio, String idMetodoPago) {
		jdbcTemplate.update(qryInsertMetodosPagoNegocio, idNegocio, idMetodoPago);
	}

	@Override
	public List<MetodoPagoDto> consultar(String idNegocio) {
		return jdbcTemplate.query(qrySelectMetodosPagoNegocio, new Object[] { idNegocio },
				BeanPropertyRowMapper.newInstance(MetodoPagoDto.class));
	}

	@Override
	public void eliminar(String idNegocio) {
		jdbcTemplate.update(qryDelete, idNegocio);
	}

}
