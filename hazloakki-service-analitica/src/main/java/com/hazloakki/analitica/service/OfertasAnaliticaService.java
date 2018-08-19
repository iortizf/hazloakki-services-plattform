package com.hazloakki.analitica.service;

import java.util.List;

import com.hazloakki.analitica.entity.OfertasAnaliticaEntity;
import com.hazloakki.analitica.modelo.OfertasAnaliticaDto;

/**
 * @author Jovani Arzate 
 * 2018-08-14 
 * HazloAkki para Empresas v.1
 *
 */
public interface OfertasAnaliticaService {

	List<OfertasAnaliticaDto> obtenerOfertasAnaliticByNegocio(String idNegocio);

	OfertasAnaliticaEntity crearDatosAnaliticaByOferta(OfertasAnaliticaDto ofertasAnaliticaDto);
}
