package com.hazloakki.ubicaciones.clients;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hazloakki.ubicaciones.models.OfertaDto;

@FeignClient(name = "offer-svc", url = "http://10.152.183.238:8089")
public interface ApiOferta {
	
	@RequestMapping(method = GET, value = "/api/v1/ofertas/{idOferta}")
	OfertaDto obtenerOfertasById(@PathVariable("idOferta") String idOferta);

	@PatchMapping(value = "/api/v1/ofertas/{idOferta}")
	void modificarEstatus(@PathVariable("idOferta") String idOferta, Integer idEstatus);
}
