package com.hazloakki.negocio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hazloakki.negocio.api.NegocioException;
import com.hazloakki.negocio.modelo.HorarioDto;
import com.hazloakki.negocio.modelo.MetodoPagoDto;
import com.hazloakki.negocio.modelo.NegocioDto;
import com.hazloakki.negocio.modelo.ServiciosDto;
import com.hazloakki.negocio.modelo.TipoTarjetaDto;
import com.hazloakki.negocio.repository.HorarioRepository;
import com.hazloakki.negocio.repository.NegocioAccionesRepository;
import com.hazloakki.negocio.repository.NegocioMetodoPagoRepository;
import com.hazloakki.negocio.repository.NegocioRepository;
import com.hazloakki.negocio.repository.NegocioTarjetasPagoRepository;
import com.hazloakki.negocio.repository.ServiciosNegocioRepository;

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
	@Autowired
	private HorarioRepository horarioRepository;

	@Transactional
	@Override
	public NegocioDto guardarNegocio(NegocioDto negocioDto) {

		String idNegocio = negocioRepository.guardar(negocioDto);
		try {
			/*
			 * Servicios por negocio
			 */
			negocioDto.getServicios().forEach( servicio -> negocioServiciosRepository.guardar(idNegocio, servicio.getId()));
			/*
			 * Metodos de pago por negocio
			 */
			negocioDto.getMetodoPago().forEach(metodo -> negocioMetodoPagoRepository.guardar(idNegocio, metodo.getId()));
			/*
			 * Tipos de tarjeta por negocio
			 */
			negocioDto.getTipoTarjeta().forEach(ttarjeta -> negocioTarjetasPagoRepository.guardar(idNegocio, ttarjeta.getId()));
			//Acciones por negocio
			negocioDto.getAcciones().forEach(idAccion -> negocioAccionesRepository.guardar(idNegocio, idAccion));
			//Horarios del negocio
			negocioDto.getHorario().forEach(horario -> {
				horario.setIdNegocio(idNegocio);
				horarioRepository.guardar(horario);
			});
			
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
		List<Integer> acciones = negocioAccionesRepository.acciones(idNegocio);
		List<HorarioDto> horario = horarioRepository.horarioByIdNegocio(idNegocio);

		negocioDto.setServicios(dataServiciosNegocio);
		negocioDto.setMetodoPago(dataMetodosPagoNegocio);
		negocioDto.setTipoTarjeta(dataTipoTarjetaNEgocio);
		negocioDto.setAcciones(acciones);
		negocioDto.setHorario(horario);

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
		negocio.getServicios().forEach(svc -> negocioServiciosRepository.guardar(idNegocio, svc.getId()));
		//Metodos de pago por negocio
		negocio.getMetodoPago().forEach(mp -> {
			negocioMetodoPagoRepository.guardar(idNegocio, mp.getId());
			if(mp.getId().equals(METHOD_OF_PAYMENT_CARD_ID)) {
				//Tipos de tarjeta por negocio
				negocio.getTipoTarjeta().forEach(tt -> negocioTarjetasPagoRepository.guardar(idNegocio, tt.getId()));
			}
		});			
		
		negocio.getAcciones().forEach(idAccion -> negocioAccionesRepository.guardar(idNegocio, idAccion));
		horarioRepository.eliminarHorarioNegocio(idNegocio);
		negocio.getHorario().forEach(horario -> {
			horario.setIdNegocio(idNegocio);
			horarioRepository.guardar(horario);
		});

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
		horarioRepository.eliminarHorarioNegocio(idNegocio);
		negocioRepository.eliminarByIdNegocio(idNegocio);		

	}

	@Override
	public List<NegocioDto> obtenerAllNegociosByCuenta(String idCuenta) {

		return negocioRepository.findByIdCuentaAndEstatus(idCuenta, 1);
	}


	@Override
	public void modificarEstatus(String idNegocio, Integer idEstatus) {
		NegocioDto negocioDto = negocioRepository.findById(idNegocio);
		if (negocioDto == null) {
			throw new NegocioException("El negocio seleccionado no esta registrado", idNegocio);
		}
		
		negocioDto.setIdEstatus(idEstatus);
		negocioRepository.actualizarByIdNegocio(idNegocio, negocioDto);
	}

}
