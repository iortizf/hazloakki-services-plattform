package com.hazloakki.ofertas.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author iortiz
 *
 */
public class Configuracion {
	/**
	 * Estatus de la oferta
	 */
	private Integer idEstatus;
	/**
	 * Opcional: Precio de la oferta
	 */
	private Double precio;
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
	private Integer idRecordatorioInicio;
	private Integer idRecordatorioFin;
	/**
	 * Establece el tipo de alerta 
	 * (1=Notificación, 2=SMS, 3=Correo)
	 */
	private List<Integer> idTipoAlerta = new ArrayList<>();
	/**
	 * Establece la distancia que va abarcar la oferta (Km)
	 * 
	 */
	private Integer distancia;
	/**
	 * Temperatura de la oferta
	 * normal, hot, super hot
	 *  
	 */
	private Integer idTemperatura;
	/**
	 * Opcional: Cupon para canjear la oferta
	 */
	private String cupon;
	
	
	public static Configuracion from(ConfiguracionDto configDto) {
		Configuracion config = new Configuracion();
		config.setInicio(configDto.getInicio());
		config.setFin(configDto.getFin());
		config.setFechaModificacion(new Date());
		config.setIdRecordatorioInicio(configDto.getIdRecordatorioInicio());
		config.setIdRecordatorioFin(configDto.getIdRecordatorioFin());
		config.setIdTipoAlerta(configDto.getIdTipoAlerta());
		config.setDistancia(configDto.getDistancia());
		config.setPrecio(configDto.getPrecio());
		config.setCupon(configDto.getCupon());
		config.setIdEstatus(configDto.getIdEstatus());
		config.setIdTemperatura(configDto.getIdTemperatura());
		return config;
	}
	
	public ConfiguracionDto to() {
		ConfiguracionDto configDto = new ConfiguracionDto();
		configDto.setInicio(getInicio());
		configDto.setFin(getFin());
		configDto.setFechaModificacion(getFechaModificacion());
		configDto.setIdRecordatorioInicio(getIdRecordatorioInicio());
		configDto.setIdRecordatorioFin(getIdRecordatorioFin());
		configDto.setIdTipoAlerta(getIdTipoAlerta());
		configDto.setDistancia(getDistancia());
		configDto.setPrecio(getPrecio());
		configDto.setCupon(getCupon());
		configDto.setIdEstatus(getIdEstatus());
		configDto.setIdTemperatura(getIdTemperatura());
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

	public Integer getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
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

	public Integer getIdTemperatura() {
		return idTemperatura;
	}

	public void setIdTemperatura(Integer idTemperatura) {
		this.idTemperatura = idTemperatura;
	}

	public String getCupon() {
		return cupon;
	}

	public void setCupon(String cupon) {
		this.cupon = cupon;
	}
	
	
	
}
