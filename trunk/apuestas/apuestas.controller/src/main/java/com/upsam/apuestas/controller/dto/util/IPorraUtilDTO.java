package com.upsam.apuestas.controller.dto.util;

import com.upsam.apuestas.controller.dto.PorraDTO;
import com.upsam.apuestas.model.bean.Porra;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPorraUtilDTO.
 */
public interface IPorraUtilDTO {

	/**
	 * To business.
	 * 
	 * @param porraDTO
	 *            the porra dto
	 * @return the porra
	 * @throws AppException
	 *             the app exception
	 */
	Porra toBusiness(PorraDTO porraDTO) throws AppException;

	/**
	 * To rest.
	 * 
	 * @param porra
	 *            the porra
	 * @return the porra dto
	 * @throws AppException
	 *             the app exception
	 */
	PorraDTO toRest(Porra porra) throws AppException;
}
