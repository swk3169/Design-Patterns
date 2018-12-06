package onlinebankingsystem;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailClient extends ClientCommand
{
	private String subject;
	private String text;

	public MailClient(ClientDatabase clientDB, String subject, String text)
	{
		super.clientDB = clientDB;
		this.subject = subject;
		this.text = text;
	}

	public void execute()
	{
		ArrayList<Client> clientList = clientDB.getClientList();

		int size = clientList.size();

		String host = "smtp.naver.com";
		final String user = "user";
		final String password = "password";

		for (int i = 0; i < size; ++i)
		{
			Client client = clientList.get(i);

			// String to = client.getEMail();
			//
			// // Get the session object
			// Properties props = new Properties();
			// props.put("mail.smtp.host", host);
			// props.put("mail.smtp.auth", "true");
			//
			// Session session = Session.getDefaultInstance(props, new
			// javax.mail.Authenticator() {
			// protected PasswordAuthentication getPasswordAuthentication() {
			// return new PasswordAuthentication(user, password);
			// }
			// });
			//
			// // Compose the message
			// try {
			// MimeMessage message = new MimeMessage(session);
			// message.setFrom(new InternetAddress(user));
			// message.addRecipient(Message.RecipientType.TO, new
			// InternetAddress(to));
			//
			// // Subject
			// message.setSubject(subject);
			//
			// // Text
			// message.setText(text);
			//
			// // send the message
			// Transport.send(message);
			// System.out.println("message sent successfully...");
			// } catch (MessagingException e) {
			// System.out.println("message can not sent!");
			// //e.printStackTrace();
			// }
			//
			String receiver = client.getEMail();
			MailingThread mailing = new MailingThread(receiver, subject, text);
			mailing.start();
		}
	}
}
