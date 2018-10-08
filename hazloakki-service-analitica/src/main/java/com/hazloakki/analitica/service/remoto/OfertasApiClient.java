package com.hazloakki.analitica.service.remoto;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "business-svc", url = "http://business-svc:8086")
public interface OfertasApiClient {

	@RequestMapping(method = GET, value = "/api/v1/negocios/cuenta/{id}")
	List<OfertasDto> obtenerNegocioByCuenta(@PathVariable("id") String idCuenta);

}
