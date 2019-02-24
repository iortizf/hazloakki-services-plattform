package com.hazloakki.ofertas.modelo;

import java.util.Date;

public class Configuracion {
	
	/**
	 * La fecha que se va lanzar la oferta
	 */
	private Date inicio;
	/**
	 * Indica la fecha fin de la oferta
	 */
	private Date fin;
	/**
	 * Establece cuando se hizo la ultima modificacion
	 * a la configuración de la oferta
	 */
	private Date fechaModificacion;
	/**
	 * Id del catalogo de tiempo de recordatorio 
	 * (1=Ninguno,2=5 min. antes, 3=10 min. antes)
	 */
	private Integer tiempoRecordatorioInicio;
	private Integer tiempoRecordatorioFin;
	/**
	 * Establece el tipo de alerta 
	 * (1=Notificación, 2=Correo, 3=Ambos)
	 */
	private Integer tipoAlerta;
	
	
	public static Configuracion from(ConfiguracionDto configDto) {
		Configuracion config = new Configuracion();
		config.setInicio(configDto.getFechaInicio());
		config.setFin(configDto.getFechaFin());
		config.setFechaModificacion(new Date());
		config.setTiempoRecordatorioInicio(configDto.getTiempoRecordatorioInicio());
		config.setTiempoRecordatorioFin(configDto.getTiempoRecordatorioFin());
		config.setTipoAlerta(configDto.getTipoAlerta());
		return config;
	}
	
	public ConfiguracionDto to() {
		ConfiguracionDto configDto = new ConfiguracionDto();
		configDto.setFechaInicio(getInicio());
		configDto.setFechaFin(getFin());
		configDto.setFechaModificacion(getFechaModificacion());
		configDto.setTiempoRecordatorioInicio(getTiempoRecordatorioInicio());
		configDto.setTiempoRecordatorioFin(getTiempoRecordatorioFin());
		configDto.setTipoAlerta(getTipoAlerta());
		return configDto;
	}
	
	
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFin() {
		return fin;
	}
	public void setFin(Date fin) {
		this.fin = fin;
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
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	
}
