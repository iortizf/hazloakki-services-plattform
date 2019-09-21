package com.hazloakki.ubicaciones.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jovani Arzate 
 * 2018-07-26 
 * HazloAkki para Empresas v.1
 *
 */
public class OfertaDto {

	private String idOferta;
	private String idNegocio;
	private String titulo;
	private String descripcion;
	private String fechaAlta;
	private String fechaModificacion;
	private ConfiguracionDto configuracion;
	private List<Integer> acciones = new ArrayList<>();
	
	public String getIdOferta() {
		return idOferta;
	}
	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
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
	public ConfiguracionDto getConfiguracion() {
		return configuracion;
	}
	public void setConfiguracion(ConfiguracionDto configuracion) {
		this.configuracion = configuracion;
	}
	public List<Integer> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<Integer> acciones) {
		this.acciones = acciones;
	}
	
	
}
