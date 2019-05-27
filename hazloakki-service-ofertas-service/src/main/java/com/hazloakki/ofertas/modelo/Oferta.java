package com.hazloakki.ofertas.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="oferta")
public class Oferta {
	
	@Id
	private String id;
	private String idNegocio;
	private String titulo;
	private String descripcion;
	private String fechaAlta;
	private String fechaModificacion;
	private Configuracion config;
	private List<Integer> acciones = new ArrayList<>();
	
	public static Oferta from(OfertaDto ofertaDto) {
		
		Oferta oferta = new Oferta();
		oferta.setId(ofertaDto.getIdOferta());
		oferta.setConfig(Configuracion.from(ofertaDto.getConfiguracion()));
		oferta.setTitulo(ofertaDto.getTitulo());
		oferta.setDescripcion(ofertaDto.getDescripcion());
		oferta.setIdNegocio(ofertaDto.getIdNegocio());
		oferta.setAcciones(ofertaDto.getAcciones());
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String formatDateTime = now.format(formatter);
		if(oferta.getId()!=null) {			
			oferta.setFechaModificacion(formatDateTime);
		}else {
			oferta.setFechaAlta(formatDateTime);
			oferta.setFechaModificacion(formatDateTime);
		}
		
		return oferta;
	}
	
	public OfertaDto to() {
		
		OfertaDto ofertaDto = new OfertaDto();
		ofertaDto.setIdOferta(getId());
		ofertaDto.setConfiguracion(getConfig().to());
		ofertaDto.getConfiguracion().setIdOferta(getId());
		ofertaDto.setTitulo(getTitulo());
		ofertaDto.setDescripcion(getDescripcion());
		ofertaDto.setIdNegocio(getIdNegocio());
		ofertaDto.setAcciones(getAcciones());
		ofertaDto.setFechaAlta(getFechaAlta());
		ofertaDto.setFechaModificacion(getFechaModificacion());
		
		return ofertaDto;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Configuracion getConfig() {
		return config;
	}
	public void setConfig(Configuracion config) {
		this.config = config;
	}

	public List<Integer> getAcciones() {
		return acciones;
	}

	public void setAcciones(List<Integer> acciones) {
		this.acciones = acciones;
	}
	

}
