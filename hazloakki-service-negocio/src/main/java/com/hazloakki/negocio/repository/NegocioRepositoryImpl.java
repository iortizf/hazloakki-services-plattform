package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.NegocioDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class NegocioRepositoryImpl extends SpringJdbcDao implements NegocioRepository {

	private String qryInsert = "INSERT INTO negocio (id_negocio,nombre,id_categoria,email,descripcion,telefono,"
			+ " domicilio,latitud,longitud,estatus,codigo_postal,delegacion,colonia,calle,"
			+ " numero_exterior,horario,responsable,id_cuenta) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	private String qrySelectNegocio = "select * from negocio where id_negocio = ?";

	private String qrySelecNegociosByCuentaAndEstatus = "SELECT * FROM negocio WHERE id_cuenta = ? and estatus = ?";

	private String qryUpdateNegocio = "UPDATE negocio set nombre = ?, id_categoria = ?, email = ?, descripcion = ?,"
			+ " telefono = ?, domicilio = ?, latitud = ?, longitud = ?,  estatus = ?, codigo_postal = ?,"
			+ "  delegacion = ?, colonia = ?, calle = ? , numero_exterior = ?,  horario = ? , responsable = ? , id_cuenta = ? WHERE id_negocio = ?";

	private String qryDeleteNegocio = "DELETE FROM negocio WHERE ID_NEGOCIO = ?";

	@Override
	public String guardar(NegocioDto negocioDto) {

		negocioDto.setIdNegocio(generadorLlaves());

		jdbcTemplate.update(qryInsert, negocioDto.getIdNegocio(), negocioDto.getNombre(), negocioDto.getIdCategoria(),
				negocioDto.getEmail(), negocioDto.getDescripcion(), negocioDto.getTelefono(), negocioDto.getDomicilio(),
				negocioDto.getLatitud(), negocioDto.getLongitud(), negocioDto.isEstatus(), negocioDto.getCodigoPostal(),
				negocioDto.getDelegacion(), negocioDto.getColonia(), negocioDto.getCalle(),
				negocioDto.getNumeroExterior(), negocioDto.getHorario(), negocioDto.getResponsable(),
				negocioDto.getIdCuenta());

		return negocioDto.getIdNegocio();
	}

	@Override
	public NegocioDto findById(String idNegocio) {
		
		try {
			return jdbcTemplate.queryForObject(qrySelectNegocio, new Object[] { idNegocio },
					BeanPropertyRowMapper.newInstance(NegocioDto.class));	
		} catch (EmptyResultDataAccessException e) {
			return null;
		}		
		
	}

	@Override
	public List<NegocioDto> findByIdCuentaAndEstatus(String idCuenta, boolean estatus) {
		return jdbcTemplate.query(qrySelecNegociosByCuentaAndEstatus, new Object[] { idCuenta, estatus },
				BeanPropertyRowMapper.newInstance(NegocioDto.class));
	}

	@Override
	public void actualizarByIdNegocio(String idNegocio, NegocioDto negocioDto) {
		jdbcTemplate.update(qryUpdateNegocio, negocioDto.getNombre(), negocioDto.getIdCategoria(),
				negocioDto.getEmail(), negocioDto.getDescripcion(), negocioDto.getTelefono(), negocioDto.getDomicilio(),
				negocioDto.getLatitud(), negocioDto.getLongitud(), negocioDto.isEstatus(), negocioDto.getCodigoPostal(),
				negocioDto.getDelegacion(), negocioDto.getColonia(), negocioDto.getCalle(),
				negocioDto.getNumeroExterior(), negocioDto.getHorario(), negocioDto.getResponsable(),
				negocioDto.getIdCuenta(), negocioDto.getIdNegocio());
	}

	@Override
	public void eliminarByIdNegocio(String idNegocio) {
		jdbcTemplate.update(qryDeleteNegocio,idNegocio);
	}

}
