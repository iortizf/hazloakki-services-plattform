package com.hazloakki.ofertas.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OfertaAccionesId implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2795088222334891798L;
	
	@Column(name = "id_oferta")
	private String idOferta;
	@Column(name = "id_accion")
	private String idAccion;
	
	public OfertaAccionesId(String idOferta, String idAccion) {
		super();
		this.idOferta = idOferta;
		this.idAccion = idAccion;
	}

	public String getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
	}

	public String getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAccion == null) ? 0 : idAccion.hashCode());
		result = prime * result + ((idOferta == null) ? 0 : idOferta.hashCode());
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
		OfertaAccionesId other = (OfertaAccionesId) obj;
		if (idAccion == null) {
			if (other.idAccion != null)
				return false;
		} else if (!idAccion.equals(other.idAccion))
			return false;
		if (idOferta == null) {
			if (other.idOferta != null)
				return false;
		} else if (!idOferta.equals(other.idOferta))
			return false;
		return true;
	}
	
	

	
	
}
