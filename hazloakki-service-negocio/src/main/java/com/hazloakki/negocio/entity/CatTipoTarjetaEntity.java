//package com.hazloakki.negocio.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Version;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import com.hazloakki.negocio.modelo.TipoTarjetaDto;
//
//@Entity
//@Table(name = "cat_tipo_tarjeta")
//public class CatTipoTarjetaEntity {
//
//	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
//	private String id;
//	private String nombre;
//	private String descripcion;
//	private boolean estatus;
//	
//	public TipoTarjetaDto to() {
//		
//		TipoTarjetaDto tipoTarjetaDto = new TipoTarjetaDto();
//			tipoTarjetaDto.setId(getId());
//			tipoTarjetaDto.setNombre(getNombre());
//			tipoTarjetaDto.setDescripcion(getDescripcion());
//			tipoTarjetaDto.setEstatus(isEstatus());
//		
//		return tipoTarjetaDto;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//	public boolean isEstatus() {
//		return estatus;
//	}
//
//	public void setEstatus(boolean estatus) {
//		this.estatus = estatus;
//	}
//
//}
