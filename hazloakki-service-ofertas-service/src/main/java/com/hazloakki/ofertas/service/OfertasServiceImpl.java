package com.hazloakki.ofertas.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ofertas.api.OfertasException;
import com.hazloakki.ofertas.entity.OfertaEntity;
import com.hazloakki.ofertas.modelo.OfertaDto;
import com.hazloakki.ofertas.repository.OfertaAccionesRepository;
import com.hazloakki.ofertas.repository.OfertasRepository;
import com.hazloakki.ofertas.entity.OfertaAccionesEntity;
/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class OfertasServiceImpl implements OfertasService {

	@Autowired
	private OfertasRepository ofertasRepository;
	@Autowired
	private OfertaAccionesRepository ofertaAccionesRepository;

	@Override
	public OfertaDto guardarOferta(OfertaDto ofertaDto) {
		
		OfertaDto nuevaOferta = ofertasRepository.save(OfertaEntity.from(ofertaDto)).to();		
		nuevaOferta.setAcciones(ofertaDto.getAcciones());
		
		return nuevaOferta;
	}

	@Override
	public List<OfertaDto> obtenerOfertasByIdNegocio(String idNegocio) {
		
		List<OfertaEntity> listOfertas = ofertasRepository.findAllByIdNegocioAndEstatus(idNegocio, Boolean.TRUE);
		List<OfertaDto> ofertaDtos = new ArrayList<OfertaDto>();
		
		if(listOfertas==null || listOfertas.size()==0)
			throw new OfertasException("No se encontraron registradas ofertas", idNegocio);

			ofertaDtos = listOfertas.stream().map(entity -> {				
			
			OfertaDto ofertaDto = new OfertaDto();
			ofertaDto.setId(entity.getId());
			ofertaDto.setIdNegocio(entity.getIdNegocio());
			ofertaDto.setImagenes(entity.getImagenes());
			ofertaDto.setEstatus(entity.isEstatus());
			ofertaDto.setTitulo(entity.getTitulo());
			ofertaDto.setMensaje(entity.getMensaje());
			ofertaDto.setFecha(entity.getFecha());
			ofertaDto.setDuracion(entity.getDuracion());
			
			List<OfertaAccionesEntity> accionesEntity =  ofertaAccionesRepository.findByOfertaAccionesIdOferta(entity.getId());
			ofertaDto.setAcciones(accionesEntity.stream()
					.map(acciones -> acciones.getOfertaAcciones().getIdAccion())
					.collect(Collectors.toList()));
			
			return ofertaDto;
		}).collect(Collectors.toList());
		
		return ofertaDtos;
	}

	@Override
	public OfertaDto modificarOferta(String idOferta, OfertaDto ofertaDto) {
		OfertaDto nuevaOferta = ofertasRepository.save(OfertaEntity.from(ofertaDto)).to();
		return nuevaOferta;
	}

	@Override
	public void borrarOferta(String idOferta) {
		ofertasRepository.deleteById(idOferta);
	}

	@Override
	public OfertaDto obtenerOferta(String idOferta) {		
		Optional<OfertaEntity> ofertaOptional = ofertasRepository.findById(idOferta);		
		
		if(!ofertaOptional.isPresent()) 
			throw new OfertasException("No se encontró la oferta ", idOferta);
			
		
		OfertaEntity ofertaEntity = ofertaOptional.get();
		
		List<OfertaAccionesEntity> accionesEntity =  ofertaAccionesRepository.findByOfertaAccionesIdOferta(ofertaEntity.getId());
		
		OfertaDto ofertaDto = ofertaEntity.to();
		
		ofertaDto.setAcciones(accionesEntity.stream()
				.map(acciones -> acciones.getOfertaAcciones().getIdAccion())
				.collect(Collectors.toList()));
		
		return ofertaDto;
	}

}
