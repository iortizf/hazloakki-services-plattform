package com.hazloakki.ubicaciones;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import io.kubernetes.client.ApiException;

@SpringBootApplication
public class UbicacionesApplication implements CommandLineRunner {
	
	private static final Logger logger = LoggerFactory.getLogger(UbicacionesApplication.class);
			
	@Autowired
    private Environment env;

	public static void main(String[] args) throws IOException, ApiException {		
		 SpringApplication.run(UbicacionesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String idOferta = env.getProperty("ID_OFERTA");
		logger.info("{}", idOferta);
		//new UbicacionesManagement().execute(idOferta);
	}

}
