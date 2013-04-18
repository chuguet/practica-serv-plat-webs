package com.upsam.apuestas.mail.core.utils;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.upsam.apuestas.mail.core.beans.InfoUsuarioMail;
import com.upsam.apuestas.mail.core.beans.Mail;

// TODO: Auto-generated Javadoc
/**
 * The Class MailUtil.
 */
public class MailUtil implements IMailUtil {

	private static final String HTML = "html";
	private static final String ENCODE = "ISO-8859-1";
	private static final String FROM = "Apuestas UPSAM";
	private static final String USER = "apuestas.upsam@gmail.com";
	private static final String PASSWORD = "upsam.apuestas";
	private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.upsam.porras.mail.IMailUtil#makeMail(com.upsam.porras.beans.
	 * InfoUsuarioMail)
	 */
	@Override
	public Mail makeMail(InfoUsuarioMail infoUsuario, String subject, Date date) {
		Mail result = new Mail();
		result.setTo(infoUsuario.getEmail());
		result.setText("<p>Hoy es <b>" + DATE_FORMATTER.format(date)
				+ "</b></p><p>Prueba de <b>correo</b>.</p>");
		result.setSubject(subject);
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

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(USER, PASSWORD);
					}
				});

		try {

			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER, FROM));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(
					mail.getTo()));
			message.setSubject(mail.getSubject());
			message.setText(mail.getText(), ENCODE, HTML);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
