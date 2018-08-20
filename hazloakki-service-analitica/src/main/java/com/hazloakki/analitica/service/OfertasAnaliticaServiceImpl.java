package com.hazloakki.analitica.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.analitica.entity.OfertasAnaliticaEntity;
import com.hazloakki.analitica.modelo.OfertasAnaliticaDto;
import com.hazloakki.analitica.repository.OfertasAnaliticaRepository;

/**
 * @author Jovani Arzate 
 * 2018-08-14 
 * HazloAkki para Empresas v.1
 *
 */
@Service
public class OfertasAnaliticaServiceImpl implements OfertasAnaliticaService {

	private Logger log = Logger.getLogger(OfertasAnaliticaServiceImpl.class);
	@Autowired
	private OfertasAnaliticaRepository ofertasAnaliticaRepository;

	@Override
	public List<OfertasAnaliticaDto> obtenerOfertasAnaliticByNegocio(String idNegocio) {

		List<OfertasAnaliticaEntity> ofertasAnaliticaDtos = ofertasAnaliticaRepository
				.findByIdNegocioAndEstatus(idNegocio, Boolean.TRUE);

		List<OfertasAnaliticaDto> ofertasAnaliticaDtos2 = new ArrayList<OfertasAnaliticaDto>();

		OfertasAnaliticaDto analiticaDto = null;
		for (OfertasAnaliticaEntity analiticaEntity : ofertasAnaliticaDtos) {
			analiticaDto = new OfertasAnaliticaDto();

			analiticaDto.setId(analiticaEntity.getId());
			analiticaDto.setIdNegocio(analiticaEntity.getIdNegocio());
			analiticaDto.setIdOferta(analiticaEntity.getIdOferta());
			analiticaDto.setEstatus(analiticaEntity.isEstatus());
			analiticaDto.setNumVistas(analiticaEntity.getNumVistas());
			analiticaDto.setNumMegusta(analiticaEntity.getNumMegusta());
			analiticaDto.setNumNogusta(analiticaEntity.getNumNogusta());
			analiticaDto.setNumCompartir(analiticaEntity.getNumCompartir());
			analiticaDto.setNumClick(analiticaEntity.getNumClick());
			analiticaDto.setNumComentarios(analiticaEntity.getNumComentarios());
			analiticaDto.setNumComentariosNegativos(analiticaEntity.getNumComentariosNegativos());
			analiticaDto.setNumVisualizacionfotos(analiticaEntity.getNumVisualizacionfotos());
			analiticaDto.setUbicacionSegmentada(analiticaEntity.getUbicacionSegmentada());
			analiticaDto.setSexoFemenino(analiticaEntity.getSexoFemenino());
			analiticaDto.setSexoMasculino(analiticaEntity.getSexoMasculino());

			ofertasAnaliticaDtos2.add(analiticaDto);
		}
		return ofertasAnaliticaDtos2;
	}

	@Override
	public OfertasAnaliticaEntity crearDatosAnaliticaByOferta(OfertasAnaliticaDto ofertasAnaliticaDto) {

		/*
		 * Se obtiene primeramente los daos de las oferta, 
		 * Si no existe se crea los datos analiticos de la oferta
		 * En caso contrario solo se actualizan los datos nuevos de analitica para la oferta
		 */
		OfertasAnaliticaEntity analiticaEntity = ofertasAnaliticaRepository
				.findByIdOferta(ofertasAnaliticaDto.getIdOferta());

		if (analiticaEntity == null) {
			log.info(">>>No se encuentran datos de analitica para la oferta...creando");

			OfertasAnaliticaEntity ofertasAnaliticaEntity = ofertasAnaliticaRepository
					.save(OfertasAnaliticaEntity.from(ofertasAnaliticaDto));
			return ofertasAnaliticaEntity;
		} else {
			log.info(">>>Se encontro datos de analitica de la oferta...actualizando");
			analiticaEntity.setNumClick( ofertasAnaliticaDto.getNumClick() == null ? analiticaEntity.getNumClick() :  ofertasAnaliticaDto.getNumClick());
			analiticaEntity.setNumComentarios(ofertasAnaliticaDto.getNumComentarios() == null ?  analiticaEntity.getNumComentarios(): ofertasAnaliticaDto.getNumComentarios());
			analiticaEntity.setNumComentariosNegativos(ofertasAnaliticaDto.getNumComentariosNegativos() == null ? analiticaEntity.getNumComentariosNegativos(): ofertasAnaliticaDto.getNumComentariosNegativos());
			analiticaEntity.setNumCompartir(ofertasAnaliticaDto.getNumCompartir() == null ? analiticaEntity.getNumCompartir():ofertasAnaliticaDto.getNumCompartir());
			analiticaEntity.setNumMegusta(ofertasAnaliticaDto.getNumMegusta() == null ? analiticaEntity.getNumMegusta() : ofertasAnaliticaDto.getNumMegusta()); 
			analiticaEntity.setNumNogusta(ofertasAnaliticaDto.getNumNogusta() == null ? analiticaEntity.getNumNogusta() : ofertasAnaliticaDto.getNumNogusta());
			analiticaEntity.setNumVistas(ofertasAnaliticaDto.getNumVistas() == null ? analiticaEntity.getNumVistas(): ofertasAnaliticaDto.getNumVistas() );
			analiticaEntity.setNumVisualizacionfotos(ofertasAnaliticaDto.getNumVisualizacionfotos() == null ? analiticaEntity.getNumVisualizacionfotos(): ofertasAnaliticaDto.getNumVisualizacionfotos());
			analiticaEntity.setSexoFemenino(ofertasAnaliticaDto.getSexoFemenino() == null ? analiticaEntity.getSexoFemenino(): ofertasAnaliticaDto.getSexoFemenino());	
			analiticaEntity.setSexoMasculino(ofertasAnaliticaDto.getSexoMasculino() == null ? analiticaEntity.getSexoMasculino(): ofertasAnaliticaDto.getSexoMasculino() );
			analiticaEntity.setUbicacionSegmentada(ofertasAnaliticaDto.getUbicacionSegmentada() == null ?  analiticaEntity.getUbicacionSegmentada(): ofertasAnaliticaDto.getUbicacionSegmentada());
					
			ofertasAnaliticaRepository.save(analiticaEntity);
		}
		return analiticaEntity;
	}

}
