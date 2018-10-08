package com.hazloakki.cuenta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CuentaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CuentaApplication.class, args);
	}
	

}
