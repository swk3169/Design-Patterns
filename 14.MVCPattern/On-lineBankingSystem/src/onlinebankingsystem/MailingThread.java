package onlinebankingsystem;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailingThread extends Thread
{
	private String receiverMail;

	private String receiver;
	private String title;
	private String contents;
	private static String USER = "user";
	private static String HOST = "smtp.naver.com";
	private static String PASSWORD = "password";

	public MailingThread(String receiver, String title, String contents)
	{
		this.receiver = receiver;
		this.title = title;
		this.contents = contents;
	}

	@Override
	public void run()
	{
		// Get the session object
		Properties props = new Properties();
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(USER, PASSWORD);
			}
		});

		// Compose the message
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(USER));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));

			// Subject
			message.setSubject(title);

			// Text
			message.setText(contents);

			// send the message
			Transport.send(message);
			System.out.println("message sent successfully...");
		} catch (MessagingException e)
		{
			System.out.println("message can not sent!");
			// e.printStackTrace();
		}
	}

}
