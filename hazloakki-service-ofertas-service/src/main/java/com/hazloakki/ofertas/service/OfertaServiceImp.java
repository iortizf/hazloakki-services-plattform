package com.hazloakki.ofertas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ofertas.modelo.Configuracion;
import com.hazloakki.ofertas.modelo.ConfiguracionDto;
import com.hazloakki.ofertas.modelo.Oferta;
import com.hazloakki.ofertas.modelo.OfertaDto;
import com.hazloakki.ofertas.repository.OfertaRepository;

@Service
public class OfertaServiceImp implements OfertaService {

	@Autowired
	private OfertaRepository ofertaRepository;
	
	@Override
	public OfertaDto guardar(OfertaDto ofertaDto) {		
		return ofertaRepository.guardar(Oferta.from(ofertaDto)).to();
	}

	@Override
	public List<OfertaDto> obtenerByIdNegocio(String idNegocio) {	
		List<Oferta> ofertas = ofertaRepository.obtenerByIdNegocio(idNegocio);
		if(ofertas!=null && ofertas.size()>0){
			return ofertas.stream()
					.map(oferta -> oferta.to())
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}

	@Override
	public void modificar(String id, OfertaDto ofertaDto) {
		ofertaRepository.modificar(Oferta.from(ofertaDto));
	}

	@Override
	public void borrar(String id) {
		ofertaRepository.eliminar(id);

	}

	@Override
	public OfertaDto obtenerById(String id) {
		return ofertaRepository.obtenerById(id).to();
	}

	@Override
	public ConfiguracionDto obtenerConfig(String id) {
		ConfiguracionDto configDto = ofertaRepository.obtenerConfig(id).to();
		configDto.setIdOferta(id);
		return configDto;
	}

	@Override
	public ConfiguracionDto guardarConfig(String id, ConfiguracionDto configDto) {		
		return ofertaRepository.guardarConfig(id, Configuracion.from(configDto)).to();
	}

	@Override
	public void modificarConfig(String id, ConfiguracionDto configDto) {
		ofertaRepository.guardarConfig(id, Configuracion.from(configDto));		
	}

}
