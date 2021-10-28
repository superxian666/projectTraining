package com.JavaMailTask.www;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.AddressException;

public class JavaMailTestListener extends TestListenerAdapter{
	
	@Override
	public void onTestFailure(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestFailure(tr);
	}
	@Override
	public void onTestSuccess(ITestResult tr) {
		// TODO Auto-generated method stub
		super.onTestSuccess(tr);
	}
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
		System.out.println("������ִ��onfinish");
		String body = "ʧ�ܰ�����\n";
		List<ITestResult> fail_list = this.getFailedTests();
		
		List<ITestResult> pass_list = this.getPassedTests();
		for(ITestResult tr:fail_list) {
			String class_method = tr.getInstanceName() +'_'+tr.getName();
			body = body + class_method + "\n";
		}
		body = body +"�ɹ�������\n";
		
		for(ITestResult tr:pass_list) {
			String class_method = tr.getInstanceName() +'_'+tr.getName();
			body = body + class_method + "\n";
		}
		String email = null;
		try {
			email = ReadProperties.getValue("tomail");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date now = new Date();
		SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");
		String subject = simpleDateFormat + "���Ա���";
		try {
			MailUtil.sendEmail(email, subject, body);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
	
	

