package jp.g_aster.social.util;

import javax.mail.internet.MimeMessage.RecipientType;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

public class MailUtil {

	public static void send(String to, String name, String message){
		 Email email = new Email();
		 email.setFromAddress(null, "noreply@g-aster.jp");
		 email.addRecipient("Sugar Cane", to, RecipientType.TO);
		 email.setText(name+"様より\n\n"+message);
		 email.setSubject("お問い合わせ");
		 Mailer mailer = new Mailer("mail.e-enhance.net", 587, "g-aster", "Yukana001",TransportStrategy.SMTP_PLAIN);
		 mailer.sendMail(email);
	}
}
