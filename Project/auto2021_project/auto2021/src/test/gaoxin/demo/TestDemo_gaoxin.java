package test.gaoxin.demo;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TestDemo_gaoxin extends BaseTest{
//	��¼ ����ת����ҳ
	
	
	@Test
	public void test01_login() throws InterruptedException {
		webtest.open("/");
		webtest.click("link=��¼");
		
		webtest.click("name=user");
		webtest.type("name=user", "admin");
		
		webtest.click("name=pwd");
		webtest.type("name=pwd", "12345678");
		
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		
		webtest.click("link=��ҳ");
		
	
		
	}
	
	
//	��ҳǩ��
	//@Test
	public void test02_sigin_daily() {
		
		if(webtest.isElementPresent("id=qiandaomiaoshu")) {
			webtest.click("id=qiandaomiaoshu");
		}
		Assert.assertEquals("��ǩ��", webtest.getText("id=qiandaomiaoshu"));
		
	}
	@Test
	public void test03_search() {
		webtest.click("name=find");
		
		webtest.type("name=find", "das");
		webtest.click("xpath=//button[@type='submit']");
	}
//	��ת�û�����
	@Test
	public void test04_toUserPage() throws InterruptedException {
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�û�����");
		
		Thread.sleep(5000);
	}
	
	@Test
	public void test05_sigin_in() {
		webtest.click("link=ǩ��");
		
		webtest.click("id=shanggeyue");
	}
	
	@Test
	public void test06_date_click() {
		webtest.click("link=ǩ��");
		
		for(int i = 0;i<20;i++) {
			webtest.click("id=shanggeyue");
		}
	}
	
	
	@Test
	public void test07_find_sore() throws InterruptedException {
		webtest.open("/index.php/user/index/index.html");
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("link=�ҵĻ���");
		
	}
	
	@Test void test08_find_getScore() {
		
		webtest.click("link=��ȡ����");
		
		webtest.click("link=�鿴��ӵ�ж��ٻ���");
		
		webtest.click("link=��ȡ����");
	}
	
	@Test 
	public void test09_find_getScore_sigin() {
		
		webtest.click("link=��ȡ����");
		
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		
		webtest.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='�鿴��ӵ�ж��ٻ���'])[1]/following::a[1]");
		
		
	}
	
	@Test
	public void test10_scoreRecord() {
		webtest.open("/index.php/user/index/index.html");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�����˵�");
	}
	
	@Test 
	public void test11_back_loginscore_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		
		System.out.println(num);
		Assert.assertEquals("5", num);
		
	}
//	/* xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input
//	 * xpath=//tbody[@id='chengzhangtr']/tr/td[2] 
//	 * 
//	 * xpath=//tbody[@id='chengzhangtr']/tr[2]/td[3]/div/input
//	 * xpath=//tbody[@id='chengzhangtr']/tr[2]/td[2]
//	
	@Test 
	public void test12_back_sendmain_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[2]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[2]/td[2]");
		
		System.out.println(num);
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test13_back_loginscore_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[2]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[2]/td[2]");
		
		System.out.println(num);
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test14_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[3]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[3]/td[2]");
		
	
		Assert.assertEquals("5", num);
		
	}
	
	@Test 
	public void test15_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[4]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[4]/td[2]");
		
	
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test16_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[5]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[5]/td[2]");
		
	
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test17_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[6]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[6]/td[2]");
		
		
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test18_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[7]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[7]/td[2]");
		
	
		Assert.assertEquals("5", num);
		
	}
	
	@Test 
	public void test19_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[8]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[8]/td[2]");
		
		
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test20_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[9]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[9]/td[2]");
		
		
		Assert.assertEquals("5", num);
	}
	
	@Test 
	public void test21_back_score_change_font_pagecheck () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr[10]/td[3]/div/input", "5");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr[10]/td[2]");
		
		
		Assert.assertEquals("5", num);
	}
	
	
	@Test 
	public void test22_back_score_change_font_pagecheck_null () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", null);
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		
	
		Assert.assertEquals("0", num);
	}
	
	@Test 
	public void test23_back_score_change_font_pagecheck_str () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "str");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		
	
		Assert.assertEquals("0", num);
	}
	
	@Test 
	public void test24__back_score_change_font_pagecheck_zero () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "0");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("0", num);
	}
	
	@Test 
	public void test25__back_score_change_font_pagecheck_zeros () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input","000");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("0", num);
	}
	
	@Test 
	public void test26__back_score_change_font_pagecheck_Max () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", Integer.MAX_VALUE+"");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals(Integer.MAX_VALUE+"", num);
	}
	
	@Test 
	public void test27__back_score_change_font_pagecheck_float () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "1.0");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("1", num);
	}
	
	@Test 
	public void test28__back_score_change_font_pagecheck_float_max () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "1.999999999");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("1", num);
	}
	
	@Test 
	public void test29__back_score_change_font_pagecheck_long () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "1000000007");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("1000000007", num);
	}
	
	@Test 
	public void test30__back_score_change_font_pagecheck_lessZero () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "-1");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("-1", num);
	}
	
	@Test 
	public void test31__back_score_change_font_pagecheck_lesszeore_long () {
		webtest.open("/index.php/admin/index/index.html");
		webtest.click("id=navbarDropdowny");
		
		webtest.click("link=�����̨");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=�ɳ�����");
		
//		�޸Ļ���ֵ		
		webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr/td[3]/div/input", "-100000007");
		
		webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
		
		webtest.open("/index.php/user/index/earnpoints.html");
//		��ȡ����ֵ
		String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr/td[2]");
		

		Assert.assertEquals("-100000007", num);
	}
	
	
//	�������ݼ�
	String[] datas = {"0","-1","1000000007","1.0",null,"str",Integer.MAX_VALUE+"","1.99999"};
	String[] result = {"0","-1","1000000007","1",null,"0",Integer.MAX_VALUE+"","1"};

	
//	index�Ǵ� 2-10
	
	public void proviceData_table_test_index(int index) {
		
		
		for(int i=0;i<datas.length;i++) {
			webtest.open("/index.php/admin/index/index.html");
			webtest.click("id=navbarDropdowny");
			
			webtest.click("link=�����̨");
			
			webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
			
			webtest.click("link=�ɳ�����");
			
//			�޸Ļ���ֵ		
			webtest.typeAndClear("xpath=//tbody[@id='chengzhangtr']/tr["+index+"]/td[3]/div/input",datas[i]);
			
			webtest.click("xpath=//tbody[@id='chengzhangtr']/tr/td");
			
			webtest.open("/index.php/user/index/earnpoints.html");
//			��ȡ����ֵ
			String num = webtest.getText("xpath=//tbody[@id='chengzhangtr']/tr["+index+"]/td[2]");
			
	
			Assert.assertEquals(datas[i], result[i]);
		}

	}
	
	
	/*�������Ϸ���ʵ�ִ���ĸ߶ȸ���*/
	
	

	@Test 
	public void test32_back_score_change_font_pagecheck () {
		proviceData_table_test_index(2);
	}
	@Test 
	public void test33_back_score_change_font_pagecheck () {
		proviceData_table_test_index(3);
	}
	@Test 
	public void test34_back_score_change_font_pagecheck () {
		proviceData_table_test_index(4);
	}
	@Test 
	public void test35_back_score_change_font_pagecheck () {
		proviceData_table_test_index(5);
	}
	@Test 
	public void test36_back_score_change_font_pagecheck () {
		proviceData_table_test_index(6);
	}
	@Test 
	public void test37_back_score_change_font_pagecheck () {
		proviceData_table_test_index(7);
	}
	@Test 
	public void test38_back_score_change_font_pagecheck () {
		proviceData_table_test_index(8);
	}
	@Test 
	public void test39_back_score_change_font_pagecheck () {
		proviceData_table_test_index(9);
	}
	
	@Test 
	public void test40_back_score_change_font_pagecheck () {
		proviceData_table_test_index(10);
	}
	

	
	//���ݼ�
	/*
	 * 

��������ǩ���ɻ�ö������: 0

��������ǩ���ɻ�ö������: 0

��������ǩ���ɻ�ö������: 0

����һ��ǩ���ɻ�ö������: 0
	 * */
	String[] check_str= {"ǩ���ɻ�û���: 5","����ǩ���ɻ�ö������: 5","����3��ǩ���ɻ�ö������: 5"
			,"����һ��ǩ���ɻ�ö������: 5","��������ǩ���ɻ�ö������: 5","����һ��ǩ���ɻ�ö������: 5"
			,"��������ǩ���ɻ�ö������: 5","��������ǩ���ɻ�ö������: 5","��������ǩ���ɻ�ö������: 5","����һ��ǩ���ɻ�ö������: 5"};
	
	String[] path = {"name=checkin","name=checkincontinu","name=checkinthreedays","name=checkinweek",
			"name=checkintwoweek","name=checkinmonth","name=checkintwomonth",
			"name=checkinthreemonth","name=checkinhalfyear","name=checkinyear"};

	
	@Test 
	public void test41_back_ckeck_change_score_fontpageCheck () {
		
		int index= 0;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		
		webtest.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ������'])[2]/following::label[1]");
		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );
		
		
	}
	
	@Test 
	public void test42_back_ckeck_change_score_fontpageCheck () {
		int index= 1;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		
		webtest.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ������'])[2]/following::label[1]");
		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );
	}
	
	@Test 
	public void test43_back_ckeck_change_score_fontpageCheck () {
		int index= 2;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		
		webtest.click("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ������'])[2]/following::label[1]");
		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	@Test 
	public void test44_back_ckeck_change_score_fontpageCheck () {
		int index= 3;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		

		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	@Test 
	public void test45_back_ckeck_change_score_fontpageCheck () {
		int index= 4;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		

		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	@Test 
	public void test46_back_ckeck_change_score_fontpageCheck () {
		int index= 5;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		

		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	@Test 
	public void test47_back_ckeck_change_score_fontpageCheck () {
		int index= 6;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		

		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	@Test 
	public void test48_back_ckeck_change_score_fontpageCheck () {
		int index= 7;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		

		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	@Test 
	public void test49_back_ckeck_change_score_fontpageCheck () {
		int index= 8;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		
		webtest.typeAndClear(path[index], "5");
		
		
		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}
	
	@Test 
	public void test50_back_ckeck_change_score_fontpageCheck () {
		int index= 9;
		
		webtest.open("/index.php/admin/index/checkinsettings.html");
		webtest.runJs("window.scrollTo(0,document.body.scrollHeight)");
		webtest.typeAndClear(path[index], "5");
		
		
		webtest.click("id=formsubmit");
		webtest.open("/index.php/user/index/checkin.html");
		index++;
		String num= webtest.getText("xpath=(.//*[normalize-space(text()) and normalize-space(.)='ǩ�����ֽ���'])[1]/following::p["+index+"]");
		
		
		Assert.assertEquals(num,check_str[index-1] );		
	}


}
