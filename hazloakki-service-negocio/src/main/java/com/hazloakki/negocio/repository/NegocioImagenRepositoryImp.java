package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.ImagenDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;

@Repository
public class NegocioImagenRepositoryImp extends SpringJdbcDao implements NegocioImagenRepository {
	
	private String qryInsertImagen ="INSERT INTO negocio_imagen (id_imagen, id_negocio, ruta_imagen, perfil) VALUES (?,?,?,?)";
	private String qryDeleteImagen = "DELETE FROM negocio_imagen WHERE id_imagen = ?";
	private String qryDeleteImagenes = "DELETE FROM negocio_imagen WHERE id_negocio = ? and id_imagen = ?";
	private String qrySelectImagenes = "SELECT * FROM negocio_imagen WHERE id_negocio = ?";
	

	@Override
	public String guardar(String idNegocio, ImagenDto imagenDto) {
		
		imagenDto.setIdImagen(generadorLlaves());
		jdbcTemplate.update(qryInsertImagen, imagenDto.getIdImagen(), imagenDto.getIdNegocio(),
				imagenDto.getRutaImagen(), imagenDto.isPerfil() );
		
		return imagenDto.getIdImagen();
	}

	@Override
	public void eliminarById(String idNegocio,String idImagen) {
		jdbcTemplate.update(qryDeleteImagen, idImagen);
	}

	@Override
	public void eliminarByIdNegocio(String idNegocio) {
		jdbcTemplate.update(qryDeleteImagenes, idNegocio);
	}

	@Override
	public List<ImagenDto> obtenerByIdNegocio(String idNegocio) {
		return jdbcTemplate.query(qrySelectImagenes, new Object[] { idNegocio },
				BeanPropertyRowMapper.newInstance(ImagenDto.class));
	}

}
