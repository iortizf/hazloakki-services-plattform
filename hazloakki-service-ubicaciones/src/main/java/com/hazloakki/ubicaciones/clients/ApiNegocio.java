package com.hazloakki.ubicaciones.clients;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hazloakki.ubicaciones.models.NegocioDto;

@FeignClient(name = "business-svc", url = "http://10.152.183.96:8086")
public interface ApiNegocio {
	
	@RequestMapping(method = GET, value = "/api/v1/negocios/{id}")
	NegocioDto obtenerNegocio(@PathVariable("id") String id);

}
