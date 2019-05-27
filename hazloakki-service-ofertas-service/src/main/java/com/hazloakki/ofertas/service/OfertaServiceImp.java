package com.hazloakki.ofertas.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ofertas.api.OfertasException;
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
		Oferta oferta = ofertaRepository.obtenerById(id);
		if(oferta==null)
			throw new OfertasException("No existe la oferta "+id, id);
		
		Configuracion config = ofertaRepository.obtenerConfig(id);
		oferta = Oferta.from(ofertaDto);
		oferta.setConfig(config);
		ofertaRepository.modificar(oferta);
	}

	@Override
	public void borrar(String id) {
		ofertaRepository.eliminar(id);
	}

	@Override
	public OfertaDto obtenerById(String id) {
		Oferta oferta = ofertaRepository.obtenerById(id);
		if(oferta==null)
			throw new OfertasException("No existe la oferta "+id, id);
		
		return oferta.to();
	}

	@Override
	public ConfiguracionDto obtenerConfig(String id) {
		Configuracion config = ofertaRepository.obtenerConfig(id);
		if(config == null)
			throw new OfertasException("No existe la oferta "+id, id);
				
		ConfiguracionDto configDto = config.to();
		configDto.setIdOferta(id);
		return configDto;
	}

	@Override
	public ConfiguracionDto guardarConfig(String id, ConfiguracionDto configDto) {	
		Configuracion config = ofertaRepository.guardarConfig(id, Configuracion.from(configDto));
		if(config == null)
			throw new OfertasException("No existe la oferta "+id, id);
		
		return config.to();
	}

	@Override
	public void modificarConfig(String id, ConfiguracionDto configDto) {
		Configuracion config = ofertaRepository.guardarConfig(id, Configuracion.from(configDto));	
		if(config == null)
			throw new OfertasException("No existe la oferta "+id, id);
	}

	@Override
	public void modificarEstatus(String id,Integer idEstatus) {
		Oferta oferta = ofertaRepository.obtenerById(id);
		if(oferta == null)
			throw new OfertasException("No existe la oferta "+id, id);
		
		Configuracion config = oferta.getConfig();
		config.setIdEstatus(idEstatus);
		config.setFechaModificacion(LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
		oferta.setConfig(config);
		ofertaRepository.modificar(oferta);
	}

}
