package com.hazloakki.negocio.repository;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.modelo.CatCategoriaNegocioDto;
import com.hazloakki.negocio.persist.SpringJdbcDao;
@Repository
public class CatCategoriaNegocioRepositoryImpl extends SpringJdbcDao implements CatCategoriaNegocioRepository {

	private String qrySelectAllCategorias = "SELECT * FROM cat_categoria_negocios";
	private String qrySelectCategoriaById = "SELECT * FROM cat_categoria_negocios WHERE ID_CATEGORIA = ?";

	@Override
	public List<CatCategoriaNegocioDto> obtenerCategoriasNegocio() {
		return jdbcTemplate.query(qrySelectAllCategorias,
				BeanPropertyRowMapper.newInstance(CatCategoriaNegocioDto.class));
	}

	@Override
	public CatCategoriaNegocioDto obtenerCategoriaPorId(String idCategoria) {
		return jdbcTemplate.queryForObject(qrySelectCategoriaById, new Object[] { idCategoria },
				BeanPropertyRowMapper.newInstance(CatCategoriaNegocioDto.class));
	}

}
