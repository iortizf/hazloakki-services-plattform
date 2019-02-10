package com.hazloakki.ofertas.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ofertas_acciones")
public class OfertaAccionesEntity {
	
	@EmbeddedId
	private OfertaAccionesId ofertaAcciones;

	public OfertaAccionesId getOfertaAcciones() {
		return ofertaAcciones;
	}

	public void setOfertaAcciones(OfertaAccionesId ofertaAcciones) {
		this.ofertaAcciones = ofertaAcciones;
	}
	
	

}
