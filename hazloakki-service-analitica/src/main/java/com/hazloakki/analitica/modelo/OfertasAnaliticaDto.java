package com.hazloakki.analitica.modelo;

public class OfertasAnaliticaDto {
	private String id;
	private String idOferta;
	private String idNegocio;
	private boolean estatus;
	private Integer numVistas;
	private Integer numMegusta;
	private Integer numNogusta;
	private Integer numCompartir;
	private Integer numClick;
	private Integer numComentarios;
	private Integer numComentariosNegativos;
	private Integer numVisualizacionfotos;
	private String ubicacionSegmentada;
	private Integer sexoFemenino;
	private Integer sexoMasculino;

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

	@Override
	public String toString() {
		return "OfertasAnaliticaDto [id=" + id + ", idOferta=" + idOferta + ", idNegocio=" + idNegocio + ", estatus="
				+ estatus + ", numVistas=" + numVistas + ", numMegusta=" + numMegusta + ", numNogusta=" + numNogusta
				+ ", numCompartir=" + numCompartir + ", numClick=" + numClick + ", numComentarios=" + numComentarios
				+ ", numComentariosNegativos=" + numComentariosNegativos + ", numVisualizacionfotos="
				+ numVisualizacionfotos + ", ubicacionSegmentada=" + ubicacionSegmentada + ", sexoFemenino="
				+ sexoFemenino + ", sexoMasculino=" + sexoMasculino + "]";
	}

}
