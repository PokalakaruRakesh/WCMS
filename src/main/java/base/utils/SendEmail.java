package base.utils;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;

public class SendEmail {

	/**
	 * send mail
	 */

	public static void sendEmailWithAttachment() {
		// Create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath(System.getProperty("user.dir") + ConfigReader.getValue("ExtentReportPath"));
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		// attachment.setDescription("Picture of John");
		// attachment.setName("John");
System.out.println( ConfigReader.getValue("SendEmailPassword"));
		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setAuthenticator(new DefaultAuthenticator(ConfigReader.getValue("SendEmailFrom"),"Test@123"));
		email.setHostName(ConfigReader.getValue("SMTPaddress"));
		email.setSmtpPort(ConfigReader.getIntValue("SMTPPort"));
		email.setSSLOnConnect(true);
		try {
			email.addTo(ConfigReader.getValue("SendEmailTO"));
			email.setFrom(ConfigReader.getValue("SendEmailFrom"));
			email.setSubject(ConfigReader.getValue("EmailSubject"));
			email.setMsg(ConfigReader.getValue("EmailBody"));

			// add the attachment
			email.attach(attachment);

			// send the email
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}

	}

	
	public static void sendEmailWithAttachment(String sendEmailorNot) {
		// Create the attachment
		
		if (ConfigReader.getValue("SendEmail").equalsIgnoreCase("Yes")) {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(System.getProperty("user.dir") + ConfigReader.getValue("ExtentReportPath"));
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setAuthenticator(new DefaultAuthenticator(ConfigReader.getValue("SendEmailFrom"),ConfigReader.getValue("SendEmailPassword")));
			email.setHostName(ConfigReader.getValue("SMTPaddress"));
			email.setSmtpPort(ConfigReader.getIntValue("SMTPPort"));
			email.setSSLOnConnect(true);
			try {
				email.addTo(ConfigReader.getValue("SendEmailTO"));
				email.setFrom(ConfigReader.getValue("SendEmailFrom"));
				email.setSubject(ConfigReader.getValue("EmailSubject"));
				email.setMsg(ConfigReader.getValue("EmailBody"));

				// add the attachment
				email.attach(attachment);

				// send the email
				email.send();
			} catch (EmailException e) {
				e.printStackTrace();
			}

		}
		
		else {
			System.out.println("Mail not Sent because Flag Value is not Yes & Value of Flag is"+ConfigReader.getValue("SendEmail"));
		}

	}
	
	
}
