package com.hazloakki.negocio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;

import com.hazloakki.negocio.modelo.NegocioDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */

@Entity
@Table(name = "negocio")
public class NegocioEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Version
	private Long version;
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@Column(name = "id_cuenta")
	private String idCuenta;
	private String nombre;
	@Column(name = "id_categoria")
	private Integer idCategoria;
	private String email;
	private String descripcion;
	private String telefono;
	private String domicilio;
	private Double latitud;
	private Double longitud;
	@Column(name = "id_metodo_pago")
	private Integer idMetodoPago;
	@Column(name = "tarjeta_credito")
	private String tipoTarjetCredito;
	@Column(name = "servicio_domicilio")
	private boolean servicioDomicilio;
	private boolean estacionamiento;
	private boolean internet;
	private boolean reservaciones;
	private boolean estatus;
	@Column(name = "modo_llevar")
	private boolean modoLlevar;
	@Column(name = "codigo_postal")
	private String codigoPostal;
	private String delegacion;
	private String colonia;
	private String calle;
	@Column(name = "numero_exterior")
	private String numeroExterior;

	public static NegocioEntity from(NegocioDto cuentaDto) {

		NegocioEntity negocioEntity = new NegocioEntity();
		negocioEntity.setId(cuentaDto.getId());
		negocioEntity.setNombre(cuentaDto.getNombre());
		negocioEntity.setIdCategoria(cuentaDto.getIdCategoria());
		negocioEntity.setEmail(cuentaDto.getEmail());
		negocioEntity.setDescripcion(cuentaDto.getDescripcion());
		negocioEntity.setTelefono(cuentaDto.getTelefono());
		negocioEntity.setDomicilio(cuentaDto.getDomicilio());
		negocioEntity.setLatitud(cuentaDto.getLatitud());
		negocioEntity.setLongitud(cuentaDto.getLongitud());
		negocioEntity.setIdMetodoPago(cuentaDto.getIdMetodoPago());
		negocioEntity.setTipoTarjetCredito(cuentaDto.getTipoTarjetaCredito());
		negocioEntity.setServicioDomicilio(cuentaDto.isServicioDomicilio());
		negocioEntity.setEstacionamiento(cuentaDto.isEstacionamiento());
		negocioEntity.setInternet(cuentaDto.isInternet());
		negocioEntity.setReservaciones(cuentaDto.isReservaciones());
		negocioEntity.setModoLlevar(cuentaDto.isModoLlevar());
		negocioEntity.setEstatus(cuentaDto.isEstatus());
		negocioEntity.setCodigoPostal(cuentaDto.getCodigoPostal());
		negocioEntity.setDelegacion(cuentaDto.getDelegacion());
		negocioEntity.setColonia(cuentaDto.getColonia());
		negocioEntity.setCalle(cuentaDto.getCalle());
		negocioEntity.setNumeroExterior(cuentaDto.getNumeroExterior());

		return negocioEntity;

	}

	public NegocioDto to() {

		NegocioDto negocioDto = new NegocioDto();
		negocioDto.setId(getId());
		negocioDto.setNombre(getNombre());
		negocioDto.setIdCategoria(getIdCategoria());
		negocioDto.setEmail(getEmail());
		negocioDto.setDescripcion(getDescripcion());
		negocioDto.setTelefono(getTelefono());
		negocioDto.setDomicilio(getDomicilio());
		negocioDto.setLatitud(getLatitud());
		negocioDto.setLongitud(getLongitud());
		negocioDto.setIdMetodoPago(getIdMetodoPago());
		negocioDto.setTipoTarjetaCredito(getTipoTarjetCredito());
		negocioDto.setServicioDomicilio(isServicioDomicilio());
		negocioDto.setEstacionamiento(isEstacionamiento());
		negocioDto.setInternet(isInternet());
		negocioDto.setReservaciones(isReservaciones());
		negocioDto.setModoLlevar(isModoLlevar());
		negocioDto.setEstatus(isEstatus());
		negocioDto.setCodigoPostal(getCodigoPostal());
		negocioDto.setDelegacion(getDelegacion());
		negocioDto.setColonia(getColonia());
		negocioDto.setCalle(getCalle());
		negocioDto.setNumeroExterior(getNumeroExterior());

		return negocioDto;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Integer getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(Integer idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getTipoTarjetCredito() {
		return tipoTarjetCredito;
	}

	public void setTipoTarjetCredito(String tipoTarjetCredito) {
		this.tipoTarjetCredito = tipoTarjetCredito;
	}

	public boolean isServicioDomicilio() {
		return servicioDomicilio;
	}

	public void setServicioDomicilio(boolean servicioDomicilio) {
		this.servicioDomicilio = servicioDomicilio;
	}

	public boolean isEstacionamiento() {
		return estacionamiento;
	}

	public void setEstacionamiento(boolean estacionamiento) {
		this.estacionamiento = estacionamiento;
	}

	public boolean isInternet() {
		return internet;
	}

	public void setInternet(boolean internet) {
		this.internet = internet;
	}

	public boolean isReservaciones() {
		return reservaciones;
	}

	public void setReservaciones(boolean reservaciones) {
		this.reservaciones = reservaciones;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public boolean isModoLlevar() {
		return modoLlevar;
	}

	public void setModoLlevar(boolean modoLlevar) {
		this.modoLlevar = modoLlevar;
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

}
