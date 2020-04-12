package com.hazloakki.ubicaciones.management;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Map;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryDataEventListener;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.hazloakki.ubicaciones.services.UbicacionService;

public class InicioNotificacionTask extends TimerTask {
	
	private final static String FB_BASE_URL = "https://hazloakki-e10f1.firebaseio.com";
	private final static Integer ESTATUS_PUBLICADO = 3;
	
	private String idOferta;
	private String titulo;
	private String desc;
	private double latitude;
	private double longitude;
	private double radius;
	
	@Autowired
	private UbicacionService ubicacionService; 
	
	public InicioNotificacionTask(String idOferta, String titulo, String desc,double latitude, double longitude, double radius) {
		this.idOferta = idOferta;
		this.titulo = titulo;
		this.desc = desc;
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	@Override
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		System.out.println("***Ejecutando Tarea InicioNotificacionTask");
        System.out.println("***Hora actual: " + df.format( new Date()));
        
        System.out.println("***Consultando LAT="+latitude +" LONG="+longitude+" RADIO="+radius);
        
        //Se establece la oferta a estatus publicado (3 - Publicado)
        ubicacionService.actualizarEstatusOferta(idOferta, ESTATUS_PUBLICADO);
               
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/firebase-authentication.json").getInputStream()))
			  .setDatabaseUrl(FB_BASE_URL)
			  .build();
			FirebaseApp.initializeApp(options);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/users");
		
		GeoFire geoFire = new GeoFire(ref);
		
		GeoQuery geoQuery = geoFire.queryAtLocation(new GeoLocation(latitude, longitude), radius);
		
		geoQuery.addGeoQueryDataEventListener(new GeoQueryDataEventListener() {
			
			@Override
			public void onGeoQueryReady() {
				// TODO Auto-generated method stub
				System.out.println("Query Listo");
			}
			
			@Override
			public void onGeoQueryError(DatabaseError error) {
				// TODO Auto-generated method stub
				System.err.println("Query error");
			}
			
			@Override
			public void onDataMoved(DataSnapshot dataSnapshot, GeoLocation location) {
				// TODO Auto-generated method stub
				System.out.println("Data moved");
			}
			
			@Override
			public void onDataExited(DataSnapshot dataSnapshot) {
				// TODO Auto-generated method stub
				System.out.println("Data exited");
			}
			
			@Override
			public void onDataEntered(DataSnapshot dataSnapshot, GeoLocation location) {
				// TODO Auto-generated method stub
				System.out.println("Data Entered " + dataSnapshot.toString());				
				Map<String, Object> valores = (Map<String, Object>) dataSnapshot.getValue();
				if(valores.containsKey("ofertasNotificadas") &&
						valores.containsKey("idToken")){
					
					Map<String,Integer> ofertasNotificadas = (Map<String, Integer>) valores.get("ofertasNotificadas");
					
					System.out.println("Notificado="+ ofertasNotificadas.containsKey(idOferta));
					
					if(!ofertasNotificadas.containsKey(idOferta)) {// Si aun no esta notificado lanzamos la notificación
						
						//Enviar notificación
						Message message = Message.builder()
						.setNotification(new Notification(titulo, desc))
						.setToken((String)valores.get("idToken"))
						.build();						        
						// Send a message to the device corresponding to the provided
						// registration token.
						String response;
						try {
							response = FirebaseMessaging.getInstance().send(message);
							System.out.println("Successfully sent message: " + response);
							Map<String, Object> idOfertaNotif = new Hashtable<>();
							idOfertaNotif.put(idOferta, "0");
							dataSnapshot.child("ofertasNotificadas").getRef().updateChildrenAsync(idOfertaNotif);
							
						} catch (FirebaseMessagingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}					
					}		
				}					
			}
			
			@Override
			public void onDataChanged(DataSnapshot dataSnapshot, GeoLocation location) {
				// TODO Auto-generated method stub
				System.out.println("Data changed");
			}
		});

	}

}
