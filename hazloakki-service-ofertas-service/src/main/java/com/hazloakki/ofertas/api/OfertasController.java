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
import com.hazloakki.ofertas.service.OfertaService;

/**
 * @author Jovani Arzate 2018-07-25 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/ofertas")
public class OfertasController {

	@Autowired
	private OfertaService ofertaService;

	@PostMapping
	@ResponseStatus(CREATED)
	public OfertaDto createOferta(@Valid @RequestBody OfertaDto ofertaDto) {
		return ofertaService.guardar(ofertaDto);
	}
	
	@GetMapping("/{idOferta}")
	public OfertaDto obtenerOferta(@PathVariable("idOferta") String idOferta) {
		return ofertaService.obtenerById(idOferta);
	}
	
	
	@GetMapping("/negocios/{idNegocio}")
	public List<OfertaDto> obtenerOfertasByNegocio(@PathVariable("idNegocio")String idNegocio){
		
		return ofertaService.obtenerByIdNegocio(idNegocio);
	}
	
	@PutMapping("/{idOferta}")
	public void modificaNegocio(@PathVariable("idOferta") String idOferta, 
			@RequestBody OfertaDto ofertaDto) {
		ofertaService.modificar(idOferta, ofertaDto);
	}
	
	@DeleteMapping("/{idOferta}")
	public void borrarOferta(@PathVariable("idOferta") String idOferta) {
		ofertaService.borrar(idOferta);
	}

	
}
