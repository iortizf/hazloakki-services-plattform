package com.hazloakki.ubicaciones.management;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.ExtensionsV1beta1Api;
import io.kubernetes.client.util.Config;

public class FinNotificacionTask extends TimerTask {
	
	private String idOferta;
	
	public FinNotificacionTask(String idOferta) {
		this.idOferta = idOferta;
	}

	@Override
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		System.out.println("Ejecutando Tarea FinNotificacionTask");
		System.out.println("Hora actual: " + df.format(new Date()));
		
		ApiClient client;
		try {
			client = Config.defaultClient();
			Configuration.setDefaultApiClient(client);
			
			ExtensionsV1beta1Api extensionsV1beta1Api = new ExtensionsV1beta1Api();
			extensionsV1beta1Api.deleteNamespacedDeployment(idOferta, "default", null, null, null, null, null, null);
		} catch (IOException | ApiException e) {
			System.err.println("Error al ejecutar la Tarea FinNotificacionTask");
			e.printStackTrace();
		}		

	}

}
