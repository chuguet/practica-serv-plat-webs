package com.upsam.porras.mail;

import javax.ejb.Local;

import com.upsam.porras.beans.InfoUsuarioMail;
import com.upsam.porras.beans.Mail;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMailUtil.
 */
@Local
public interface IMailUtil {

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
