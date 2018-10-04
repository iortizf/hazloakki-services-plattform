package com.hazloakki.negocio;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@EnableDiscoveryClient
@SpringBootApplication
//@EnableFeignClients
public class NegocioApplication {

	public static void main(String[] args) {
		SpringApplication.run(NegocioApplication.class, args);
	}
	

}
