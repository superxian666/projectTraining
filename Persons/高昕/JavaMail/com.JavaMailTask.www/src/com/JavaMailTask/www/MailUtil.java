package com.JavaMailTask.www;

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

	
	public static void sendEmail(String email,String subject,String body) throws IOException, AddressException, MessagingException {
		//首先处理Email，用逗号分割字符串
		String[] tos= email.split(",");
		
		String from = ReadProperties.getValue("from");
		String auth_code =ReadProperties.getValue("auth_code");
		//使用Properties
		Properties props = new Properties();
		
		props.put("mail.transport.proyocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		
		//1.创建Session对象，设置发件箱、设置密码，需要Properties对象
		Session session = Session.getInstance(props,new Authenticator() {
			//得到密码的权限
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(from, auth_code);			}
			
		});	
		//2.创建邮件
		Message message = new MimeMessage(session);
		//设置发件人
		message.setFrom(new InternetAddress(from));
		
		//设置多个收件人
		InternetAddress[] addresses = new InternetAddress[tos.length];
		
		for(int i = 0;i < tos.length;i++) {
			System.out.println("发送给" + tos[i]);
			addresses[i] = new InternetAddress(tos[i]);
		}
		message.setRecipients(Message.RecipientType.TO, addresses);
		
		//设置主题
		message.setSubject(subject);
		message.setText(body);
		
		Transport.send(message);
		
		System.out.println("发送成功");
		
		
		
		
	}
	
	
	

}
