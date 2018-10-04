//package com.hazloakki.negocio.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.persistence.Version;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import com.hazloakki.negocio.modelo.ServiciosDto;
//
//@Entity
//@Table(name = "cat_servicios")
//public class CatServiciosEntity {
//
//	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
//	@Column(updatable = false)
//	private String id;
//	private String nombre;
//	private String descripcion;
//	private boolean estatus;
//
//	public ServiciosDto to() {
//		ServiciosDto serviciosDto = new ServiciosDto();
//		serviciosDto.setId(getId());
//		serviciosDto.setNombre(getNombre());
//		serviciosDto.setDescripcion(getDescripcion());
//		serviciosDto.setEstatus(isEstatus());
//
//		return serviciosDto;
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
