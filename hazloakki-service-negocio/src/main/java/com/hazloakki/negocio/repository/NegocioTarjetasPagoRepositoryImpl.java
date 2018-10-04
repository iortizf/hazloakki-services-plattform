package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.TipoTarjetaDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;

@Repository
public class NegocioTarjetasPagoRepositoryImpl extends SpringJdbcDao implements NegocioTarjetasPagoRepository {

	private String qryInsert = "INSERT INTO negocios_tarjetas (id_negocio,id_tarjeta) VALUES(?,?)";
	private String qrySelect = "SELECT * FROM negocios_tarjetas a , cat_tipo_tarjeta b "
			+ " WHERE a.id_tarjeta = b.id"
			+ " AND ID_NEGOCIO = ?";
	private String qryDelete = "DELETE FROM negocios_tarjetas WHERE ID_NEGOCIO = ?";

	@Override
	public void guardar(String idNegocio, String idTipoTarjetaPago) {
		jdbcTemplate.update(qryInsert, idNegocio, idTipoTarjetaPago);

	}

	@Override
	public List<TipoTarjetaDto> findByIdNegocio(String idNegocio) {
		return jdbcTemplate.query(qrySelect, new Object[] { idNegocio },
				BeanPropertyRowMapper.newInstance(TipoTarjetaDto.class));
	}

	@Override
	public void eliminar(String idNegocio) {
		jdbcTemplate.update(qryDelete,idNegocio);
	}

}
