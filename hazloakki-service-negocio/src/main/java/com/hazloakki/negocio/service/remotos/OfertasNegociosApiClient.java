package com.hazloakki.negocio.service.remotos;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "offer-svc", url = "http://offer-svc:8089")
public interface OfertasNegociosApiClient {

	@RequestMapping(method = GET, value = "/api/v1/ofertas/negocios/{id}")
	List<OfertaDto> obtenerOfertasByNegocio(@PathVariable("id") String idNegocio);
}
