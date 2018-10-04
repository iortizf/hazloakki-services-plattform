package com.hazloakki.negocio.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hazloakki.negocio.modelo.TipoTarjetaDto;
import com.hazloakki.negocio.service.TarjetasPagoService;

@RestController
@RequestMapping("/api/v1/catalogos/tarjetas")
public class TarjetasPagoController {

	@Autowired
	private TarjetasPagoService tarjetasPagoService;

	@GetMapping
	public List<TipoTarjetaDto> tipoTargetasPago() {
		return tarjetasPagoService.obtenerTipoTarjetaActivas();
	}
}
