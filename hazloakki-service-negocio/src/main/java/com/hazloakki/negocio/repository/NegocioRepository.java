package com.hazloakki.negocio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.negocio.entity.NegocioEntity;

/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
@Repository
public interface NegocioRepository extends JpaRepository<NegocioEntity, String>{

	Optional<NegocioEntity> findById(String idNegocio);
	List<NegocioEntity> findByIdCuentaAndEstatus(String idCuenta,boolean estatus);
}
