package com.upsam.apuestas.mail.stateless.utils;

import javax.ejb.Local;

import com.upsam.apuestas.mail.core.beans.InfoUsuarioMail;
import com.upsam.apuestas.mail.core.beans.Mail;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMailUtil.
 */
@Local
public interface IMailStatelessUtil {

	/**
	 * Make mail.
	 * 
	 * @param infoUsuario
	 *            the info usuario
	 * @return the mail
	 */
	Mail makeMail(InfoUsuarioMail infoUsuario);

	/**
	 * Send mail.
	 * 
	 * @param mail
	 *            the mail
	 */
	void sendMail(Mail mail);
}
