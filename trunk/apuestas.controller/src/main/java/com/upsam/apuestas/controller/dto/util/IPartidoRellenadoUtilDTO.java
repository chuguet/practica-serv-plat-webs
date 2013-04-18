package com.upsam.apuestas.controller.dto.util;

import com.upsam.apuestas.controller.dto.PartidoRellenadoDTO;
import com.upsam.apuestas.model.bean.PartidoRellenado;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IPartidoRellenadoUtilDTO.
 */
public interface IPartidoRellenadoUtilDTO {

	/**
	 * To business.
	 * 
	 * @param partidoRellenadoDTO
	 *            the partido rellenado dto
	 * @return the partido rellenado
	 * @throws AppException
	 *             the app exception
	 */
	PartidoRellenado toBusiness(PartidoRellenadoDTO partidoRellenadoDTO)
			throws AppException;

	/**
	 * To rest.
	 * 
	 * @param partidoRellenado
	 *            the partido rellenado
	 * @return the partido rellenado dto
	 * @throws AppException
	 *             the app exception
	 */
	PartidoRellenadoDTO toRest(PartidoRellenado partidoRellenado)
			throws AppException;
}
