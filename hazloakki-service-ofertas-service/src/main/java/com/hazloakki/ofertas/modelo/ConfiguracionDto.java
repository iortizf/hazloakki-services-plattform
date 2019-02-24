package com.hazloakki.ofertas.modelo;

import java.util.Date;

public class ConfiguracionDto {
	
	private String idOferta;
	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaModificacion;
	private Integer tiempoRecordatorioInicio;
	private Integer tiempoRecordatorioFin;	
	private Integer tipoAlerta;
	
	public String getIdOferta() {
		return idOferta;
	}
	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Integer getTiempoRecordatorioInicio() {
		return tiempoRecordatorioInicio;
	}
	public void setTiempoRecordatorioInicio(Integer tiempoRecordatorioInicio) {
		this.tiempoRecordatorioInicio = tiempoRecordatorioInicio;
	}
	public Integer getTiempoRecordatorioFin() {
		return tiempoRecordatorioFin;
	}
	public void setTiempoRecordatorioFin(Integer tiempoRecordatorioFin) {
		this.tiempoRecordatorioFin = tiempoRecordatorioFin;
	}
	public Integer getTipoAlerta() {
		return tipoAlerta;
	}
	public void setTipoAlerta(Integer tipoAlerta) {
		this.tipoAlerta = tipoAlerta;
	}
	
	

}
