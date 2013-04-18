package com.upsam.apuestas.mail.stateful.utils;

import java.util.Date;

import javax.ejb.Stateful;

import com.upsam.apuestas.mail.core.beans.InfoUsuarioMail;
import com.upsam.apuestas.mail.core.beans.Mail;
import com.upsam.apuestas.mail.core.utils.IMailUtil;
import com.upsam.apuestas.mail.core.utils.MailUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class MailUtil.
 */
@Stateful
public class MailStatefulUtil implements IMailStatefulUtil {

	/** The Constant SUBJECT. */
	private static final String SUBJECT = "Resumen de apuestas con estado.";

	/** The mail util. */
	private final static IMailUtil mailUtil = new MailUtil();

	/** The fecha. */
	private Date fecha = new Date();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.porras.mail.IMailUtil#makeMail(com.upsam.porras.beans.
	 * InfoUsuarioMail)
	 */
	@Override
	public Mail makeMail(InfoUsuarioMail infoUsuario) {
		Mail mail = mailUtil.makeMail(infoUsuario, SUBJECT, fecha);
		return mail;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.porras.mail.IMailUtil#sendMail(com.upsam.porras.beans.Mail)
	 */
	@Override
	public void sendMail(Mail mail) {
		mailUtil.sendMail(mail);
	}
}
