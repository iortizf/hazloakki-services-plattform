package com.hazloakki.login.service.remoto;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hazloakki.login.ClientRemoteConfig;


@FeignClient(url="http://account-service:8085", name = "account-service", configuration = ClientRemoteConfig.class)
public interface CuentaApiClient {

	@RequestMapping(method = GET, value = "/api/v1/cuentas/{email}/{password}")
	CuentaDto validaCuentaExist(@PathVariable("email") String email, @PathVariable("password")String password);

}
