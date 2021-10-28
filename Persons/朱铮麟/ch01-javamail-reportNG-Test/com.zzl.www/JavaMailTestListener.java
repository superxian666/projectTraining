//����6 2021��5��19�� ������
//����� 2019�� ������� 2019012499 
package demo;

import java.io.FileInputStream;
import java.io.IOException;
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

	@Override
	public void onFinish(ITestContext testContext) {

		List<ITestResult> fail_list = this.getFailedTests();
		method_name = method_name + fail_list.size() + "��,�ֱ���";
		for (ITestResult tr : fail_list) {
			String method_name2 = tr.getInstanceName() + "_" + tr.getName();
			method_name = method_name + "," + method_name2;
		}
		try {
			String address = JavaMailTestListener.getValue("tomail");
			String subject = "2021-05-19���Ա���";
			System.out.println("�ʼ��������£�" + method_name);
//			MailUtil.sendEmail(address, subject, method_name);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}