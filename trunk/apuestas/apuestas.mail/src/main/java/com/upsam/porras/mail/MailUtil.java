package com.upsam.porras.mail;

import javax.ejb.Stateless;

import com.upsam.porras.beans.InfoUsuarioMail;
import com.upsam.porras.beans.Mail;

// TODO: Auto-generated Javadoc
/**
 * The Class MailUtil.
 */
@Stateless
public class MailUtil implements IMailUtil {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.porras.mail.IMailUtil#makeMail(com.upsam.porras.beans.
	 * InfoUsuarioMail)
	 */
	@Override
	public Mail makeMail(InfoUsuarioMail infoUsuario) {
		Mail result = new Mail();
		result.setTo(infoUsuario.getEmail());
		result.setSubject("Resumen de porras.");
		result.setText("Prueba de correo.");
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.upsam.porras.mail.IMailUtil#sendMail(com.upsam.porras.beans.Mail)
	 */
	@Override
	public void sendMail(Mail mail) {
		System.out.println("Si llego aqui soy el amo:");
		System.out.println("SUBJECT: " + mail.getSubject());
		System.out.println("TEXT: " + mail.getText());
		System.out.println("TO: " + mail.getTo());
	}
}
