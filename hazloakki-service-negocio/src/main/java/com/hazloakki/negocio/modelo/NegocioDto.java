package com.hazloakki.negocio.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
public class NegocioDto {

	private String idNegocio;
	private String nombre;
	private Integer idCategoria;
	private String email;
	private String descripcion;
	private String telefono;
	private String latitud;
	private String longitud;
	private String idCuenta;
	private String codigoPostal;
	private String delegacion;
	private String colonia;
	private String calle;
	private String numeroExterior;
	private Integer idEstatus;
	private String responsable;
	private List<ServiciosDto> servicios = new ArrayList<>();
	private List<MetodoPagoDto> metodoPago = new ArrayList<>();
	private List<TipoTarjetaDto> tipoTarjeta = new ArrayList<>();
	private List<Integer> acciones = new ArrayList<>();
	private List<HorarioDto> horario = new ArrayList<>();
	
	public String getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getLatitud() {
		return latitud;
	}
	public void setLatitud(String latitud) {
		this.latitud = latitud;
	}
	public String getLongitud() {
		return longitud;
	}
	public void setLongitud(String longitud) {
		this.longitud = longitud;
	}
	public Integer getIdEstatus() {
		return idEstatus;
	}
	public void setIdEstatus(Integer idEstatus) {
		this.idEstatus = idEstatus;
	}
	public String getIdCuenta() {
		return idCuenta;
	}
	public void setIdCuenta(String idCuenta) {
		this.idCuenta = idCuenta;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getDelegacion() {
		return delegacion;
	}
	public void setDelegacion(String delegacion) {
		this.delegacion = delegacion;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumeroExterior() {
		return numeroExterior;
	}
	public void setNumeroExterior(String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}	
	public String getResponsable() {
		return responsable;
	}
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	
	public List<ServiciosDto> getServicios() {
		return servicios;
	}
	public void setServicios(List<ServiciosDto> servicios) {
		this.servicios = servicios;
	}
	public List<MetodoPagoDto> getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(List<MetodoPagoDto> metodoPago) {
		this.metodoPago = metodoPago;
	}
	public List<TipoTarjetaDto> getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(List<TipoTarjetaDto> tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public List<Integer> getAcciones() {
		return acciones;
	}
	public void setAcciones(List<Integer> acciones) {
		this.acciones = acciones;
	}
		public List<HorarioDto> getHorario() {
		return horario;
	}
	public void setHorario(List<HorarioDto> horario) {
		this.horario = horario;
	}
	
}
