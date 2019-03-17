package com.hazloakki.ofertas.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConfiguracionDto {
	
	private String idOferta;
	private Integer idEstatus;
	private Date inicio;
	private Date fin;
	private Date fechaModificacion;
	private Integer idRecordatorioInicio;
	private Integer idRecordatorioFin;	
	private List<Integer> idTipoAlerta = new ArrayList<>();;
	private Integer distancia;
	private Double precio;
	private String cupon;
	private Integer idTemperatura;
	
	public String getIdOferta() {
		return idOferta;
	}
	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
	}
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
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
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	public Integer getIdRecordatorioInicio() {
		return idRecordatorioInicio;
	}
	public void setIdRecordatorioInicio(Integer idRecordatorioInicio) {
		this.idRecordatorioInicio = idRecordatorioInicio;
	}
	public Integer getIdRecordatorioFin() {
		return idRecordatorioFin;
	}
	public void setIdRecordatorioFin(Integer idRecordatorioFin) {
		this.idRecordatorioFin = idRecordatorioFin;
	}	
	public List<Integer> getIdTipoAlerta() {
		return idTipoAlerta;
	}
	public void setIdTipoAlerta(List<Integer> idTipoAlerta) {
		this.idTipoAlerta = idTipoAlerta;
	}
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public String getCupon() {
		return cupon;
	}
	public void setCupon(String cupon) {
		this.cupon = cupon;
	}
	public Integer getIdTemperatura() {
		return idTemperatura;
	}
	public void setIdTemperatura(Integer idTemperatura) {
		this.idTemperatura = idTemperatura;
	}	
	

}
