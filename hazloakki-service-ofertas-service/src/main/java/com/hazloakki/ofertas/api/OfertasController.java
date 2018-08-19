package com.hazloakki.ofertas.api;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.ofertas.modelo.OfertaDto;
import com.hazloakki.ofertas.service.OfertasService;

/**
 * @author Jovani Arzate 2018-07-25 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/ofertas")
public class OfertasController {

	@Autowired
	private OfertasService ofertasService;

	@PostMapping
	@ResponseStatus(CREATED)
	public OfertaDto createOferta(@Valid @RequestBody OfertaDto ofertaDto) {
		return ofertasService.guardarOferta(ofertaDto).to();
	}
	
	@GetMapping("/{id}/{idNegocio}")
	public OfertaDto obtenerOferta(@PathVariable("id") String idOferta,@PathVariable("idNegocio") String idNegocio) {
		return ofertasService.obtenerOfertaByNegocio(idOferta).to();
	}
	
	/*
	 * Servicios remotos
	 */
	
	@GetMapping("/negocios/{id}")
	public List<OfertaDto> obtenerOfertas(@PathVariable("id")String idNegocio){
		
		return ofertasService.obtenerOfertas(idNegocio);
	}

	
}
