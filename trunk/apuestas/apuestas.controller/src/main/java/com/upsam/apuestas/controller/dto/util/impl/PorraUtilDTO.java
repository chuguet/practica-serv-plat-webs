package com.upsam.apuestas.controller.dto.util.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.controller.dto.PartidoDTO;
import com.upsam.apuestas.controller.dto.PorraDTO;
import com.upsam.apuestas.controller.dto.util.IPartidoUtilDTO;
import com.upsam.apuestas.controller.dto.util.IPorraUtilDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Class PorraUtilDTO.
 */
@Component
public class PorraUtilDTO implements IPorraUtilDTO {

	@Inject
	private IPartidoUtilDTO partidoUtilDTO;

	private static final SimpleDateFormat FORMATTER_DATE = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss");

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
			porra.setId(porraDTO.getId());
			porra.setCompeticion(porraDTO.getCompeticion());
			porra.setFechaLimite(FORMATTER_DATE.parse(porraDTO.getFechaLimite()));

			List<Partido> partidos = new ArrayList<Partido>();
			for (PartidoDTO partidoDTO : porraDTO.getPartidosDTO()) {
				partidos.add(partidoUtilDTO.toBusiness(partidoDTO));
			}
			if (!partidos.isEmpty()) {
				for (Partido partido : partidos) {
					partido.setPorra(porra);
				}
				porra.setPartidos(partidos);
			}
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
		porraDTO.setId(porra.getId());
		List<PartidoDTO> partidosDTO = new ArrayList<PartidoDTO>();
		for (Partido partido : porra.getPartidos()) {
			partidosDTO.add(partidoUtilDTO.toRest(partido));
		}
		porraDTO.setPartidosDTO(partidosDTO);
		return porraDTO;
	}
}
