//任务6 2021年5月19日 星期三
//朱铮麟 2019级 软件六班 2019012499 

package demo;

import java.io.IOException;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class MailUtil {

	public static void sendEmail(String email, String subject, String body)
			throws IOException, AddressException, MessagingException {
		String from = "a963541629@126.com";
		String auto_code = "UORTYWDLRZHRVMFQ";

//		需要Properties对象设置SMTP服务器		
		Properties props = new Properties();
//		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", "true");
//		1、创建Session对象，设置发件箱、授权码
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, auto_code);
			}
		});
//		2.创建邮件
		Message message = new MimeMessage(session);
//		设置发件人
		message.setFrom(new InternetAddress(from));
//		设置收件人
		String[] fileds = email.split(",");
		int length = fileds.length;
		InternetAddress[] address_list = new InternetAddress[length];
		for (int i = 0; i < length; i++) {
			address_list[i] = new InternetAddress(fileds[i]);
		}
		message.setRecipients(Message.RecipientType.TO, address_list);
//		设置主题
		message.setSubject(subject);
		message.setText(body);
//		发送邮件
		Transport.send(message);
		System.out.println("发送成功");
	}
}
