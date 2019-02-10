package com.hazloakki.negocio.modelo;

public class ImagenDto {
	
	private String idNegocio;
	private String idImagen;
	private String rutaImagen;
	private boolean perfil;
	
	public String getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}
	public String getIdImagen() {
		return idImagen;
	}
	public void setIdImagen(String idImagen) {
		this.idImagen = idImagen;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public boolean isPerfil() {
		return perfil;
	}
	public void setPerfil(boolean perfil) {
		this.perfil = perfil;
	}
	

	
}
