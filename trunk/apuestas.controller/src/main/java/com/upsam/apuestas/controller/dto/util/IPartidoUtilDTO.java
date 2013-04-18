package com.upsam.apuestas.controller.dto.util;

import com.upsam.apuestas.controller.dto.PartidoDTO;
import com.upsam.apuestas.model.bean.Partido;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPartidoUtilDTO.
 */
public interface IPartidoUtilDTO {

	/**
	 * To business.
	 * 
	 * @param partidoDTO
	 *            the partido dto
	 * @return the partido
	 * @throws AppException
	 *             the app exception
	 */
	Partido toBusiness(PartidoDTO partidoDTO) throws AppException;

	/**
	 * To rest.
	 * 
	 * @param partido
	 *            the partido
	 * @return the partido dto
	 * @throws AppException
	 *             the app exception
	 */
	PartidoDTO toRest(Partido partido) throws AppException;
}
