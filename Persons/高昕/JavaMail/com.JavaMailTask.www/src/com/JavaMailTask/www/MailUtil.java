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
		//���ȴ���Email���ö��ŷָ��ַ���
		String[] tos= email.split(",");
		
		String from = ReadProperties.getValue("from");
		String auth_code =ReadProperties.getValue("auth_code");
		//ʹ��Properties
		Properties props = new Properties();
		
		props.put("mail.transport.proyocol", "smtp");
		props.put("mail.smtp.host", "smtp.126.com");
		props.put("mail.smtp.auth", true);
		
		//1.����Session�������÷����䡢�������룬��ҪProperties����
		Session session = Session.getInstance(props,new Authenticator() {
			//�õ������Ȩ��
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				
				return new PasswordAuthentication(from, auth_code);			}
			
		});	
		//2.�����ʼ�
		Message message = new MimeMessage(session);
		//���÷�����
		message.setFrom(new InternetAddress(from));
		
		//���ö���ռ���
		InternetAddress[] addresses = new InternetAddress[tos.length];
		
		for(int i = 0;i < tos.length;i++) {
			System.out.println("���͸�" + tos[i]);
			addresses[i] = new InternetAddress(tos[i]);
		}
		message.setRecipients(Message.RecipientType.TO, addresses);
		
		//��������
		message.setSubject(subject);
		message.setText(body);
		
		Transport.send(message);
		
		System.out.println("���ͳɹ�");
		
		
		
		
	}
	
	
	

}
