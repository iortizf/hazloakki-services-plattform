package com.hazloakki.negocio.service.remotos;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ofertas-microservice", url = "http://localhost:8089")
public interface OfertasNegociosApiClient {

	@RequestMapping(method = GET, value = "/api/v1/ofertas/negocios/{id}")
	List<OfertaDto> obtenerOfertasByNegocio(@PathVariable("id") String idNegocio);
}
