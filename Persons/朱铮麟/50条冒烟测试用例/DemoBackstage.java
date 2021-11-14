package test.zhuzhenglin.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

//��̨���桪�������ð�̲����������ѳɹ���½��
public class DemoBackstage extends BaseTest {

	// ��¼ҳ��
	@Test
	public void testLogin() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(2000);
	}

//______________________________________________________________________________

	// ��̨�������������������(�򿪷�ʽĬ�ϡ���Ϊ�´��ڴ򿪡�)
	@Test
	public void test32() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='�����������']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "�ٶȵ�ͼ");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨�������������������(�򿪷�ʽ�޸�Ϊ����ԭ���ڴ򿪡�)
	@Test
	public void test33() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='�����������']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "�ٶȵ�ͼ");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@name='target']");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='_self']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨������������������ӡ����Ӹ�ʽ����ȷ
	@Test
	public void test34() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='�����������']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "�ٶȵ�ͼ");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "����һ�����������");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@name='target']");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='_self']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨���������������ͼƬ��������ǰ����ͼƬ������ͼƬ·��ճ����
	@Test
	public void test35() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='�����������']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "�ٶȵ�ͼ");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.runJs("document.getElementById(\"tubiao\").type ='0'     ");
		Thread.sleep(2000);
		webtest.typeAndClear("id=tubiao", "data/uploads/20211110/2aac7cf553e8bd34b6285ba1f9fd3fde.png");
		Thread.sleep(2000);
		webtest.click("xpath=//label[@for='homelink']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨�����������������ҳ��ʾ����������
	@Test
	public void test36() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='�����������']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "�ٶȵ�ͼ");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.click("xpath=//label[@for='homelink']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨�������������������ӡ�����
	@Test
	public void test37() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='������������']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info btn-sm submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨�������������������ӡ��޸������������ֺ���������
	@Test
	public void test38() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='������������']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@class='form-control form-control-sm'][1]", "20");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info btn-sm submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�������������������ӡ��޸ĵ�һ����������
	@Test
	public void test39() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='������������']");
		Thread.sleep(2000);
		webtest.click("xpath=//table//tbody//tr[1]//td[6]//a//i[@class='fa fa-edit'][1]");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "�������");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�������������������ӡ�ɾ����һ������
	@Test
	public void test40() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='������������']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='fa fa-trash-o']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�������������������ӡ�����һ��������ҳ��ʾ
	@Test
	public void test41() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='������������']");
		Thread.sleep(2000);
		webtest.click("xpath=//table//tbody//tr[1]//td[6]//a//i[@class='fa fa-edit'][1]");
		Thread.sleep(2000);
		webtest.click("xpath=//label[@for='homelink']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨�����������ݿⱸ�ݡ������±���
	@Test
	public void test42() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-outline-info btn-sm mb-2 submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ�ɾ������
	@Test
	public void test43() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-trash-o']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ�ȡ��ɾ������
	@Test
	public void test44() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-trash-o']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-default']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ���ԭ���ݿ�
	@Test
	public void test45() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-reply-all']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ����ݿⱸ�����ص�����
	@Test
	public void test46() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-download']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ��ϴ����ݿ���ȷ��ʽ�����ļ�����ԭ
	@Test
	public void test47() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='�ϴ����ر����ļ�����ԭ']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=file", "D:\\demo\\jianyuoldfile.jyb");
		Thread.sleep(2000);
		webtest.click("id=submitupreform");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// ��̨�����������ݿⱸ�ݡ���������20���±���
	@Test
	public void test48() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			webtest.click("xpath=//button[@class='btn btn-outline-info btn-sm mb-2 submit']");
		}
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ��ϴ����ݿ�����ʽ�����ļ�����ԭ
	@Test
	public void test49() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='�ϴ����ر����ļ�����ԭ']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=file", "D:\\demo\\jianyufile.zip");
		Thread.sleep(2000);
		webtest.click("id=submitupreform");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������ݿⱸ�ݡ��ϴ����ļ�����ԭ
	@Test
	public void test50() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='���ݿⱸ��']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='�ϴ����ر����ļ�����ԭ']");
		Thread.sleep(2000);
		webtest.click("id=submitupreform");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨��������ϵͳ��������ת����ҳ��
	@Test
	public void test51() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='ϵͳ����']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@href='http://jianyuluntan.com/post/152.html']");
		Thread.sleep(2000);

	}

	// ��̨��������ϵͳ�������ϴ�������������ϵͳ
	@Test
	public void test52() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='ϵͳ����']");
		Thread.sleep(2000);
		webtest.click("id=uploadfile");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨�����������۵������˵�����չ�������˵�
	@Test
	public void test53() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//div[11]//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[11]//i[@class='fa float-right fa-plus-square-o']");
		Thread.sleep(2000);
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨���������������
	@Test
	public void test54() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='�������']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// ��̨���������˳�
	@Test
	public void test55() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='�˳�']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));

	}

}
