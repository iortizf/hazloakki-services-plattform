package com.hazloakki.ofertas.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="catalogo")
public class Catalogo {
	
	@Id
	private Integer idCatalogo;
	private String nombre;
	private String descripcion;
	private Integer estatus;
	private List<Elemento> elementos = new ArrayList<>();
	
	
	public static Catalogo from(CatalogoDto catDto){
		Catalogo cat = new Catalogo();
		cat.setIdCatalogo(catDto.getIdCatalogo());
		cat.setNombre(catDto.getNombre());
		cat.setDescripcion(catDto.getDescripcion());
		return cat;
	}
	
	public CatalogoDto to() {
		CatalogoDto catDto=new CatalogoDto();
		catDto.setNombre(getNombre());
		catDto.setDescripcion(getDescripcion());
		catDto.setEstatus(getEstatus());
		catDto.setIdCatalogo(getIdCatalogo());
		catDto.setElementos(getElementos().stream().map(e-> e.to()).collect(Collectors.toList()));
		return catDto;
	}
	
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
	public List<Elemento> getElementos() {
		return elementos;
	}
	public void setElementos(List<Elemento> elementos) {
		this.elementos = elementos;
	}
	
	
	

}
