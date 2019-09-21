package com.hazloakki.ubicaciones.management;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

import org.springframework.core.io.ClassPathResource;

import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class InicioNotificacionTask extends TimerTask {
	
	public final static String FB_BASE_URL = "https://hazloakki-236304.firebaseio.com";
	
	private double latitude;
	private double longitude;
	private double radius;
	
	public InicioNotificacionTask(double latitude, double longitude, double radius) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.radius = radius;
	}

	@Override
	public void run() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		System.out.println("Ejecutando Tarea InicioNotificacionTask");
        System.out.println("Hora actual: " + df.format( new Date()));
        
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
		
		geoQuery.addGeoQueryEventListener(new GeoQueryEventListener() {
			
		    @Override
		    public void onKeyEntered(String key, GeoLocation location) {
		        System.out.println(String.format("Key %s entered the search area at [%f,%f]", key, location.latitude, location.longitude));
		    }

		    @Override
		    public void onKeyExited(String key) {
		        System.out.println(String.format("Key %s is no longer in the search area", key));
		    }

		    @Override
		    public void onKeyMoved(String key, GeoLocation location) {
		        System.out.println(String.format("Key %s moved within the search area to [%f,%f]", key, location.latitude, location.longitude));
		    }

		    @Override
		    public void onGeoQueryReady() {
		        System.out.println("All initial data has been loaded and events have been fired!");
		    }

		    @Override
		    public void onGeoQueryError(DatabaseError error) {
		        System.err.println("There was an error with this query: " + error);
		    }
		});

	}

}
