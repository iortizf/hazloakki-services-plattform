package com.hazloakki.negocio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hazloakki.negocio.api.NegocioException;
import com.hazloakki.negocio.modelo.MetodoPagoDto;
import com.hazloakki.negocio.modelo.NegocioDto;
import com.hazloakki.negocio.modelo.ServiciosDto;
import com.hazloakki.negocio.modelo.TipoTarjetaDto;
import com.hazloakki.negocio.repository.NegocioAccionesRepository;
import com.hazloakki.negocio.repository.NegocioMetodoPagoRepository;
import com.hazloakki.negocio.repository.NegocioRepository;
import com.hazloakki.negocio.repository.NegocioTarjetasPagoRepository;
import com.hazloakki.negocio.repository.ServiciosNegocioRepository;
import com.hazloakki.negocio.service.remotos.OfertaDto;

/**
 * @author Jovani Arzate 2018-07-01 HazloAkki para Empresas v.1
 *
 */
@Service
public class NegocioServiceImpl implements NegocioService {
	
	private static String METHOD_OF_PAYMENT_CARD_ID = "4";

	@Autowired
	private NegocioRepository negocioRepository;
	// @Autowired
	// private OfertasNegociosApiClient ofertasNegociosApiClient;
	@Autowired
	private ServiciosNegocioRepository negocioServiciosRepository;
	@Autowired
	private NegocioMetodoPagoRepository negocioMetodoPagoRepository;
	@Autowired
	private NegocioTarjetasPagoRepository negocioTarjetasPagoRepository;
	@Autowired
	private NegocioAccionesRepository negocioAccionesRepository;

	@Transactional
	@Override
	public NegocioDto guardarNegocio(NegocioDto negocioDto) {

		String idNegocio = negocioRepository.guardar(negocioDto);
		try {
			/*
			 * Servicios por negocio
			 */
			negocioDto.getServiciosList().forEach( servicio -> negocioServiciosRepository.guardar(idNegocio, servicio.getId()));
			/*
			 * Metodos de pago por negocio
			 */
			negocioDto.getMetodoPagoList().forEach(metodo -> negocioMetodoPagoRepository.guardar(idNegocio, metodo.getId()));
			/*
			 * Tipos de tarjeta por negocio
			 */
			negocioDto.getTipoTarjetaList().forEach(ttarjeta -> negocioTarjetasPagoRepository.guardar(idNegocio, ttarjeta.getId()));
			//Acciones por negocio
			negocioDto.getAcciones().forEach(idAccion -> negocioAccionesRepository.guardar(idNegocio, idAccion));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return obtenerNegocio(idNegocio);
	}

	@Override
	public NegocioDto obtenerNegocio(String idNegocio) {

		NegocioDto negocioDto = negocioRepository.findById(idNegocio);

		if (negocioDto == null) {
			throw new NegocioException("No se encontro el negocio : " + idNegocio, idNegocio);
		}

		List<ServiciosDto> dataServiciosNegocio = negocioServiciosRepository.findServicios(idNegocio);
		List<MetodoPagoDto> dataMetodosPagoNegocio = negocioMetodoPagoRepository.consultar(idNegocio);
		List<TipoTarjetaDto> dataTipoTarjetaNEgocio = negocioTarjetasPagoRepository.findByIdNegocio(idNegocio);
		List<String> acciones = negocioAccionesRepository.acciones(idNegocio);

		negocioDto.setServiciosList(dataServiciosNegocio);
		negocioDto.setMetodoPagoList(dataMetodosPagoNegocio);
		negocioDto.setTipoTarjetaList(dataTipoTarjetaNEgocio);
		negocioDto.setAcciones(acciones);

		return negocioDto;
	}

	@Transactional
	@Override
	public NegocioDto modificaNegocio(String idNegocio, NegocioDto negocio) {

		NegocioDto negocioDto = negocioRepository.findById(idNegocio);

		if (negocioDto == null) {
			throw new NegocioException("El negocio seleccionado no esta registrado : " + idNegocio, idNegocio);
		}
		negocioRepository.actualizarByIdNegocio(idNegocio, negocio);
		
		negocioServiciosRepository.eliminar(idNegocio);
		negocioMetodoPagoRepository.eliminar(idNegocio);
		negocioTarjetasPagoRepository.eliminar(idNegocio);
		negocioAccionesRepository.eliminar(idNegocio);
		
		//Servicios por negocio
		negocio.getServiciosList().forEach(svc -> negocioServiciosRepository.guardar(idNegocio, svc.getId()));
		//Metodos de pago por negocio
		negocio.getMetodoPagoList().forEach(mp -> {
			negocioMetodoPagoRepository.guardar(idNegocio, mp.getId());
			if(mp.getId().equals(METHOD_OF_PAYMENT_CARD_ID)) {
				//Tipos de tarjeta por negocio
				negocio.getTipoTarjetaList().forEach(tt -> negocioTarjetasPagoRepository.guardar(idNegocio, tt.getId()));
			}
		});			
		
		negocio.getAcciones().forEach(idAccion -> negocioAccionesRepository.guardar(idNegocio, idAccion));

		return obtenerNegocio(idNegocio);
	}

	@Transactional
	@Override
	public void borrarNegocio(String idNegocio) {
		
		NegocioDto negocioDto = negocioRepository.findById(idNegocio);

		if (negocioDto == null) {
			throw new NegocioException("El negocio seleccionado no esta registrado : " + idNegocio, idNegocio);
		}
		
		negocioServiciosRepository.eliminar(idNegocio);
		negocioMetodoPagoRepository.eliminar(idNegocio);
		negocioTarjetasPagoRepository.eliminar(idNegocio);
		negocioAccionesRepository.eliminar(idNegocio);
		
		negocioRepository.eliminarByIdNegocio(idNegocio);

	}

	@Override
	public List<NegocioDto> obtenerAllNegociosByCuenta(String idCuenta) {

		return negocioRepository.findByIdCuentaAndEstatus(idCuenta, Boolean.TRUE);
	}

	@Override
	public List<OfertaDto> obtenerAllOfertasByNegocio(String idNegocio) {

		// return ofertasNegociosApiClient.obtenerOfertasByNegocio(idNegocio);
		return null;
	}

}
