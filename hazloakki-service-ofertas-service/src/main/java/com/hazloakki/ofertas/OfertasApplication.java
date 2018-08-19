package com.hazloakki.ofertas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OfertasApplication {

	public static void main(String[] args) {
		SpringApplication.run(OfertasApplication.class, args);
	}
}
