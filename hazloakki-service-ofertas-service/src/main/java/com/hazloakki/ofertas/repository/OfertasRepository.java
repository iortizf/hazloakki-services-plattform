package com.hazloakki.ofertas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.ofertas.entity.OfertaEntity;

/**
 * @author Jovani Arzate
 * 2018-07-25
 * HazloAkki para Empresas v.1
 *
 */
@Repository
public interface OfertasRepository extends JpaRepository<OfertaEntity, String>{

	Optional<OfertaEntity> findByIdNegocioAndEstatus(String idNegocio,boolean estatus);
	List<OfertaEntity> findAllByIdNegocioAndEstatus(String idNegocio,boolean estatus);
	
}
