package com.hazloakki.ofertas.modelo;

import java.util.ArrayList;
import java.util.List;

public class ConfiguracionDto {
	
	private String idOferta;
	private Integer idEstatus;
	private String inicio;
	private String fin;
	private String fechaModificacion;
	private Integer idRecordatorioInicio;
	private Integer idRecordatorioFin;	
	private List<Integer> idTipoAlerta = new ArrayList<>();;
	private Double distancia;
	private Double precio;
	private String cupon;
	private Integer idTemperatura;
	private Integer idGenero;
	
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
	public String getInicio() {
		return inicio;
	}
	public void setInicio(String inicio) {
		this.inicio = inicio;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(String fechaModificacion) {
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
	
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	public Integer getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
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
