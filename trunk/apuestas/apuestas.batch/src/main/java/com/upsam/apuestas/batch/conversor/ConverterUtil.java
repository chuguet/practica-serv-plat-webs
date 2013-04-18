package com.upsam.apuestas.batch.conversor;

import org.springframework.stereotype.Component;

import com.upsam.apuestas.batch.bean.InfoUsuario;
import com.upsam.apuestas.mail.core.beans.InfoUsuarioMail;

// TODO: Auto-generated Javadoc
/**
 * The Class ConverterUtil.
 */
@Component
public class ConverterUtil implements IConverterUtil {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.apuestas.batch.conversor.IConverterUtil#infoUsuarioToUsuarioMail
	 * (com.upsam.apuestas.batch.bean.InfoUsuario)
	 */
	@Override
	public InfoUsuarioMail infoUsuarioToUsuarioMail(InfoUsuario usuario) {
		InfoUsuarioMail result = new InfoUsuarioMail();
		result.setEmail(usuario.getEmail());
		return result;
	}

}
