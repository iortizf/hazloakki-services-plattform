package com.hazloakki.cuenta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.cuenta.entity.CuentaEntity;

/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, String>{

	Optional<CuentaEntity> findById(String id);
	Optional<CuentaEntity> findByEmailAndPasswordAndEstatus(String email, String password, boolean estatus);
}
