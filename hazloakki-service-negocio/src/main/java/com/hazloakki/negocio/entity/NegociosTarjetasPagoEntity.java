//package com.hazloakki.negocio.entity;
//
//import javax.persistence.CascadeType;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "negocios_tarjetas")
//public class NegociosTarjetasPagoEntity {
//
//	@EmbeddedId
//	private NegociosTarjetasPagoKey negociosTarjetasPagoKey;
//
//	// bi-directional many-to-one association to Negocio
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "id_negocio", insertable = false, updatable = false)
//	private NegocioEntity negocio;
//
//	@ManyToOne(cascade = CascadeType.PERSIST)
//	@JoinColumn(name = "id_tarjeta", insertable = false, updatable = false)
//	private CatTipoTarjetaEntity catTipoTarjetaEntity;
//
//	public NegociosTarjetasPagoKey getNegociosTarjetasPagoKey() {
//		return negociosTarjetasPagoKey;
//	}
//
//	public void setNegociosTarjetasPagoKey(NegociosTarjetasPagoKey negociosTarjetasPagoKey) {
//		this.negociosTarjetasPagoKey = negociosTarjetasPagoKey;
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
//	public CatTipoTarjetaEntity getCatTipoTarjetaEntity() {
//		return catTipoTarjetaEntity;
//	}
//
//	public void setCatTipoTarjetaEntity(CatTipoTarjetaEntity catTipoTarjetaEntity) {
//		this.catTipoTarjetaEntity = catTipoTarjetaEntity;
//	}
//
//}
