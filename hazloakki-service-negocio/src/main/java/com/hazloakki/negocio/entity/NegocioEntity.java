//package com.hazloakki.negocio.entity;
//
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//import org.hibernate.annotations.GenericGenerator;
//
//import com.hazloakki.negocio.modelo.MetodoPagoDto;
//import com.hazloakki.negocio.modelo.NegocioDto;
//import com.hazloakki.negocio.modelo.ServiciosDto;
//import com.hazloakki.negocio.modelo.TipoTarjetaDto;
//
//@Entity
//@Table(name = "negocio")
//public class NegocioEntity implements Serializable {
//
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(generator = "uuid2")
//	@GenericGenerator(name = "uuid2", strategy = "uuid2")
//	@Column(updatable = false)
//	private String id;
//	@Column(name = "id_cuenta")
//	private String idCuenta;
//	private String nombre;
//	@Column(name = "id_categoria")
//	private Integer idCategoria;
//	private String email;
//	private String descripcion;
//	private String telefono;
//	private String domicilio;
//	private Double latitud;
//	private Double longitud;
//	private boolean estatus;
//	@Column(name = "codigo_postal")
//	private String codigoPostal;
//	private String delegacion;
//	private String colonia;
//	private String calle;
//	@Column(name = "numero_exterior")
//	private String numeroExterior;
//
//	@OneToMany(mappedBy="negocio", cascade = CascadeType.PERSIST)
//	private List<NegociosMetodoPago> negociosMetodoPagos;
//
//	@OneToMany(mappedBy="negocio", cascade = CascadeType.PERSIST)
//	private List<ServiciosNegocioEntity> negociosServiciosEntity;
//
//	@OneToMany(mappedBy="negocio", cascade = CascadeType.PERSIST)
//	private List<NegociosTarjetasPagoEntity> negocioTarjetaPagoEntity;
//
//	public static NegocioEntity from(NegocioDto negocio) {
//
//		NegocioEntity negocioEntity = new NegocioEntity();
//		negocioEntity.setId(negocio.getId());
//		negocioEntity.setNombre(negocio.getNombre());
//		negocioEntity.setIdCategoria(negocio.getIdCategoria());
//		negocioEntity.setEmail(negocio.getEmail());
//		negocioEntity.setDescripcion(negocio.getDescripcion());
//		negocioEntity.setTelefono(negocio.getTelefono());
//		negocioEntity.setDomicilio(negocio.getDomicilio());
//		negocioEntity.setLatitud(negocio.getLatitud());
//		negocioEntity.setLongitud(negocio.getLongitud());
//		negocioEntity.setEstatus(negocio.isEstatus());
//		negocioEntity.setCodigoPostal(negocio.getCodigoPostal());
//		negocioEntity.setDelegacion(negocio.getDelegacion());
//		negocioEntity.setColonia(negocio.getColonia());
//		negocioEntity.setCalle(negocio.getCalle());
//		negocioEntity.setNumeroExterior(negocio.getNumeroExterior());
//
//		// List<NegociosMetodoPago> metodoPagos = new ArrayList<>();
//		//
//		// for(MetodoPagoDto metodoPagoDto: negocio.getMetodoPagoList()) {
//		// NegociosMetodoPago metodoPago = new NegociosMetodoPago();
//		//
//		// NegociosMetodoPagoPK metodoPagoPK = new NegociosMetodoPagoPK();
//		// metodoPagoPK.setIdNegocio(negocio.getId());
//		// metodoPagoPK.setIdPago(metodoPagoDto.getId());
//		// metodoPago.setId(metodoPagoPK);
//		// metodoPagos.add(metodoPago);
//		// }
//		// negocioEntity.setNegociosMetodoPagos(metodoPagos);
//
//		return negocioEntity;
//
//	}
//
//	public NegocioDto to() {
//
//		List<ServiciosDto> serviciosList = new ArrayList<>();
//		List<MetodoPagoDto> metodoPagoList = new ArrayList<>();
//		List<TipoTarjetaDto> tipoTarjetaList = new ArrayList<>();
//
//		NegocioDto negocioDto = new NegocioDto();
//		negocioDto.setId(getId());
//		negocioDto.setNombre(getNombre());
//		negocioDto.setIdCategoria(getIdCategoria());
//		negocioDto.setEmail(getEmail());
//		negocioDto.setDescripcion(getDescripcion());
//		negocioDto.setTelefono(getTelefono());
//		negocioDto.setDomicilio(getDomicilio());
//		negocioDto.setLatitud(getLatitud());
//		negocioDto.setLongitud(getLongitud());
//		negocioDto.setEstatus(isEstatus());
//		negocioDto.setCodigoPostal(getCodigoPostal());
//		negocioDto.setDelegacion(getDelegacion());
//		negocioDto.setColonia(getColonia());
//		negocioDto.setCalle(getCalle());
//		negocioDto.setNumeroExterior(getNumeroExterior());
//
//		return negocioDto;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getIdCuenta() {
//		return idCuenta;
//	}
//
//	public void setIdCuenta(String idCuenta) {
//		this.idCuenta = idCuenta;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public Integer getIdCategoria() {
//		return idCategoria;
//	}
//
//	public void setIdCategoria(Integer idCategoria) {
//		this.idCategoria = idCategoria;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//	public String getTelefono() {
//		return telefono;
//	}
//
//	public void setTelefono(String telefono) {
//		this.telefono = telefono;
//	}
//
//	public String getDomicilio() {
//		return domicilio;
//	}
//
//	public void setDomicilio(String domicilio) {
//		this.domicilio = domicilio;
//	}
//
//	public Double getLatitud() {
//		return latitud;
//	}
//
//	public void setLatitud(Double latitud) {
//		this.latitud = latitud;
//	}
//
//	public Double getLongitud() {
//		return longitud;
//	}
//
//	public void setLongitud(Double longitud) {
//		this.longitud = longitud;
//	}
//
//	public boolean isEstatus() {
//		return estatus;
//	}
//
//	public void setEstatus(boolean estatus) {
//		this.estatus = estatus;
//	}
//
//	public String getCodigoPostal() {
//		return codigoPostal;
//	}
//
//	public void setCodigoPostal(String codigoPostal) {
//		this.codigoPostal = codigoPostal;
//	}
//
//	public String getDelegacion() {
//		return delegacion;
//	}
//
//	public void setDelegacion(String delegacion) {
//		this.delegacion = delegacion;
//	}
//
//	public String getColonia() {
//		return colonia;
//	}
//
//	public void setColonia(String colonia) {
//		this.colonia = colonia;
//	}
//
//	public String getCalle() {
//		return calle;
//	}
//
//	public void setCalle(String calle) {
//		this.calle = calle;
//	}
//
//	public String getNumeroExterior() {
//		return numeroExterior;
//	}
//
//	public void setNumeroExterior(String numeroExterior) {
//		this.numeroExterior = numeroExterior;
//	}
//
//	public List<NegociosMetodoPago> getNegociosMetodoPagos() {
//		return negociosMetodoPagos;
//	}
//
//	public void setNegociosMetodoPagos(List<NegociosMetodoPago> negociosMetodoPagos) {
//		this.negociosMetodoPagos = negociosMetodoPagos;
//	}
//
//	public List<ServiciosNegocioEntity> getNegociosServiciosEntity() {
//		return negociosServiciosEntity;
//	}
//
//	public void setNegociosServiciosEntity(List<ServiciosNegocioEntity> negociosServiciosEntity) {
//		this.negociosServiciosEntity = negociosServiciosEntity;
//	}
//
//	public List<NegociosTarjetasPagoEntity> getNegocioTarjetaPagoEntity() {
//		return negocioTarjetaPagoEntity;
//	}
//
//	public void setNegocioTarjetaPagoEntity(List<NegociosTarjetasPagoEntity> negocioTarjetaPagoEntity) {
//		this.negocioTarjetaPagoEntity = negocioTarjetaPagoEntity;
//	}
//
//	@Override
//	public String toString() {
//		return "NegocioEntity [id=" + id + ", idCuenta=" + idCuenta + ", nombre=" + nombre + ", idCategoria="
//				+ idCategoria + ", email=" + email + ", descripcion=" + descripcion + ", telefono=" + telefono
//				+ ", domicilio=" + domicilio + ", latitud=" + latitud + ", longitud=" + longitud + ", estatus="
//				+ estatus + ", codigoPostal=" + codigoPostal + ", delegacion=" + delegacion + ", colonia=" + colonia
//				+ ", calle=" + calle + ", numeroExterior=" + numeroExterior + ", negociosMetodoPagos="
//				+ negociosMetodoPagos + ", negociosServiciosEntity=" + negociosServiciosEntity
//				+ ", negocioTarjetaPagoEntity=" + negocioTarjetaPagoEntity + "]";
//	}
//	
//	
//
//}