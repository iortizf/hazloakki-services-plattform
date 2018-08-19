package com.hazloakki.analitica.api;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.hazloakki.analitica.modelo.OfertasAnaliticaDto;
import com.hazloakki.analitica.service.OfertasAnaliticaService;


/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/analitics")
public class OfertasAnaliticaController {
	
	@Autowired
	private OfertasAnaliticaService ofertasAnaliticaService;
	private Logger log = Logger.getLogger(OfertasAnaliticaController.class);
	
	@PostMapping("/ofertas")
	@ResponseStatus(CREATED)
	public OfertasAnaliticaDto crearDatosAnaliticaByOferta(@RequestBody OfertasAnaliticaDto ofertasAnaliticaDto) {
		log.info(">>>Creacion de Analitica para Ofertas");
		
		return ofertasAnaliticaService.crearDatosAnaliticaByOferta(ofertasAnaliticaDto).to();
	}
	
	@GetMapping("/negocios/{id}")
	public List<OfertasAnaliticaDto> obtenerAnaliticaOfertasByNegocio(@PathVariable("id") String idNegocio){
		
		return ofertasAnaliticaService.obtenerOfertasAnaliticByNegocio(idNegocio);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
