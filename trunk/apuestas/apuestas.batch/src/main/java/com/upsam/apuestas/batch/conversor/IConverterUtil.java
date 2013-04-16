package com.upsam.apuestas.batch.conversor;

import com.upsam.apuestas.batch.bean.InfoUsuario;
import com.upsam.porras.beans.InfoUsuarioMail;

// TODO: Auto-generated Javadoc
/**
 * The Interface IConverterUtil.
 */
public interface IConverterUtil {

	/**
	 * Info usuario to usuario mail.
	 * 
	 * @param usuario
	 *            the usuario
	 * @return the info usuario mail
	 */
	InfoUsuarioMail infoUsuarioToUsuarioMail(InfoUsuario usuario);
}
