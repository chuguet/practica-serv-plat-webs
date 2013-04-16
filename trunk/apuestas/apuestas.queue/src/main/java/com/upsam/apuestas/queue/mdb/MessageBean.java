package com.upsam.apuestas.queue.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.upsam.porras.beans.Mail;
import com.upsam.porras.mail.IMailUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageBean.
 */
@MessageDriven(mappedName = "jms/queue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class MessageBean implements MessageListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message msg) {
		try {
			Context ctx = new InitialContext();
			IMailUtil mailUtil = (IMailUtil) ctx
					.lookup("java:global/apuestas.app/apuestas.mail/MailUtil");

			String to = msg.getStringProperty("to");
			String subject = msg.getStringProperty("subject");
			String text = msg.getStringProperty("text");
			Mail mail = new Mail(to, subject, text);
			mailUtil.sendMail(mail);
		} catch (JMSException e1) {
			throw new RuntimeException(e1);
		} catch (NamingException e2) {
			throw new RuntimeException(e2);
		}
	}
}