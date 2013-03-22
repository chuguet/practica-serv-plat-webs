package com.upsam.apuestas.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.controller.dto.PorraDTO;
import com.upsam.apuestas.controller.dto.util.IPorraUtilDTO;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraUtilDTO.
 */
@Component
public class PorraUtilDTO implements IPorraUtilDTO {

	private static final SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPorraUtilDTO#toBusiness(com.upsam
	 * .apuestas.controller.dto.PorraDTO)
	 */
	@Override
	public Porra toBusiness(PorraDTO porraDTO) throws AppException {
		Porra porra = new Porra();
		try {
			porra.setCompeticion(porraDTO.getCompeticion());
			porra.setFechaLimite(FORMATTER_DATE.parse(porraDTO.getFechaLimite()));
		} catch (ParseException e) {
			throw new AppException(e);
		}
		return porra;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPorraUtilDTO#toRest(com.upsam
	 * .apuestas.model.bean.Porra)
	 */
	@Override
	public PorraDTO toRest(Porra porra) throws AppException {
		PorraDTO porraDTO = new PorraDTO();
		porraDTO.setCompeticion(porra.getCompeticion());
		porraDTO.setFechaLimite(FORMATTER_DATE.format(porra.getFechaLimite()));
		porra.setId(porra.getId());
		return porraDTO;
	}
}
