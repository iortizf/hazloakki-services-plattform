package com.hazloakki.ofertas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ofertas.api.OfertasException;
import com.hazloakki.ofertas.modelo.Catalogo;
import com.hazloakki.ofertas.modelo.CatalogoDto;
import com.hazloakki.ofertas.repository.CatalogoRepository;

@Service(value="catalogoService")
public class CatalogoServiceImp implements CatalogoService {
	
	@Autowired
	private CatalogoRepository catalogoRepository;

	@Override
	public void guardar(CatalogoDto catDto) {
		catalogoRepository.guardar(Catalogo.from(catDto));
	}

	@Override
	public CatalogoDto obtenerById(Integer idCatalogo) {	
		Catalogo cat = catalogoRepository.obtenerById(idCatalogo);
		if(cat==null)
			throw new OfertasException("No existe el catalogo "+idCatalogo, ""+idCatalogo);
		
		return cat.to();
	}

}
