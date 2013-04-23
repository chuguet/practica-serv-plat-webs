package com.upsam.apuestas.queue.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import com.upsam.apuestas.mail.core.beans.Mail;
import com.upsam.apuestas.mail.core.utils.IMailUtil;
import com.upsam.apuestas.mail.core.utils.MailUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageBean.
 */
@MessageDriven(mappedName = "jms/queue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class MessageBean implements MessageListener {

	/** The Constant mailUtil. */
	private static final IMailUtil mailUtil = new MailUtil();

	/** The Constant SUBJECT. */
	private static final String SUBJECT = "subject";

	/** The Constant TEXT. */
	private static final String TEXT = "text";

	/** The Constant TO. */
	private static final String TO = "to";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message msg) {
		try {
			String to = msg.getStringProperty(TO);
			String text = msg.getStringProperty(TEXT);
			String subject = msg.getStringProperty(SUBJECT);

			Mail mail = new Mail(to, text, subject);

			mailUtil.sendMail(mail);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
