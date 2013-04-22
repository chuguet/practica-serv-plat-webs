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
import com.upsam.apuestas.mail.core.beans.Mail;
import com.upsam.apuestas.mail.stateful.utils.IMailStatefulUtil;
import com.upsam.apuestas.mail.stateless.utils.IMailStatelessUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class BatchApp.
 */
@Component
public class BatchApp {

	/** The Constant SUBJECT. */
	private static final String SUBJECT = "subject";

	/** The Constant TEXT. */
	private static final String TEXT = "text";

	/** The Constant TO. */
	private static final String TO = "to";

	/** The converter util. */
	@Inject
	private IConverterUtil converterUtil;

	/** The mail stateful util. */
	private IMailStatefulUtil mailStatefulUtil;

	/** The mail stateless util. */
	private IMailStatelessUtil mailStatelessUtil;

	/** The queue. */
	@Resource(mappedName = "jms/queue")
	private Queue queue;

	/** The queue connection factory. */
	@Resource(mappedName = "jms/ConnectionFactory")
	private QueueConnectionFactory queueConnectionFactory;

	/** The rest client. */
	@Inject
	private IRestClient restClient;

	/**
	 * Inits the.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@PostConstruct
	public void init() throws Exception {
		Context ctx = new InitialContext();
		mailStatelessUtil = (IMailStatelessUtil) ctx
				.lookup("java:global/apuestas.app/apuestas.mail.stateless/MailStatelessUtil");
		mailStatefulUtil = (IMailStatefulUtil) ctx
				.lookup("java:global/apuestas.app/apuestas.mail.stateful/MailStatefulUtil");
	}

	/**
	 * Main batch app.
	 */
	@Scheduled(fixedDelay = 1800000)
	public void mainBatchApp() {
		InfoUsuarios infoUsuarios = restClient.getInfoUsuarios();
		for (InfoUsuario infoUsuario : infoUsuarios.getUsuarios()) {
			Mail mailStateless = mailStatelessUtil.makeMail(converterUtil
					.infoUsuarioToUsuarioMail(infoUsuario));
			Mail mailStateful = mailStatefulUtil.makeMail(converterUtil
					.infoUsuarioToUsuarioMail(infoUsuario));
			sendToQueue(mailStateless);
			sendToQueue(mailStateful);
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
			msg.setStringProperty(TO, mail.getTo());
			msg.setStringProperty(TEXT, mail.getText());
			msg.setStringProperty(SUBJECT, mail.getSubject());

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
