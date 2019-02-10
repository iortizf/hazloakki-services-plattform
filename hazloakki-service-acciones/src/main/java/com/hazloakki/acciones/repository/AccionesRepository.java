package com.hazloakki.acciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.acciones.entity.AccionesEntity;

@Repository
public interface AccionesRepository extends JpaRepository<AccionesEntity, String>{

	public List<AccionesEntity> findByEstatus(boolean estatus);
}
