package com.hazloakki.analitica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.analitica.entity.OfertasAnaliticaEntity;

/**
 * @author Jovani Arzate
 * 2018-08-14
 * HazloAkki para Empresas v.1
 *
 */
@Repository
public interface OfertasAnaliticaRepository extends JpaRepository<OfertasAnaliticaEntity, String>{

	List<OfertasAnaliticaEntity> findByIdNegocioAndEstatus(String idNegocio, boolean estatus);
	OfertasAnaliticaEntity findByIdOferta(String idOferta);
	
}
