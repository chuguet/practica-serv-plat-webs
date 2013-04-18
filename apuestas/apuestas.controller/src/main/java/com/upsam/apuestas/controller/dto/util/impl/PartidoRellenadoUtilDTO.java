package com.upsam.apuestas.controller.dto.util.impl;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.controller.dto.PartidoRellenadoDTO;
import com.upsam.apuestas.controller.dto.util.IPartidoRellenadoUtilDTO;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Class PartidoUtilDTO.
 */
@Component
public class PartidoRellenadoUtilDTO extends ResultadoUtil implements
		IPartidoRellenadoUtilDTO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPartidoRellenadoUtilDTO#toBusiness
	 * (com.upsam.apuestas.controller.dto.PartidoRellenadoDTO)
	 */
	@Override
	public PartidoRellenado toBusiness(PartidoRellenadoDTO partidoRellenadoDTO)
			throws AppException {
		PartidoRellenado result = new PartidoRellenado();
		if (partidoRellenadoDTO.getId() != null) {
			result.setId(partidoRellenadoDTO.getId());
		}
		result.setOrdinal(partidoRellenadoDTO.getOrdinal());
		result.setResultado(super.getResultadoByNameId(partidoRellenadoDTO
				.getResultado()));
		result.setLocal(partidoRellenadoDTO.getLocal());
		result.setVisitante(partidoRellenadoDTO.getVisitante());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.controller.dto.util.IPartidoRellenadoUtilDTO#toRest
	 * (com.upsam.apuestas.model.bean.PartidoRellenado)
	 */
	@Override
	public PartidoRellenadoDTO toRest(PartidoRellenado partidoRellenado)
			throws AppException {
		PartidoRellenadoDTO result = new PartidoRellenadoDTO();
		if (partidoRellenado.getId() != null) {
			result.setId(partidoRellenado.getId());
		}
		result.setLocal(partidoRellenado.getLocal());
		result.setOrdinal(partidoRellenado.getOrdinal());
		result.setVisitante(partidoRellenado.getVisitante());
		if (partidoRellenado.getResultado() != null) {
			result.setResultado(partidoRellenado.getResultado().getNameId());
		}
		return result;
	}

}
