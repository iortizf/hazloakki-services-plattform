package com.hazloakki.ubicaciones.management;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import com.hazloakki.ubicaciones.models.ConfiguracionDto;
import com.hazloakki.ubicaciones.models.NegocioDto;
import com.hazloakki.ubicaciones.models.OfertaDto;
import com.hazloakki.ubicaciones.services.UbicacionService;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.util.Config;

public class UbicacionesManagement {
	
	private final static Integer PUBLICADO = 3, PROGRAMADO = 2, REPROGRAMADO = 6;
	
	
	@Autowired
	private UbicacionService ubicacionService;
	
	public void execute(String idOferta) throws IOException, ApiException, ParseException {
		//Consultar todos los detalles de la oferta
		OfertaDto ofertaDto = ubicacionService.obtenerOferta(idOferta);
		ConfiguracionDto configDto = ofertaDto.getConfiguracion();
		
		//Consultar detalles del negocio que lanza la oferta
		NegocioDto negocioDto = ubicacionService.obtenerNegocio(ofertaDto.getIdNegocio());
		
		double latitude = Double.valueOf(negocioDto.getLatitud());
		double longitude = Double.valueOf(configDto.getDistancia());
		double radius = Double.valueOf(configDto.getDistancia());
		
		//Si ya esta publicado lanzamos la consulta y notificamos a usuarios cercanos
		if(configDto.getIdEstatus().equals(PUBLICADO)) {			
			
			new Timer()
			.schedule(new InicioNotificacionTask(latitude, longitude, radius), new Date());
			
		}else if(configDto.getIdEstatus().equals(PROGRAMADO) || 
				configDto.getIdEstatus().equals(REPROGRAMADO)){//Si no esta publicado programamos la consulta
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Timer timer = new Timer();
			
			System.out.println("Current Time: " + df.format( new Date()));
			
			//Se ejecutan las notificaciones en cuando se cumpla el tiempo de inicio de la oferta
			timer.schedule(new InicioNotificacionTask(latitude, longitude, radius), df.parse(configDto.getInicio()));
			
			//Se deja de enviar notificaciones en cuando se cumpla el tiempo de fin de la oferta
			timer.schedule(new FinNotificacionTask(idOferta), df.parse(configDto.getFin()));
			
			//Se notifica el recordatorio de inicio de la oferta al emprendedor
			timer.schedule(new InicioRecordatorioTask(ofertaDto), 
					fechaRecordatorio(configDto.getIdRecordatorioInicio(), df.parse(configDto.getInicio())));
			
			//Se notifica el recordatorio de fin de la oferta al emprendedor
			timer.schedule(new InicioRecordatorioTask(ofertaDto), 
					fechaRecordatorio(configDto.getIdRecordatorioFin(), df.parse(configDto.getFin())));
			
		}else { // Eliminar este deployment de notificacion de ofertas en k8s
			ApiClient client = Config.defaultClient();
			Configuration.setDefaultApiClient(client);
			
			ExtensionsV1beta1Api extensionsV1beta1Api = new ExtensionsV1beta1Api();
			extensionsV1beta1Api.deleteNamespacedDeployment(ofertaDto.getIdOferta(), "default", null, null, null, null, null, null);			
		}
		
	}
	
	//Determina cuando se tiene que hacer el recordatorio tanto para inicio y fin de la oferta
	private Date fechaRecordatorio(Integer idRecordatorio, Date fecha) {
		
		int minutos = 0;
		
		switch (idRecordatorio) {
		case 2:
			minutos = 5;
			break;
		case 3:
			minutos = 10;
		default:
			break;
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha);
		calendar.add(Calendar.MINUTE, -minutos);
		
		return calendar.getTime();
	}
	

}
