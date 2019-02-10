package com.hazloakki.acciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hazloakki.acciones.modelo.AccionesDto;
@Entity
@Table(name = "cat_acciones")
public class AccionesEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id_accion", updatable = false)
	private String idAccion;
	private String nombre;
	private String descripcion;
	private boolean estatus;

	public static AccionesEntity from(AccionesDto accionesDto) {

		AccionesEntity accionesEntity = new AccionesEntity();
			accionesEntity.setIdAccion(accionesDto.getIdAccion());
			accionesEntity.setNombre(accionesDto.getNombre());
			accionesEntity.setDescripcion(accionesDto.getDescripcion());
			accionesEntity.setEstatus(accionesDto.isEstatus());

		return accionesEntity;
	}

	public AccionesDto to() {

		AccionesDto accionesDto = new AccionesDto();
		accionesDto.setIdAccion(getIdAccion());
		accionesDto.setNombre(getNombre());
		accionesDto.setDescripcion(getDescripcion());
		accionesDto.setEstatus(isEstatus());

		return accionesDto;
	}

	public String getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(String idAccion) {
		this.idAccion = idAccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
