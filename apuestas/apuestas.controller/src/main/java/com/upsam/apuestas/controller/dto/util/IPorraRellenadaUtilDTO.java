package com.upsam.apuestas.controller.dto.util;

import com.upsam.apuestas.controller.dto.PorraRellenadaDTO;
import com.upsam.apuestas.model.bean.PorraRellenada;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPorraRellenadaUtilDTO.
 */
public interface IPorraRellenadaUtilDTO {

	/**
	 * To business.
	 * 
	 * @param porraRellenadaDTO
	 *            the porra rellenada dto
	 * @return the porra rellenada
	 * @throws AppException
	 *             the app exception
	 */
	PorraRellenada toBusiness(PorraRellenadaDTO porraRellenadaDTO)
			throws AppException;

	/**
	 * To rest.
	 * 
	 * @param porraRellenada
	 *            the porra rellenada
	 * @return the porra rellenada dto
	 * @throws AppException
	 *             the app exception
	 */
	PorraRellenadaDTO toRest(PorraRellenada porraRellenada) throws AppException;
}
