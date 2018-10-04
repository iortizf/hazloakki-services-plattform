package com.hazloakki.negocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.negocio.api.CategoriasNegociosException;
import com.hazloakki.negocio.modelo.CatCategoriaNegocioDto;
import com.hazloakki.negocio.repository.CatCategoriaNegocioRepository;

@Service
public class CatTipoNegocioServiceImpl implements CatTipoNegocioService {

	@Autowired
	private CatCategoriaNegocioRepository catCategoriaNegocioRepository;

	@Override
	public List<CatCategoriaNegocioDto> obtenerTipoNegocioAll() {

		return catCategoriaNegocioRepository.obtenerCategoriasNegocio();
	}

	@Override
	public CatCategoriaNegocioDto obtenerTipoNegocioById(Integer idCategoria) {

		CatCategoriaNegocioDto catCategoriaNegocioDto = catCategoriaNegocioRepository
				.obtenerCategoriaPorId(String.valueOf(idCategoria));
		
		Optional<CatCategoriaNegocioDto> categoriaNegocio = Optional.of(catCategoriaNegocioDto);

		if (categoriaNegocio.isPresent()) {
			return catCategoriaNegocioDto;
		} else {
			throw new CategoriasNegociosException("No se encontro la categoria de negocio soliciada",
					String.valueOf(idCategoria));
		}

	}

}
