//package com.hazloakki.negocio.entity;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//@Entity
//@Table(name="cat_categoria_negocios")
//public class CatCategoriasNegociosEntity {
//
//	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
//	@Column(name="id_categoria")
//	private String idCategoria;
//	private String nombre;
//	private String descripcion;
//	private boolean estatus;
//	private String fecha;
//
//	public String getIdCategoria() {
//		return idCategoria;
//	}
//
//	public void setIdCategoria(String idCategoria) {
//		this.idCategoria = idCategoria;
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
//	public String getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(String fecha) {
//		this.fecha = fecha;
//	}
//
//}
