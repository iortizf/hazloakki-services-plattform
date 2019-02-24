package com.hazloakki.ofertas.modelo;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RecodatorioCat {
	
	@Id
	private Integer id;
	/**
	 * Vamos a mantener el personalizado de recordatorio por negocio
	 */
	private String idNegocio;
	/**
	 * Se establece la cantidad de minutos,horas,dias,semanas para la propiedad "tiempoCatalogo"
	 */
	private Integer tiempo;
	/**
	 * Registra el catalogo que despues se puede personalizar por servicio
	 * Ej. minutos antes, horas antes, dias antes, senamas antes
	 */
	private Map<Integer,String> tiempoCatalogo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdNegocio() {
		return idNegocio;
	}
	public void setIdNegocio(String idNegocio) {
		this.idNegocio = idNegocio;
	}
	public Integer getTiempo() {
		return tiempo;
	}
	public void setTiempo(Integer tiempo) {
		this.tiempo = tiempo;
	}
	public Map<Integer, String> getTiempoCatalogo() {
		return tiempoCatalogo;
	}
	public void setTiempoCatalogo(Map<Integer, String> tiempoCatalogo) {
		this.tiempoCatalogo = tiempoCatalogo;
	}
	
	

}
