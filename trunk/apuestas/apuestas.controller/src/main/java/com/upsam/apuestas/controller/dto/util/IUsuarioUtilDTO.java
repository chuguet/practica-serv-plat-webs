package com.upsam.apuestas.controller.dto.util;

import com.upsam.apuestas.controller.dto.UsuarioDTO;
import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDataTransferObjectUtil.
 */

public interface IUsuarioUtilDTO {

	/**
	 * To business.
	 *
	 * @param usuarioDTO the usuario dto
	 * @return the usuario
	 * @throws AppException the app exception
	 */
	Usuario toBusiness(UsuarioDTO usuarioDTO) throws AppException;

	/**
	 * To rest.
	 *
	 * @param usuario the usuario
	 * @return the usuario dto
	 * @throws AppException the app exception
	 */
	UsuarioDTO toRest(Usuario usuario) throws AppException;

}
