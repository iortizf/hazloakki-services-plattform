package com.hazloakki.ubicaciones;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryDataEventListener;
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
import com.hazloakki.ubicaciones.management.UbicacionesManagement;

import io.kubernetes.client.ApiException;

@SpringBootApplication
@EnableFeignClients
public class UbicacionesApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(UbicacionesApplication.class);
			
	@Autowired
    private Environment env;
	@Autowired
	private UbicacionesManagement ubicacionesManagement;

	public static void main(String[] args) throws IOException, ApiException {		
		 SpringApplication.run(UbicacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String idOferta = "akjshdfh2387ksjjYY";//env.getProperty("ID_OFERTA");
		logger.info("Ejecutando oferta ", idOferta);
		//ubicacionesManagement.execute("5d8825264be4bf00017c0607");
		
		try {
			FirebaseOptions options = new FirebaseOptions.Builder()
			  .setCredentials(GoogleCredentials.fromStream(new ClassPathResource("/firebase-authentication.json").getInputStream()))
			  .setDatabaseUrl("https://hazloakki-e10f1.firebaseio.com")
			  .build();
			FirebaseApp.initializeApp(options);
			/*
			Message message = Message.builder()
			        .setNotification(new Notification("Price drop", "5% off all electronics"))
			        .setToken("fCqGM9uFXNg:APA91bEOk4nR8mcB5qVtFkDc-cuSnPAU0RMHhem1f25Uu6NW5Y8oAfZE83geMTzjn_34onC48TKLga7DHq3yB7mVEQ-wj36NrHYzZsR84oaIDCsb1gMx06GsxNhdKQ3A5Qs5KbrG50mk")
			        .build();
			        
				     // Send a message to the device corresponding to the provided
				     // registration token.
				     String response = FirebaseMessaging.getInstance().send(message);
				     // Response is a message ID string.
				     System.out.println("Successfully sent message: " + response);*/
			
			double latitude = 19.333265;
			double longitude = -99.167195;
			double radius = 1;
			DatabaseReference ref = FirebaseDatabase.getInstance().getReference("/Usuarios");
			
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
					System.out.println("Data Entered "+dataSnapshot.toString());				
					Map<String, Object> valores = (Map<String, Object>) dataSnapshot.getValue();
					if(valores.containsKey("ofertasNotificadas") &&
							valores.containsKey("idToken")){
						
						/**/
						
						Map<String,Integer> ofertasNotificadas = (Map<String, Integer>) valores.get("ofertasNotificadas");
						
						System.out.println("Notificado="+ ofertasNotificadas.containsKey(idOferta));
						
						if(!ofertasNotificadas.containsKey(idOferta)) {// Si aun no esta notificado lanzamos la notificación
							
							//Enviar notificación
							Message message = Message.builder()
							.setNotification(new Notification("Price drop", "5% off all electronics"))
							.setToken((String)valores.get("idToken"))
							.build();
							        
							// Send a message to the device corresponding to the provided
							// registration token.
							String response;
							try {
								response = FirebaseMessaging.getInstance().send(message);
								
								// Response is a message ID string.
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
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
