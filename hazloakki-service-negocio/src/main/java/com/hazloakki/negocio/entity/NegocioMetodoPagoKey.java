package com.hazloakki.negocio.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NegocioMetodoPagoKey implements Serializable {

	private String idNegocio;
	private String idPago;

	public String getIdNegocio() {
		return idNegocio;
	}

	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}

	public String getIdPago() {
		return idPago;
	}

	public void setIdPago(String idPago) {
		this.idPago = idPago;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idNegocio == null) ? 0 : idNegocio.hashCode());
		result = prime * result + ((idPago == null) ? 0 : idPago.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NegocioMetodoPagoKey other = (NegocioMetodoPagoKey) obj;
		if (idNegocio == null) {
			if (other.idNegocio != null)
				return false;
		} else if (!idNegocio.equals(other.idNegocio))
			return false;
		if (idPago == null) {
			if (other.idPago != null)
				return false;
		} else if (!idPago.equals(other.idPago))
			return false;
		return true;
	}

}
