package com.hazloakki.ubicaciones.management;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import com.hazloakki.ubicaciones.models.ConfiguracionDto;
import com.hazloakki.ubicaciones.models.OfertaDto;

public class InicioRecordatorioTask extends TimerTask {

	private OfertaDto ofertaDto;
	private ConfiguracionDto configDto;

	public InicioRecordatorioTask(OfertaDto ofertaDto) {
		this.ofertaDto = ofertaDto;
		this.configDto = ofertaDto.getConfiguracion();
	}

	@Override
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("***Ejecutando Tarea InicioRecordatorioTask");
		System.out.println("***Hora actual: " + df.format(new Date()));

		System.out.println("***Notificando al emprendedor que en " + obtenerTiempo(configDto.getIdRecordatorioInicio()) + " se lanza la oferta "+ ofertaDto.getTitulo());
	}

	private int  obtenerTiempo(int idRecordatorio) {
		int tiempo = 0;
		
		switch (idRecordatorio) {
		case 2:
			tiempo = 5;
			break;
		case 3:
			tiempo = 10;
		default:
			break;
		}
		
		return tiempo;
	}

}
