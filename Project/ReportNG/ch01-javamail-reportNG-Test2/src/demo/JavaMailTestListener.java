
package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class JavaMailTestListener extends TestListenerAdapter {
	public static String method_name = "����ʧ�ܵĲ���������";

	public static final String filePath = "conf/config.properties";

	public static String getValue(String key) throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		prop.load(fis);
		fis.close();
		return prop.getProperty(key);
	}

	public static String readHTML() throws IOException {
		String spath = "./test-output/html/index.html";
		InputStreamReader isReader = null;
		BufferedReader bufReader = null;
		StringBuffer buf = new StringBuffer();
		try {
			File file = new File(spath);
			isReader = new InputStreamReader(new FileInputStream(file), "utf-8");
			bufReader = new BufferedReader(isReader, 1);
			String data;
			while ((data = bufReader.readLine()) != null) {

				buf.append(data);
			}

		} catch (Exception e) {
			// TODO �����쳣
		} finally {
			// TODO �ر���
			isReader.close();
			bufReader.close();
		}
		// System.out.print(buf.toString());
		return buf.toString();
	}

	@Override
	public void onFinish(ITestContext testContext) {

		List<ITestResult> fail_list = this.getFailedTests();
		method_name = method_name + fail_list.size() + "��,�ֱ���";
		for (ITestResult tr : fail_list) {
			String method_name2 = tr.getInstanceName() + "_" + tr.getName();
			method_name = method_name + "," + method_name2;
		}

        
		try {
			String readHTML = JavaMailTestListener.readHTML();
			readHTML = readHTML.replace("/$","�������@126.com;");    
	        readHTML = readHTML.replace("/*","�������@126.com;");
			String address = JavaMailTestListener.getValue("tomail");
			String subject = "2021-05-19���Ա���";
			System.out.println("�ʼ��������£�" + readHTML);
			MailUtil.sendEmail(address, subject, readHTML);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}