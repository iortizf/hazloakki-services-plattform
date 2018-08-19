package com.hazloakki.cuenta.service.remoto;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "negocio-service", url = "http://localhost:8086")
public interface NegocioApiClient {

	@RequestMapping(method = GET, value = "/api/v1/negocios/cuenta/{id}")
	List<NegocioDto> obtenerNegocioByCuenta(@PathVariable("id") String idCuenta);

}
