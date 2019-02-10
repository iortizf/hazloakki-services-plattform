package com.hazloakki.ofertas.api;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
		return ofertasService.guardarOferta(ofertaDto);
	}
	
	@GetMapping("/{idOferta}")
	public OfertaDto obtenerOferta(@PathVariable("idOferta") String idOferta) {
		return ofertasService.obtenerOferta(idOferta);
	}
	
	
	@GetMapping("/negocios/{idNegocio}")
	public List<OfertaDto> obtenerOfertasByNegocio(@PathVariable("idNegocio")String idNegocio){
		
		return ofertasService.obtenerOfertasByIdNegocio(idNegocio);
	}
	
	@PutMapping("/{idOferta}")
	public OfertaDto modificaNegocio(@PathVariable("idOferta") String idOferta, 
			@RequestBody OfertaDto ofertaDto) {
		return ofertasService.modificarOferta(idOferta, ofertaDto);
	}
	
	@DeleteMapping("/{idOferta}")
	public void borrarOferta(@PathVariable("idOferta") String idOferta) {
		ofertasService.borrarOferta(idOferta);
	}

	
}
