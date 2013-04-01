package com.upsam.apuestas.controller.dto.util.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.controller.dto.PartidoDTO;
import com.upsam.apuestas.controller.dto.util.IPartidoUtilDTO;
import com.upsam.apuestas.controller.dto.util.IPorraUtilDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoUtilDTO.
 */
@Component
public class PartidoUtilDTO extends ResultadoUtil implements IPartidoUtilDTO {

	/** The porra util dto. */
	@Inject
	private IPorraUtilDTO porraUtilDTO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPartidoUtilDTO#toBusiness(com
	 * .upsam.apuestas.controller.dto.PartidoDTO)
	 */
	@Override
	public Partido toBusiness(PartidoDTO partidoDTO) throws AppException {
		Partido partido = new Partido();
		partido.setId(partidoDTO.getId());
		partido.setLocal(partidoDTO.getLocal());
		partido.setOrdinal(partidoDTO.getOrdinal());
		partido.setResultado(getResultadoByNameId(partidoDTO.getResultado()));
		partido.setVisitante(partidoDTO.getVisitante());
		return partido;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPartidoUtilDTO#toRest(com.upsam
	 * .apuestas.model.bean.Partido)
	 */
	@Override
	public PartidoDTO toRest(Partido partido) throws AppException {
		PartidoDTO partidoDTO = new PartidoDTO();
		partidoDTO.setId(partido.getId());
		partidoDTO.setLocal(partido.getLocal());
		partidoDTO.setOrdinal(partido.getOrdinal());
		if (partido.getResultado() != null) {
			partidoDTO.setResultado(partido.getResultado().getNameId());
		}
		partidoDTO.setVisitante(partido.getVisitante());
		return partidoDTO;
	}

}
