package test.hanxinjie.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {
	public static final String filePath="conf/config.properties";
	public static String getMail(String email) throws IOException {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(filePath);
		prop.load(fis);
		fis.close();
		return prop.getProperty(email);
	}
			
	public static void sendEmail(String email,String subject,String body) throws IOException {
		String from="lizeyu20020115@126.com"; 
		String auth_code="XJJJVRWAWUCTGJXA";
		//接收邮箱
		email=getMail("tomail");
		String[] mail=email.split(",");
		int len=mail.length;
		
		Properties props=new Properties();
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host","smtp.126.com");
		props.put("mail.smtp.auth",true);
		
		//1.创建Session的对象 ,设置邮箱，授权码
		Session session=Session.getInstance(props,new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,auth_code);
			}
		});
		//2.创建邮件
		int i=0;
		for(i=0;i<len;i++) {
			try {
				Message message=new MimeMessage(session);
				message.setFrom(new InternetAddress(from));
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(mail[i]));
//				message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
				
				//设置主题
				message.setSubject(subject);
				message.setText(body);
				//发送邮件
				Transport.send(message);
				System.out.println("发送成功");
			}catch(MessagingException e) {
				//TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
