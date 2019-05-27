package com.hazloakki.ofertas.api;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hazloakki.ofertas.modelo.ImagenDto;
import com.hazloakki.ofertas.service.OfertaImagenService;

@RestController
@RequestMapping("/api/v1/ofertas")
@CrossOrigin(origins = "*")
public class OfertaImagenesController {
	
	@Autowired
	private OfertaImagenService negocioImagenService;
	
	@GetMapping("/{idOferta}/imagenes")
	public List<ImagenDto> obtenerImagenes(@PathVariable("idOferta")String idOferta){
		return negocioImagenService.obtenerImagenes(idOferta);
	}
	
	@PostMapping("/{idOferta}/imagenes")
	@ResponseStatus(CREATED)
	public List<ImagenDto> subirImagenes( @PathVariable("idOferta")String idOferta,
			@RequestParam("imagenes") MultipartFile[] file) {
		return negocioImagenService.guardarImagenes(idOferta, file);		
	}
	
	@DeleteMapping("/{idOferta}/imagenes/{idImagen}")
	public void borrarOfertaImagen(@PathVariable("idOferta") String idOferta,
			@PathVariable("idImagen") String idImagen) {
		
		negocioImagenService.eliminarImagen(idOferta, idImagen);
	}	
	
	@DeleteMapping("/{id}/imagenes")
	public void borrarOfertaImagenes(@PathVariable("id") String idOferta) {
		negocioImagenService.eliminarImagenesOferta(idOferta);
	}
}
