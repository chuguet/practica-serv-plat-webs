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

import com.upsam.apuestas.mail.core.beans.EstadisticaCompeticionMail;
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
		StringBuffer text = new StringBuffer("<h2>Estimado usuari&#64; ")
				.append(infoUsuario.getNombre())
				.append(" ")
				.append(infoUsuario.getApellidos())
				.append(".</h2>")
				.append("</br>")
				.append("<p>Le informamos que en la &uacute;ltima jornada ha tenido un total de <b>")
				.append(infoUsuario.getPromedioTotal())
				.append("</b> de promedio aciertos.</p>");
		if (!infoUsuario.getEstadisticaCompeticionMail().isEmpty()) {
			text.append("<p>Desglose de apuestas por competici&oacute;n: </p></br><ul>");
			for (EstadisticaCompeticionMail estadisticaCompeticionMail : infoUsuario
					.getEstadisticaCompeticionMail()) {
				text.append("<li>Para la competici&oacute;n <b>")
						.append(estadisticaCompeticionMail.getCompeticion())
						.append("</b> tiene un ")
						.append(estadisticaCompeticionMail.getPromedioParcial())
						.append(" de promedio de aciertos. Su fecha l&iacute;mite de relleno fue el ")
						.append(estadisticaCompeticionMail.getFechaLimite())
						.append(" y la &uacute;ltima vez que usted la rellen&oacute; fue el ")
						.append(estadisticaCompeticionMail.getFechaRelleno())
						.append(".</li>");
			}
			text.append("</ul></br></br>");
		}
		text.append("<p>Si desea obtener m&aacute;s informaci&oacute;n visite nuestra p&aacute;gina web.</p></br><p>Gracias y un saludo.</p></br></br>");
		text.append("<h6 align='right'>Fecha del sistema: <b>")
				.append(DATE_FORMATTER.format(date)).append("</b></h6>");
		result.setText(text.toString());
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
