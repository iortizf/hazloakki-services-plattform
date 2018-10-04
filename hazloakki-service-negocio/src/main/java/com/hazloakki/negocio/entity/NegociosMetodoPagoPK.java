//package com.hazloakki.negocio.entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
///**
// * The primary key class for the negocios_metodo_pago database table.
// * 
// */
//@Embeddable
//public class NegociosMetodoPagoPK implements Serializable {
//	//default serial version id, required for serializable classes.
//	private static final long serialVersionUID = 1L;
//
//	@Column(name="id_negocio", insertable=false, updatable=false)
//	private String idNegocio;
//
//	@Column(name="id_pago", insertable=false, updatable=false)
//	private String idPago;
//
//	public NegociosMetodoPagoPK() {
//	}
//	public String getIdNegocio() {
//		return this.idNegocio;
//	}
//	public void setIdNegocio(String idNegocio) {
//		this.idNegocio = idNegocio;
//	}
//	public String getIdPago() {
//		return this.idPago;
//	}
//	public void setIdPago(String idPago) {
//		this.idPago = idPago;
//	}
//
//	public boolean equals(Object other) {
//		if (this == other) {
//			return true;
//		}
//		if (!(other instanceof NegociosMetodoPagoPK)) {
//			return false;
//		}
//		NegociosMetodoPagoPK castOther = (NegociosMetodoPagoPK)other;
//		return 
//			this.idNegocio.equals(castOther.idNegocio)
//			&& this.idPago.equals(castOther.idPago);
//	}
//
//	public int hashCode() {
//		final int prime = 31;
//		int hash = 17;
//		hash = hash * prime + this.idNegocio.hashCode();
//		hash = hash * prime + this.idPago.hashCode();
//		
//		return hash;
//	}
//	@Override
//	public String toString() {
//		return "NegociosMetodoPagoPK [idNegocio=" + idNegocio + ", idPago=" + idPago + "]";
//	}
//	
//	
//}