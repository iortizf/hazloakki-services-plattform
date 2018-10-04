//package com.hazloakki.negocio.entity;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//
//@Embeddable
//public class NegociosServiciosKey implements Serializable{
//
//	@Column(name="id_negocio", insertable=false, updatable=false)
//	private String idNegocio;
//	@Column(name="id_servicio", insertable=false, updatable=false)
//	private String idServicio;
//
//	public String getIdNegocio() {
//		return idNegocio;
//	}
//
//	public void setIdNegocio(String idNegocio) {
//		this.idNegocio = idNegocio;
//	}
//
//	public String getIdServicio() {
//		return idServicio;
//	}
//
//	public void setIdServicio(String idServicio) {
//		this.idServicio = idServicio;
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((idNegocio == null) ? 0 : idNegocio.hashCode());
//		result = prime * result + ((idServicio == null) ? 0 : idServicio.hashCode());
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
//		NegociosServiciosKey other = (NegociosServiciosKey) obj;
//		if (idNegocio == null) {
//			if (other.idNegocio != null)
//				return false;
//		} else if (!idNegocio.equals(other.idNegocio))
//			return false;
//		if (idServicio == null) {
//			if (other.idServicio != null)
//				return false;
//		} else if (!idServicio.equals(other.idServicio))
//			return false;
//		return true;
//	}
//	
//	
//
//}
