package com.hazloakki.negocio.api;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

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

import com.hazloakki.negocio.modelo.NegocioDto;
import com.hazloakki.negocio.service.NegocioService;
import com.hazloakki.negocio.service.remotos.OfertaDto;


/**
 * @author Jovani Arzate
 * 2018-07-01
 * HazloAkki para Empresas v.1
 *
 */
@RestController
@RequestMapping("/api/v1/negocios")
public class NegocioController {
	
	@Autowired
	private NegocioService negocioService;
	
	/**Obtencion de un negocio por su ID
	 * @param idNegocio
	 * @return
	 */
	@GetMapping("/{id}")
	public NegocioDto redNegocio(@PathVariable("id") String idNegocio) {
		return negocioService.obtenerNegocio(idNegocio);
	}
	
	
	/**
	 * Creacion de un negocio
	 * @param negocioDto
	 * @return
	 */
	@PostMapping
	@ResponseStatus(CREATED)
	public NegocioDto crearNegocio(@RequestBody NegocioDto negocioDto) {
		return negocioService.guardarNegocio(negocioDto);
		
	}
	
	/**Modificacion de un negocio
	 * @param idNegocio
	 * @param cuentaDto
	 * @return
	 */
	@PutMapping("/{id}")
	public NegocioDto modificaNegocio(@PathVariable("id") String idNegocio,@RequestBody NegocioDto cuentaDto) {
		return negocioService.modificaNegocio(idNegocio, cuentaDto);
	}
	
	/**
	 * Eliminacion de un negocio
	 * @param idNegocio
	 */
	@DeleteMapping("/{id}")
	public void borrarNegocio(@PathVariable("id") String idNegocio) {
		negocioService.borrarNegocio(idNegocio);
	}

	
	/*
	 * Solicitud de servicios Remotos
	 */

	/**
	 * Se solictan todos los negocios de una cuenta, siempre y cuando exista la cuenta y el negocio
	 * este activo
	 * @param idCuenta
	 * @return
	 */
	@GetMapping("/cuenta/{id}")
	public List<NegocioDto> readAllNegocios(@PathVariable("id") String idCuenta) {
		return negocioService.obtenerAllNegociosByCuenta(idCuenta);
	}
	
	@GetMapping("/{id}/ofertas")
	public List<OfertaDto> obtenerOfertas(@PathVariable("id")String idNegocio){
		return negocioService.obtenerAllOfertasByNegocio(idNegocio);
	}
		
}