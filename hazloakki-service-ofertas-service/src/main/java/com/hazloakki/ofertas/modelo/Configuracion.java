package com.hazloakki.ofertas.modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
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
	private String inicio;
	/**
	 * Indica la fecha fin de la oferta
	 */
	private String fin;
	/**
	 * Establece cuando se hizo la ultima modificacion
	 * a la configuración de la oferta
	 */
	private String fechaModificacion;
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
	private Double distancia;
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
	private Integer idSexo;
	private Integer edadDe;
	private Integer edadA;
	
	
	public static Configuracion from(ConfiguracionDto configDto) {
		Configuracion config = new Configuracion();
		config.setInicio(configDto.getInicio());
		config.setFin(configDto.getFin());
		config.setFechaModificacion(LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
		config.setIdRecordatorioInicio(configDto.getIdRecordatorioInicio());
		config.setIdRecordatorioFin(configDto.getIdRecordatorioFin());
		config.setIdTipoAlerta(configDto.getIdTipoAlerta());
		config.setDistancia(configDto.getDistancia());
		config.setPrecio(configDto.getPrecio());
		config.setCupon(configDto.getCupon());
		config.setIdEstatus(configDto.getIdEstatus());
		config.setIdTemperatura(configDto.getIdTemperatura());
		config.setIdSexo(configDto.getIdSexo());
		config.setEdadDe(configDto.getEdadDe());
		config.setEdadA(configDto.getEdadA());
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
		configDto.setIdSexo(getIdSexo());
		configDto.setEdadDe(getEdadDe());
		configDto.setEdadA(getEdadA());
		return configDto;
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

	public Integer getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(Integer idSexo) {
		this.idSexo = idSexo;
	}

	public Integer getEdadDe() {
		return edadDe;
	}

	public void setEdadDe(Integer edadDe) {
		this.edadDe = edadDe;
	}

	public Integer getEdadA() {
		return edadA;
	}

	public void setEdadA(Integer edadA) {
		this.edadA = edadA;
	}
	
	
	
}
