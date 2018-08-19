package com.hazloakki.catalogos.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hazloakki.catalogos.dto.CatTipoNegocioDto;

@Entity
@Table(name = "cat_categoria_negocios")
public class CatTipoNegocioEntity {

	@Id
	@Column(name = "id_categoria")
	private Integer idCategoria;
	private String nombre;
	private String descripcion;
	private boolean estatus;
	private Date fecha;

	public static CatTipoNegocioEntity from(CatTipoNegocioDto tipoNegocioDto) {

		CatTipoNegocioEntity catTipoNegocioEntity = new CatTipoNegocioEntity();
		catTipoNegocioEntity.setIdCategoria(tipoNegocioDto.getIdCategoria());
		catTipoNegocioEntity.setNombre(tipoNegocioDto.getNombre());
		catTipoNegocioEntity.setDescripcion(tipoNegocioDto.getDescripcion());
		catTipoNegocioEntity.setEstatus(tipoNegocioDto.isEstatus());
		catTipoNegocioEntity.setFecha(tipoNegocioDto.getFecha());

		return catTipoNegocioEntity;
	}

	public CatTipoNegocioDto to() {

		CatTipoNegocioDto catTipoNegocioDto = new CatTipoNegocioDto();
		catTipoNegocioDto.setIdCategoria(getIdCategoria());
		catTipoNegocioDto.setNombre(getNombre());
		catTipoNegocioDto.setDescripcion(getDescripcion());
		catTipoNegocioDto.setEstatus(isEstatus());
		catTipoNegocioDto.setFecha(getFecha());

		return catTipoNegocioDto;

	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
