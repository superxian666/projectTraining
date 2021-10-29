package test.hanxinjie.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class TestScore extends BaseTest {
	@BeforeClass
	public void testLogin1() throws InterruptedException {
		
		webtest.open("localhost");
		Thread.sleep(2000);
		webtest.click("partLink=登录");
		webtest.type("name=user", "admin110");
		webtest.type("name=pwd", "00000000");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}
	
//	*******************************用户积分*********************************
//	搜索不存在的用户
	@Test
	public void test25() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("name=yonghuming", "admin110");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
	}
	
//	搜索存在的用户
	@Test
	public void test26() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("name=yonghuming", "admin120");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
	}
	
//	增加空积分
	@Test
	public void test27() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control rounded-0 border-top-0 border-right-0 border-left-0']","");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-plus']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
//	增加整数积分
	@Test
	public void test28() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@class='form-control rounded-0 border-top-0 border-right-0 border-left-0']","100");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-plus']");
	}
	
//	增加小数积分
	@Test
	public void test29() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@placeholder='输入增加数量']","10.99");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-plus']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
//	减少空积分
	@Test
	public void test30() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@placeholder='输入减少数量']","");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='btn btn-outline-secondary rounded-0 border-0 decreasepoints']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
//	减少整数积分
	@Test
	public void test31() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@placeholder='输入减少数量']","100");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='btn btn-outline-secondary rounded-0 border-0 decreasepoints']");
	}
	
//	减少小数积分
	@Test
	public void test32() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
		Thread.sleep(2000);
		webtest.type("xpath=//input[@placeholder='输入减少数量']","10.99");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='btn btn-outline-secondary rounded-0 border-0 decreasepoints']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
//	用户几分->积分兑换
	@Test
	public void test33() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
	}
	
//	*******************************积分兑换界面*********************************
//	输入空积分
	@Test
	public void test34() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='jifen']","");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
//	输入整数积分
	@Test
	public void test35() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='jifen']","100");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
	}
	
//	输入小数积分
	@Test
	public void test36() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='jifen']","100.99");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
//	积分兑换->用户积分
	@Test
	public void test37() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
	}
	
}
