package test.zhuzhenglin.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

//��¼�������ð�̲����������ѳɹ���½��
public class DemoLogin extends BaseTest {

	// ��¼ҳ�桪��ȷ��¼�û���������
	@Test
	public void test01() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��¼�ɹ����˳���¼
	@Test
	public void test02() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-sign-out']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

	// ��¼ҳ�桪��ҳҳ�桪δ��¼ǩ��
	@Test
	public void test03() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='��ҳ']");
		Thread.sleep(2000);
		webtest.click("id=qiandao");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@class='card-header bg-info text-white']"));
	}

	// ��¼ҳ�桪��ҳҳ�桪δ��¼������
	@Test
	public void test04() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='��ҳ']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='������']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@class='card-header bg-info text-white']"));
	}

	// ��¼ҳ�桪��¼�û�����ס����
	@Test
	public void test05() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//input[@type='checkbox']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��¼�ɹ�����ת��ҳҳ��
	@Test
	public void test06() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

	// ��¼ҳ�桪��¼�ɹ�������ҳǩ��
	@Test
	public void test07() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(1000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
		webtest.click("id=qiandao");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��������û�������ȷ����
	@Test
	public void test08() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin4");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}

	// ��¼ҳ�桪������ȷ�û�������������
	@Test
	public void test09() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "87654321");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);

	}

	// ��¼ҳ�桪�ڵ�¼ǰƵ��������֤��
	@Test
	public void test10() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(3000);
		for (int i = 0; i < 5; i++) {
			webtest.click("id=resetcaptcha");
		}
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��תע��ҳ��
	@Test
	public void test11() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
	}

	// ��¼ҳ�桪��תע��ҳ�桪ע�����û�
	@Test
	public void test12() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='pwd']", "12345678");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='repeat']", "12345678");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "2026116788@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}

	// ��¼ҳ�桪��תע��ҳ�桪ע���Ѵ����û�
	@Test
	public void test13() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='pwd']", "87654321");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='repeat']", "87654321");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "2026116799@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");

	}

	// ��¼ҳ�桪��תע��ҳ�桪ע��ʱ������λ��С��8λ
	@Test
	public void test14() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='pwd']", "123456");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='repeat']", "123456");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "2026116744@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}

	// ��¼ҳ�桪��תע��ҳ�桪ע��ʱ���û��������Ƿ��ַ�*
	@Test
	public void test15() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01**");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='pwd']", "123456789");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='repeat']", "123456789");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "123456789@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}

	// ��¼ҳ�桪��תע��ҳ�桪ע��ʱ�������ʽ����
	@Test
	public void test16() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu02");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='pwd']", "123456789");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='repeat']", "123456789");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "123456789");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}

	// ��¼ҳ�桪��תע��ҳ�桪ע��ʱ�����������벻һ��
	@Test
	public void test17() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='ע��']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu03");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='pwd']", "12345678");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='repeat']", "87654321");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "1112345678@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}

	// ��¼ҳ�桪�һ�����ҳ�桪��������֤�룬�����һ��������
	@Test
	public void test18() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='�һ�����']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "2026116788@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
		Thread.sleep(2000);
	}

	// ��¼ҳ�桪�һ�����ҳ�桪�������䲻���ڱ�վ�Ǽǵ�����
	@Test
	public void test19() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='�һ�����']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "963451229@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
		Thread.sleep(2000);
	}

	// ��¼ҳ�桪��̨���桪��ת��ҳ
	@Test
	public void test20() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(3000);
	}

	// ��¼ҳ�桪��½�ɹ�����ת������ҳ��
	@Test
	public void test21() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[text()='������']");
		Thread.sleep(2000);
	}

	// ��¼ҳ�桪����¼�ɹ�����ҳĬ����������
	@Test
	public void test22() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[text()='����']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='text-info text-decoration-none']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

	// ��¼ҳ�桪����¼�ɹ�����ҳ�������ݡ�������̳��
	@Test
	public void test23() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(1000);
		webtest.typeAndClear("name=find", "������̳");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='����']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='text-info text-decoration-none']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

	// ��¼ҳ�桪����¼�ɹ�����ҳ�������ա����·���������
	@Test
	public void test24() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-home']");
		Thread.sleep(1000);
		webtest.click("xpath=//a[@class='btn btn-light btn-sm text-black-50 py-0']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���·���']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

//	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ�������  
	@Test
	public void test25() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-trash-o fa-lg']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ���������˵�����չ�����˵�
	@Test
	public void test26() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-chevron-circle-left fa-lg']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='fa fa-lg fa-chevron-circle-right']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ�����������20��
	@Test
	public void test27() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='fa fa-trash-o fa-lg']");
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			webtest.click("xpath=//*[@class='btn btn-info submit']");
		}
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ��ת�޸�����ҳ��
	@Test
	public void test28() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='fa fa-exchange']");
		Thread.sleep(2000);
	}

	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ��ת�޸�����ҳ���޸�����
	@Test
	public void test29() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='fa fa-exchange']");
		Thread.sleep(2000);

	}

	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ��ת�û�����ҳ��
	@Test
	public void test30() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='fa fa-user-circle-o']");
		Thread.sleep(2000);

	}

	// ��¼ҳ�桪��¼�ɹ�����̨��ҳ�������ͼ��5���Զ�ˢ��ҳ��
	@Test
	public void test31() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(1000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(1000);
		for (int i = 0; i < 5; i++) {
			webtest.click("xpath=//a[@class='navbar-brand m-auto']");
		}
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

}
