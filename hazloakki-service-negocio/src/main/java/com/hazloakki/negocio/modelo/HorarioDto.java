package com.hazloakki.negocio.modelo;

public class HorarioDto {
	
	private String idNegocio;
	private Integer idDia;
	private String abre;
	private String cierra;
	private boolean abierto;
	private boolean veinticuatroHrs;
		
	
	public String getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}
	public Integer getIdDia() {
		return idDia;
	}
	public void setIdDia(Integer idDia) {
		this.idDia = idDia;
	}
	public String getAbre() {
		return abre;
	}
	public void setAbre(String abre) {
		this.abre = abre;
	}
	public String getCierra() {
		return cierra;
	}
	public void setCierra(String cierra) {
		this.cierra = cierra;
	}
	public boolean isAbierto() {
		return abierto;
	}
	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}
	public boolean isVeinticuatroHrs() {
		return veinticuatroHrs;
	}
	public void setVeinticuatroHrs(boolean veinticuatroHrs) {
		this.veinticuatroHrs = veinticuatroHrs;
	}
	
	

}
