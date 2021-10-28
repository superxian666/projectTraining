//����6 2021��5��19�� ������
//����� 2019�� ������� 2019012499 

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

//		��ҪProperties��������SMTP������		
		Properties props = new Properties();
//		Properties props=new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", "true");
//		1������Session�������÷����䡢��Ȩ��
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, auto_code);
			}
		});
//		2.�����ʼ�
		Message message = new MimeMessage(session);
//		���÷�����
		message.setFrom(new InternetAddress(from));
//		�����ռ���
		String[] fileds = email.split(",");
		int length = fileds.length;
		InternetAddress[] address_list = new InternetAddress[length];
		for (int i = 0; i < length; i++) {
			address_list[i] = new InternetAddress(fileds[i]);
		}
		message.setRecipients(Message.RecipientType.TO, address_list);
//		��������
		message.setSubject(subject);
		message.setText(body);
//		�����ʼ�
		Transport.send(message);
		System.out.println("���ͳɹ�");
	}
}
