package com.hazloakki.catalogos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.catalogos.entity.CatTipoNegocioEntity;

@Repository
public interface CatTipoNegocioRepository extends JpaRepository<CatTipoNegocioEntity,Integer>{

	Optional<CatTipoNegocioEntity> findByIdCategoria(Integer idCategoria);
}
