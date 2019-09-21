package com.hazloakki.ubicaciones.clients;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hazloakki.ubicaciones.models.OfertaDto;

@FeignClient(name = "offer-svc", url = "http://offer-svc:8089")
public interface ObtenerOferta {
	
	@RequestMapping(method = GET, value = "/api/v1/ofertas/{idOferta}")
	OfertaDto obtenerOfertasById(@PathVariable("idOferta") String idOferta);

}
