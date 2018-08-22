package com.hazloakki.negocio.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "negocios_metodo_pago")
public class NegocioMetodoPagoEntity {

	@EmbeddedId
	private NegocioMetodoPagoKey negocioMetodoPagoKey;

	public NegocioMetodoPagoKey getNegocioMetodoPagoKey() {
		return negocioMetodoPagoKey;
	}

	public void setNegocioMetodoPagoKey(NegocioMetodoPagoKey negocioMetodoPagoKey) {
		this.negocioMetodoPagoKey = negocioMetodoPagoKey;
	}

}
