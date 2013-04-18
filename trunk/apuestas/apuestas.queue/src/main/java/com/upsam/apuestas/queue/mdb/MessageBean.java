package com.upsam.apuestas.queue.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.upsam.apuestas.mail.core.beans.Mail;
import com.upsam.apuestas.mail.stateful.utils.IMailStatefulUtil;
import com.upsam.apuestas.mail.stateless.utils.IMailStatelessUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageBean.
 */
@MessageDriven(mappedName = "jms/queue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class MessageBean implements MessageListener {

	/** The Constant TO. */
	private static final String TO = "to";

	/** The Constant TEXT. */
	private static final String TEXT = "text";

	/** The Constant SUBJECT. */
	private static final String SUBJECT = "subject";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message msg) {
		try {
			Context ctx = new InitialContext();
			IMailStatelessUtil mailStatelessUtil = (IMailStatelessUtil) ctx
					.lookup("java:global/apuestas.app/apuestas.mail.stateless/MailStatelessUtil");
			IMailStatefulUtil mailStatefullUtil = (IMailStatefulUtil) ctx
					.lookup("java:global/apuestas.app/apuestas.mail.stateful/MailStatefulUtil");

			String to = msg.getStringProperty(TO);
			String text = msg.getStringProperty(TEXT);
			String subject = msg.getStringProperty(SUBJECT);
			
			Mail mail = new Mail(to, text, subject);
			
			mailStatefullUtil.sendMail(mail);
			mailStatelessUtil.sendMail(mail);
		} catch (JMSException e1) {
			throw new RuntimeException(e1);
		} catch (NamingException e2) {
			throw new RuntimeException(e2);
		}
	}
}
