package com.hazloakki.ofertas.modelo;

import java.util.ArrayList;
import java.util.Date;
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
	private Date fechaAlta;
	private Date fechaModificacion;
	private ConfiguracionDto configuracion;
	private List<String> acciones = new ArrayList<>();
	
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
	public Date getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public ConfiguracionDto getConfiguracion() {
		return configuracion;
	}
	public void setConfiguracion(ConfiguracionDto configuracion) {
		this.configuracion = configuracion;
	}
	public List<String> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<String> acciones) {
		this.acciones = acciones;
	}	
	
}
