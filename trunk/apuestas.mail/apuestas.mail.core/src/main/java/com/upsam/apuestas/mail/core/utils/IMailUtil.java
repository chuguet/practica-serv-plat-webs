package com.upsam.apuestas.mail.core.utils;

import java.util.Date;

import com.upsam.apuestas.mail.core.beans.InfoUsuarioMail;
import com.upsam.apuestas.mail.core.beans.Mail;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMailUtil.
 */
public interface IMailUtil {

	/**
	 * Make mail.
	 * 
	 * @param infoUsuario
	 *            the info usuario
	 * @param subject
	 *            the subject
	 * @param date
	 *            the date
	 * @return the mail
	 */
	Mail makeMail(InfoUsuarioMail infoUsuario, String subject, Date date);

	/**
	 * Send mail.
	 * 
	 * @param mail
	 *            the mail
	 */
	void sendMail(Mail mail);
}
