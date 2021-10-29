package com.www.lzy;

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

//简单的邮件内容发送类
public class MailUtil {
	public static void sendEmail(String email, String subject, String body)
			throws AddressException, MessagingException, IOException {

		String from="test2014123@126.com";
		String auth_code="FWXQWTJMGXLJJBLX";
		// 设置SMTP服务
		Properties props = new Properties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);

		// 1.创建session对象
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,	auth_code);
			
			}
		});
		// 2、创建邮箱
		Message message = new MimeMessage(session);
		// 设置发件人
		message.setFrom(new InternetAddress(from));
		// 设置收件人
		String[] address = email.split(",");
		InternetAddress[] address_list = new InternetAddress[address.length];
		for (int i = 0; i < address.length; i++) {
			address_list[i] = new InternetAddress(address[i]);
		}
		message.addRecipients(Message.RecipientType.TO, address_list);
		// 设置主题
		message.setSubject(subject);
		message.setText(body);

		// 3、发送邮件
		Transport.send(message);
		System.out.println("发送成功");

	}
	public static void main(String[] args) throws AddressException, MessagingException, IOException {
		sendEmail("3330181323@qq.com", "测试报告", "hello");
		
	}
}
