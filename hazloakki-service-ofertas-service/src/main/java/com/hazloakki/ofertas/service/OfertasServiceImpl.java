package com.hazloakki.ofertas.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazloakki.ofertas.api.OfertasException;
import com.hazloakki.ofertas.entity.OfertaEntity;
import com.hazloakki.ofertas.modelo.OfertaDto;
import com.hazloakki.ofertas.repository.OfertasRepository;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class OfertasServiceImpl implements OfertasService {

	@Autowired
	private OfertasRepository ofertasRepository;

	@Override
	public OfertaEntity guardarOferta(OfertaDto cuentaDto) {
		return ofertasRepository.save(OfertaEntity.from(cuentaDto));
	}

	@Override
	public OfertaEntity obtenerOfertaByNegocio(String idNegocio) {

		return ofertasRepository.findByIdNegocioAndEstatus(idNegocio, Boolean.TRUE).orElseThrow(
				() -> OfertasException.from("No se ha registrado ninguna oferta para el negocio", idNegocio));

	}

	@Override
	public OfertaEntity modificarOferta(String idCuenta, OfertaDto cuentaDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarOferta(String idCuenta) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<OfertaDto> obtenerOfertas(String idNegocio) {

		List<OfertaEntity> listOfertas = ofertasRepository.findAllByIdNegocioAndEstatus(idNegocio, Boolean.TRUE);
		List<OfertaDto> ofertaDtos = new ArrayList<OfertaDto>();

		if (listOfertas.size() > 0) {

			OfertaDto ofertaDto = new OfertaDto();

			for (OfertaEntity entity : listOfertas) {
				ofertaDto.setId(entity.getId());
				ofertaDto.setIdNegocio(entity.getIdNegocio());
				ofertaDto.setImagenes(entity.getImagenes());
				ofertaDto.setEstatus(entity.isEstatus());
				ofertaDto.setTitulo(entity.getTitulo());
				ofertaDto.setMensaje(entity.getMensaje());
				ofertaDto.setFecha(entity.getFecha());
				ofertaDto.setDuracion(entity.getDuracion());

				ofertaDtos.add(ofertaDto);
				ofertaDto = new OfertaDto();
			}

		} else {
			throw new OfertasException("No se encontraron registradas ofertas", idNegocio);
		}

		return ofertaDtos;
	}

}
