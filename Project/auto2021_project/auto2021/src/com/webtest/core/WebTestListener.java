package com.webtest.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;
import java.util.Set;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.naming.Context;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.mysql.fabric.xmlrpc.base.Array;
import com.webtest.utils.ReadProperties;

import freemarker.FreemarkerTest;

import sendMail.ReadHTML;

public class WebTestListener extends TestListenerAdapter {
	public static void sendEmail(String email,String subject) throws MessagingException, IOException {
		String info=ReadHTML.reMailString();
		
//		String from="test2014123@126.com";
//		String auth_code="FWXQWTJMGXLJJBLX";
		
//		获取属文件中发件人和授权码的相关信息
		String from = ReadProperties.getPropertyValue("from");
		
		String auth_code =ReadProperties.getPropertyValue("auth_code");
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
		// 2、创建邮�?
		Message message = new MimeMessage(session);
		// 设置发件�?
		message.setFrom(new InternetAddress(from));
		// 设置收件�?.
		email=ReadProperties.getPropertyValue("tomail");
		String[] address = email.split(",");
		InternetAddress[] address_list = new InternetAddress[address.length];
		for (int i = 0; i < address.length; i++) {
			address_list[i] = new InternetAddress(address[i]);
		}
		message.addRecipients(Message.RecipientType.TO, address_list);
		// 设置主题
		message.setSubject(subject);
		
		// MimeMultipart类是�?个容器类，包含MimeBodyPart类型的对�?    	
		Multipart mainPart = new MimeMultipart();  
		//创建�?个包含HTML内容的MimeBodyPart
		BodyPart body1=new MimeBodyPart();
		//设置html内容
		body1.setContent(info,"text/html;charset=utf-8");
		//将MimeMultipart设置为邮件内�?
		mainPart.addBodyPart(body1);
		message.setContent(mainPart);

		// 3、发送邮�?
		Transport.send(message);
		System.out.println("发送成功");

	}
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
		FreemarkerTest ft = new FreemarkerTest();
		ITestNGMethod[] methods=this.getAllTestMethods();
		List<ITestResult> successList=this.getPassedTests();
		List<ITestResult> failList=this.getFailedTests();
		List success_list=new ArrayList();
		List fail_list=new ArrayList();
		
		for(int i=0;i<successList.size();i++) {
			ITestResult tr=successList.get(i);
			String success_item=tr.getInstanceName()+":"+tr.getName();
			System.out.println(success_item+"成功了");
			success_list.add(tr.getInstanceName()+":"+tr.getName());
			ft.setCase(tr.getInstanceName()+":"+tr.getName(), "PASS", "");
		}
		for(int i=0;i<failList.size();i++) {
			ITestResult tr=failList.get(i);
			String fail_item=tr.getInstanceName()+":"+tr.getName();
			System.out.println(fail_item+"失败了");
			fail_list.add(tr.getInstanceName()+":"+tr.getName());
			ft.setCase(tr.getInstanceName()+":"+tr.getName(), "FAIL", "");
		}
		
		ft.setDetails("qq","wo","s");
		System.out.println("----------------------------------------");
		try {
			sendEmail("", "测试报告");
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
