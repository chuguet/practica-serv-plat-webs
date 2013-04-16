package com.upsam.apuestas.batch.app;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.upsam.apuestas.batch.bean.InfoUsuario;
import com.upsam.apuestas.batch.bean.InfoUsuarios;
import com.upsam.apuestas.batch.conversor.IConverterUtil;
import com.upsam.apuestas.batch.rest.IRestClient;
import com.upsam.porras.beans.Mail;
import com.upsam.porras.mail.IMailUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class BatchApp.
 */
@Component
public class BatchApp {

	/** The rest client. */
	@Inject
	private IRestClient restClient;

	/** The converter util. */
	@Inject
	private IConverterUtil converterUtil;

	/** The mail util. */
	private IMailUtil mailUtil;

	/** The queue. */
	@Resource(mappedName = "jms/queue")
	private Queue queue;

	/** The queue connection factory. */
	@Resource(mappedName = "jms/ConnectionFactory")
	private QueueConnectionFactory queueConnectionFactory;

	/**
	 * Inits the.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@PostConstruct
	public void init() throws Exception {
		Context ctx = new InitialContext();
		mailUtil = (IMailUtil) ctx
				.lookup("java:global/apuestas.app/apuestas.mail/MailUtil");
	}

	/**
	 * Main batch app.
	 */
	@Scheduled(fixedDelay = 5000)
	public void mainBatchApp() {
		InfoUsuarios infoUsuarios = restClient.getInfoUsuarios();
		for (InfoUsuario infoUsuario : infoUsuarios.getUsuarios()) {
			Mail mail = mailUtil.makeMail(converterUtil
					.infoUsuarioToUsuarioMail(infoUsuario));
			sendToQueue(mail);
		}
	}

	/**
	 * Send to queue.
	 * 
	 * @param mail
	 *            the mail
	 */
	private void sendToQueue(Mail mail) {
		QueueConnection queueConnection = null;
		try {
			queueConnection = queueConnectionFactory.createQueueConnection();
			queueConnection.start();
			QueueSession queueSession = queueConnection.createQueueSession(
					false, Session.AUTO_ACKNOWLEDGE);
			QueueSender sender = queueSession.createSender(queue);

			TextMessage msg = queueSession.createTextMessage();
			msg.setStringProperty("to", mail.getTo());
			msg.setStringProperty("subject", mail.getSubject());
			msg.setStringProperty("text", mail.getText());

			sender.send(msg);
		} catch (JMSException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (queueConnection != null) {
					queueConnection.close();
				}
			} catch (JMSException e) {
			}
		}
	}
}
