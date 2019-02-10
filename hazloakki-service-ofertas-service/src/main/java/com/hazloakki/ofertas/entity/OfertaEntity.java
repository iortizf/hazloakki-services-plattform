package com.hazloakki.ofertas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hazloakki.ofertas.modelo.OfertaDto;

/**
 * @author Jovani Arzate 2018-07-25 HazloAkki para Empresas v.1
 *
 */
@Entity
@Table(name = "ofertas")
public class OfertaEntity {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	private String titulo;
	private String mensaje;
	private String imagenes;
	private String fecha;
	private String duracion;
	@Column(name = "id_negocio")
	private String idNegocio;
	private boolean estatus;

	public static OfertaEntity from(OfertaDto ofertaDto) {

		OfertaEntity cuentaEntity = new OfertaEntity();
		cuentaEntity.setId(ofertaDto.getId());
		cuentaEntity.setTitulo(ofertaDto.getTitulo());
		cuentaEntity.setMensaje(ofertaDto.getMensaje());
		cuentaEntity.setDuracion(ofertaDto.getDuracion());
		cuentaEntity.setImagenes(ofertaDto.getImagenes());
		cuentaEntity.setEstatus(ofertaDto.isEstatus());
		cuentaEntity.setFecha(ofertaDto.getFecha());
		cuentaEntity.setIdNegocio(ofertaDto.getIdNegocio());

		return cuentaEntity;
	}

	public OfertaDto to() {

		OfertaDto cuentaDto = new OfertaDto();
		cuentaDto.setId(getId());
		cuentaDto.setDuracion(getDuracion());
		cuentaDto.setMensaje(getMensaje());
		cuentaDto.setTitulo(getTitulo());
		cuentaDto.setImagenes(getImagenes());
		cuentaDto.setEstatus(isEstatus());
		cuentaDto.setIdNegocio(getIdNegocio());
		cuentaDto.setFecha(getFecha());

		return cuentaDto;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getImagenes() {
		return imagenes;
	}

	public void setImagenes(String imagenes) {
		this.imagenes = imagenes;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getIdNegocio() {
		return idNegocio;
	}

	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
