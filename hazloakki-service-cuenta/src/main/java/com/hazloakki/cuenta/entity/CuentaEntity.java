package com.hazloakki.cuenta.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hazloakki.cuenta.modelo.CuentaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Entity
@Table(name = "cuenta")
public class CuentaEntity {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	private String nombre;
	private String apellidos;
	private String password;
	private String email;
	private String telefono;
	private String fecha;
	private boolean estatus;
	

	public static CuentaEntity from(CuentaDto cuentaDto) {

		CuentaEntity cuentaEntity = new CuentaEntity();
		// return CuentaEntity.builder()
		/*
		 * .idCuenta(cuentaDto.getIdCuenta()); .nombre(cuentaDto.getNombre());
		 * .apellidos(cuentaDto.getApellidos()); .email(cuentaDto.getEmail());
		 * .password(cuentaDto.getPassword()); .telefono(cuentaDto.getTelefono());
		 * .estatus(cuentaDto.isEstatus());
		 * .fecha(cuentaDto.getFechaCreacion()).build();
		 */

		cuentaEntity.setId(cuentaDto.getIdCuenta());
		cuentaEntity.setNombre(cuentaDto.getNombre());
		cuentaEntity.setApellidos(cuentaDto.getApellidos());
		cuentaEntity.setEmail(cuentaDto.getEmail());
		cuentaEntity.setPassword(cuentaDto.getPassword());
		cuentaEntity.setTelefono(cuentaDto.getTelefono());
		cuentaEntity.setEstatus(cuentaDto.isEstatus());
		cuentaEntity.setFecha(cuentaDto.getFecha());

		return cuentaEntity;
	}

	public CuentaDto to() {


		CuentaDto cuentaDto = new CuentaDto();
		cuentaDto.setIdCuenta(getId());
		cuentaDto.setNombre(getNombre());
		cuentaDto.setApellidos(getApellidos());
		cuentaDto.setEmail(getEmail());
		cuentaDto.setPassword(getPassword());
		cuentaDto.setTelefono(getTelefono());
		cuentaDto.setEstatus(isEstatus());
		cuentaDto.setFecha(getFecha());

		return cuentaDto;

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public boolean isEstatus() {
		return estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

}
