//package com.hazloakki.negocio.entity;
//
//import java.io.Serializable;
//import javax.persistence.*;
//
///**
// * The persistent class for the negocios_metodo_pago database table.
// * 
// */
//@Entity
//@Table(name = "negocios_metodo_pago")
//public class NegociosMetodoPago implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	
//	@EmbeddedId
//	private NegociosMetodoPagoPK id;
//
//	// bi-directional many-to-one association to Negocio
//	@ManyToOne
//	@JoinColumn(name = "id_negocio", insertable = false, updatable = false)
//	private NegocioEntity negocio;
//
//	@ManyToOne
//	@JoinColumn(name = "id_pago", insertable = false, updatable = false)
//	private CatMetodoPagoEntity catMetodoPagoEntity;
//
//	public NegociosMetodoPago() {
//	}
//
//	public NegociosMetodoPagoPK getId() {
//		return this.id;
//	}
//
//	public void setId(NegociosMetodoPagoPK id) {
//		this.id = id;
//	}
//
//	public NegocioEntity getNegocioEntity() {
//		return negocio;
//	}
//
//	public void setNegocioEntity(NegocioEntity negocioEntity) {
//		this.negocio = negocioEntity;
//	}
//
//	public NegocioEntity getNegocio() {
//		return negocio;
//	}
//
//	public void setNegocio(NegocioEntity negocio) {
//		this.negocio = negocio;
//	}
//
//	public CatMetodoPagoEntity getCatMetodoPagoEntity() {
//		return catMetodoPagoEntity;
//	}
//
//	public void setCatMetodoPagoEntity(CatMetodoPagoEntity catMetodoPagoEntity) {
//		this.catMetodoPagoEntity = catMetodoPagoEntity;
//	}
//
//	@Override
//	public String toString() {
//		return "NegociosMetodoPago [id=" + id + ", negocio=" + negocio + ", catMetodoPagoEntity=" + catMetodoPagoEntity
//				+ "]";
//	}
//	
//	
//
//}