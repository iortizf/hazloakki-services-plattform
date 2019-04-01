package com.hazloakki.negocio.api;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hazloakki.negocio.modelo.ImagenDto;
import com.hazloakki.negocio.service.NegocioImagenService;

@RestController
@RequestMapping("/api/v1/negocios")
@CrossOrigin(origins = "*")
public class NegocioImagenesController {
	
	@Autowired
	private NegocioImagenService negocioImagenService;
	
	@GetMapping("/{id}/imagenes")
	public List<ImagenDto> obtenerImagenes(@PathVariable("id")String idNegocio){
		return negocioImagenService.obtenerImagenes(idNegocio);
	}
	
	@PostMapping("/{id}/imagenes")
	@ResponseStatus(CREATED)
	public List<ImagenDto> subirImagenes( @PathVariable("id")String idNegocio,
			@RequestParam("imagenes") MultipartFile[] file, @RequestParam("profile") String imgprofile ) {
		return negocioImagenService.guardarImagenes(idNegocio, file, imgprofile);		
	}
	
	@DeleteMapping("/{idNegocio}/imagenes/{idImagen}")
	public void borrarNegocioImagen(@PathVariable("idNegocio") String idNegocio,
			@PathVariable("idImagen") String idImagen) {
		
		negocioImagenService.eliminarImagen(idNegocio, idImagen);
	}
	
	@PutMapping("/{idNegocio}/imagenes/{idImagen}")
	public void establecerImagePerfil(@PathVariable("idNegocio") String idNegocio,
			@PathVariable("idImagen") String idImagen) {
		negocioImagenService.imagenPerfil(idNegocio, idImagen);
	}
	
	@DeleteMapping("/{id}/imagenes")
	public void borrarNegocioImagenes(@PathVariable("id") String idNegocio) {
		negocioImagenService.eliminarImagenesNegocio(idNegocio);
	}
}
