package com.hazloakki.ofertas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazloakki.ofertas.entity.OfertaAccionesEntity;
import com.hazloakki.ofertas.entity.OfertaAccionesId;

@Repository
public interface OfertaAccionesRepository extends JpaRepository<OfertaAccionesEntity, OfertaAccionesId> {
	
	List<OfertaAccionesEntity> findByOfertaAccionesIdOferta(String idOferta);
	void deleteByOfertaAccionesIdOferta(String idOferta);	

}
