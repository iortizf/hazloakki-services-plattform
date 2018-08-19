package com.hazloakki.analitica.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.hazloakki.analitica.modelo.OfertasAnaliticaDto;

/**
 * @author Jovani Arzate 2018-08-18 HazloAkki para Empresas v.1
 *
 */
@Entity
@Table(name = "analitica_ofertas")
public class OfertasAnaliticaEntity {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(updatable = false)
	private String id;
	@Column(name = "id_oferta")
	private String idOferta;
	@Column(name = "id_negocio")
	private String idNegocio;
	private boolean estatus;
	@Column(name = "num_vistas")
	private Integer numVistas;
	@Column(name = "num_megusta")
	private Integer numMegusta;
	@Column(name = "num_nogusta")
	private Integer numNogusta;
	@Column(name = "num_compartir")
	private Integer numCompartir;
	@Column(name = "num_click")
	private Integer numClick;
	@Column(name = "num_comentarios")
	private Integer numComentarios;
	@Column(name = "num_comentarios_negativos")
	private Integer numComentariosNegativos;
	@Column(name = "num_visualizacion_fotos")
	private Integer numVisualizacionfotos;
	@Column(name = "ubicacion_segmentada")
	private String ubicacionSegmentada;
	@Column(name = "sexo_femenino")
	private Integer sexoFemenino;
	@Column(name = "sexo_masculino")
	private Integer sexoMasculino;

	public static OfertasAnaliticaEntity from(OfertasAnaliticaDto ofertasAnaliticaDto) {

		OfertasAnaliticaEntity cuentaEntity = new OfertasAnaliticaEntity();
		cuentaEntity.setIdNegocio(ofertasAnaliticaDto.getIdNegocio());
		cuentaEntity.setIdOferta(ofertasAnaliticaDto.getIdOferta());
		cuentaEntity.setEstatus(ofertasAnaliticaDto.isEstatus());
		cuentaEntity.setNumVistas(ofertasAnaliticaDto.getNumVistas());
		cuentaEntity.setNumMegusta(ofertasAnaliticaDto.getNumMegusta());
		cuentaEntity.setNumNogusta(ofertasAnaliticaDto.getNumNogusta());
		cuentaEntity.setNumCompartir(ofertasAnaliticaDto.getNumCompartir());
		cuentaEntity.setNumClick(ofertasAnaliticaDto.getNumClick());
		cuentaEntity.setNumComentarios(ofertasAnaliticaDto.getNumComentarios());
		cuentaEntity.setNumComentariosNegativos(ofertasAnaliticaDto.getNumComentariosNegativos());
		cuentaEntity.setNumVisualizacionfotos(ofertasAnaliticaDto.getNumVisualizacionfotos());
		cuentaEntity.setUbicacionSegmentada(ofertasAnaliticaDto.getUbicacionSegmentada());
		cuentaEntity.setSexoFemenino(ofertasAnaliticaDto.getSexoFemenino());
		cuentaEntity.setSexoMasculino(ofertasAnaliticaDto.getSexoMasculino());

		return cuentaEntity;
	}

	public OfertasAnaliticaDto to() {

		OfertasAnaliticaDto analiticaDto = new OfertasAnaliticaDto();
		analiticaDto.setId(getId());
		analiticaDto.setIdNegocio(getIdNegocio());
		analiticaDto.setIdOferta(getIdOferta());
		analiticaDto.setEstatus(isEstatus());
		analiticaDto.setNumVistas(getNumVistas());
		analiticaDto.setNumMegusta(getNumMegusta());
		analiticaDto.setNumNogusta(getNumNogusta());
		analiticaDto.setNumCompartir(getNumCompartir());
		analiticaDto.setNumClick(getNumClick());
		analiticaDto.setNumComentarios(getNumComentarios());
		analiticaDto.setNumComentariosNegativos(getNumComentariosNegativos());
		analiticaDto.setNumVisualizacionfotos(getNumVisualizacionfotos());
		analiticaDto.setUbicacionSegmentada(getUbicacionSegmentada());
		analiticaDto.setSexoFemenino(getSexoFemenino());
		analiticaDto.setSexoMasculino(getSexoMasculino());

		return analiticaDto;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdOferta() {
		return idOferta;
	}

	public void setIdOferta(String idOferta) {
		this.idOferta = idOferta;
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

	public Integer getNumVistas() {
		return numVistas;
	}

	public void setNumVistas(Integer numVistas) {
		this.numVistas = numVistas;
	}

	public Integer getNumMegusta() {
		return numMegusta;
	}

	public void setNumMegusta(Integer numMegusta) {
		this.numMegusta = numMegusta;
	}

	public Integer getNumNogusta() {
		return numNogusta;
	}

	public void setNumNogusta(Integer numNogusta) {
		this.numNogusta = numNogusta;
	}

	public Integer getNumCompartir() {
		return numCompartir;
	}

	public void setNumCompartir(Integer numCompartir) {
		this.numCompartir = numCompartir;
	}

	public Integer getNumClick() {
		return numClick;
	}

	public void setNumClick(Integer numClick) {
		this.numClick = numClick;
	}

	public Integer getNumComentarios() {
		return numComentarios;
	}

	public void setNumComentarios(Integer numComentarios) {
		this.numComentarios = numComentarios;
	}

	public Integer getNumComentariosNegativos() {
		return numComentariosNegativos;
	}

	public void setNumComentariosNegativos(Integer numComentariosNegativos) {
		this.numComentariosNegativos = numComentariosNegativos;
	}

	public Integer getNumVisualizacionfotos() {
		return numVisualizacionfotos;
	}

	public void setNumVisualizacionfotos(Integer numVisualizacionfotos) {
		this.numVisualizacionfotos = numVisualizacionfotos;
	}

	public String getUbicacionSegmentada() {
		return ubicacionSegmentada;
	}

	public void setUbicacionSegmentada(String ubicacionSegmentada) {
		this.ubicacionSegmentada = ubicacionSegmentada;
	}

	public Integer getSexoFemenino() {
		return sexoFemenino;
	}

	public void setSexoFemenino(Integer sexoFemenino) {
		this.sexoFemenino = sexoFemenino;
	}

	public Integer getSexoMasculino() {
		return sexoMasculino;
	}

	public void setSexoMasculino(Integer sexoMasculino) {
		this.sexoMasculino = sexoMasculino;
	}

}
