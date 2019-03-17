package com.hazloakki.ofertas.modelo;

public class ElementoDto {
	
	private Integer idElemento;
	private String nombre;
	private String descripcion;
	
	
	public ElementoDto(Integer idElemento, String nombre, String descripcion) {
		super();
		this.idElemento = idElemento;
		this.nombre = nombre;
		this.descripcion = descripcion;
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

	public Integer getIdElemento() {
		return idElemento;
	}

	public void setIdElemento(Integer idElemento) {
		this.idElemento = idElemento;
	}
	
	
	

}
