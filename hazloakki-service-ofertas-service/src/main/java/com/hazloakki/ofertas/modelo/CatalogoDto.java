package com.hazloakki.ofertas.modelo;

import java.util.List;

public class CatalogoDto {
	
	private Integer idCatalogo;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private List<ElementoDto> elementos;
	
	public Integer getIdCatalogo() {
		return idCatalogo;
	}
	public void setIdCatalogo(Integer idCatalogo) {
		this.idCatalogo = idCatalogo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
	public List<ElementoDto> getElementos() {
		return elementos;
	}
	public void setElementos(List<ElementoDto> elementos) {
		this.elementos = elementos;
	}
	
	

}
