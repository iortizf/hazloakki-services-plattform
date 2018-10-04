//package com.hazloakki.negocio.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class NegociosTarjetasPagoKey implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	
//	@Column(name="id_negocio", insertable=false, updatable=false)
//	private String idNegocio;
//	@Column(name="id_tarjeta", insertable=false, updatable=false)
//	private String idTarjeta;
//
//	public String getIdNegocio() {
//		return idNegocio;
//	}
//
//	public void setIdNegocio(String idNegocio) {
//		this.idNegocio = idNegocio;
//	}
//
//	public String getIdTarjeta() {
//		return idTarjeta;
//	}
//
//	public void setIdTarjeta(String idTarjeta) {
//		this.idTarjeta = idTarjeta;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((idNegocio == null) ? 0 : idNegocio.hashCode());
//		result = prime * result + ((idTarjeta == null) ? 0 : idTarjeta.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		NegociosTarjetasPagoKey other = (NegociosTarjetasPagoKey) obj;
//		if (idNegocio == null) {
//			if (other.idNegocio != null)
//				return false;
//		} else if (!idNegocio.equals(other.idNegocio))
//			return false;
//		if (idTarjeta == null) {
//			if (other.idTarjeta != null)
//				return false;
//		} else if (!idTarjeta.equals(other.idTarjeta))
//			return false;
//		return true;
//	}
//
//}
