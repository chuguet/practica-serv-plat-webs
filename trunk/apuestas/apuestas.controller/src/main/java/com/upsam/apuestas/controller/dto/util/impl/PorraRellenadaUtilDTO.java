package com.upsam.apuestas.controller.dto.util.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.controller.dto.PartidoRellenadoDTO;
import com.upsam.apuestas.controller.dto.PorraRellenadaDTO;
import com.upsam.apuestas.controller.dto.util.IPartidoRellenadoUtilDTO;
import com.upsam.apuestas.controller.dto.util.IPorraRellenadaUtilDTO;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.exception.AppException;
import com.upsam.apuestas.model.service.IPorraService;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraUtilDTO.
 */
@Component
public class PorraRellenadaUtilDTO implements IPorraRellenadaUtilDTO {

	/** The porra service. */
	@Inject
	private IPorraService porraService;

	/** The partido rellenado util dto. */
	@Inject
	private IPartidoRellenadoUtilDTO partidoRellenadoUtilDTO;

	/** The Constant FORMATTER_DATE. */
	private static final SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPorraRellenadaUtilDTO#toBusiness
	 * (com.upsam.apuestas.controller.dto.PorraRellenadaDTO)
	 */
	@Override
	public PorraRellenada toBusiness(PorraRellenadaDTO porraRellenadaDTO)
			throws AppException {
		PorraRellenada result = new PorraRellenada();
		Porra porra = porraService.findOne(porraRellenadaDTO.getIdPorra());
		result.setPorra(porra);
		result.setFechaRelleno(new Date());
		if (porraRellenadaDTO.getId() != null) {
			result.setId(porraRellenadaDTO.getId());
		}
		List<PartidoRellenado> partidosRellenados = new ArrayList<PartidoRellenado>();
		for (PartidoRellenadoDTO partidoRellenadoDTO : porraRellenadaDTO
				.getPartidosRellenadosDTO()) {
			PartidoRellenado partidoRellenado = partidoRellenadoUtilDTO
					.toBusiness(partidoRellenadoDTO);
			partidosRellenados.add(partidoRellenado);
		}
		for (PartidoRellenado partidoRellenado : partidosRellenados) {
			partidoRellenado.setPorraRellenada(result);
		}
		result.setPartidosRellenados(partidosRellenados);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPorraRellenadaUtilDTO#toRest(
	 * com.upsam.apuestas.model.bean.PorraRellenada)
	 */
	@Override
	public PorraRellenadaDTO toRest(PorraRellenada porraRellenada)
			throws AppException {
		PorraRellenadaDTO result = new PorraRellenadaDTO();

		result.setCompeticion(porraRellenada.getPorra().getCompeticion());
		result.setFechaLimite(FORMATTER_DATE.format(porraRellenada.getPorra()
				.getFechaLimite()));
		if (porraRellenada.getFechaRelleno() != null) {
			result.setFechaRelleno(FORMATTER_DATE.format(porraRellenada
					.getFechaRelleno()));
		}
		if (porraRellenada.getId() != null) {
			result.setId(porraRellenada.getId());
		}
		result.setIdPorra(porraRellenada.getPorra().getId());
		List<PartidoRellenadoDTO> partidosRellenados = new ArrayList<PartidoRellenadoDTO>();
		for (PartidoRellenado partidoRellenado : porraRellenada
				.getPartidosRellenados()) {
			partidosRellenados.add(partidoRellenadoUtilDTO
					.toRest(partidoRellenado));
		}
		result.setPartidosRellenadosDTO(partidosRellenados);

		return result;
	}

}
