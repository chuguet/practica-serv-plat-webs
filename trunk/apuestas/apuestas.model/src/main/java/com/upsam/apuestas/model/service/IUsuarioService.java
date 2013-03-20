package com.upsam.apuestas.model.service;

import com.upsam.apuestas.model.bean.Usuario;
import com.upsam.apuestas.model.exception.AppException;

// TODO: Auto-generated Javadoc
/**
 * The Interface IUsuarioService.
 */
public interface IUsuarioService extends IModelService<Usuario> {
	
	/**
	 * Select by user.
	 *
	 * @param user the user
	 * @return the usuario
	 * @throws AppException the app exception
	 */
	Usuario selectByUser(String user) throws AppException;
}
