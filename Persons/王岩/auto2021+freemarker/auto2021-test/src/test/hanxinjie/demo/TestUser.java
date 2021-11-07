package test.hanxinjie.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener1;
import com.webtest.dataprovider.ExcelDataProvider;



public class TestUser  extends BaseTest {
	ExcelDataProvider user=new ExcelDataProvider();
	@BeforeClass
	public void testLogin() throws InterruptedException {
		
		webtest.open("localhost");
		Thread.sleep(2000);
		webtest.click("partLink=登录");
		webtest.type("name=user", "admin110");
		webtest.type("name=pwd", "00000000");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}
	
//	*******************************所有用户界面*********************************
//	搜索不存在的用户
	@Test
	public void test01() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		String users=user.getTestDataByExcel("C:/Users/user/Desktop/user.xlsx", "sheet1",0,0);
		webtest.type("name=yonghuming", users);
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
	}
	
//	搜索存在用户
	@Test
	public void test02() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		String users=user.getTestDataByExcel("C:/Users/user/Desktop/user.xlsx", "sheet1",1,0);
		webtest.type("name=yonghuming", users);
		Thread.sleep(2000);
		webtest.click("xpath=//button[@type='submit']");
		Thread.sleep(2000);
		webtest.click("partLink=所有用户");
	}
	
//	审核???只能打开第一个
	@Test
	public void test03() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='custom-control custom-switch']");
	}

//	版主组，设置普通用户
	@Test
	public void test04() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","普通用户");
	}
	
//	版主组，设置实习版主
	@Test
	public void test05() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","实习版主");
	}
	
//	版主组，设置副版主
	@Test
	public void test06() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","副版主");
	}
	
//	版主组，设置版主
	@Test
	public void test07() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","版主");
	}

//	用户组，设置普通用户
	@Test
	public void test08() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control yonghuzu']","普通用户");
	}
	
//	用户组，设置普通管理员
	@Test
	public void test09() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control yonghuzu']","普通管理员");
	}
	
//	用户组，设置高级管理员
	@Test
	public void test10() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control yonghuzu']","高级管理员");
	}
	
//	所有用户界面跳转到版主界面
	@Test
	public void test11() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.click("partLink=版主");
	}
	
//	所有用户界面跳转到管理员界面
	@Test
	public void test12() throws InterruptedException, IOException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.click("partLink=版主");
	}
	
//	*******************************版主界面*********************************
//	选择普通用户
	@Test
	public void test13() throws InterruptedException, IOException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","普通用户");
	}	
	
//	选择实习版主
	@Test
	public void test14() throws InterruptedException, IOException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","实习版主");
	}
	
//	选择副版主
	@Test
	public void test15() throws InterruptedException, IOException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","副版主");
	}
	
//	选择版主
	@Test
	public void test16() throws InterruptedException, IOException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control banzhuzu']","版主");
	}
	
//	所有版主界面跳转到用户界面
	@Test
	public void test17() throws InterruptedException, IOException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.click("partLink=所有用户");
	}
	
//	所有版主界面跳转到管理员界面
	@Test
	public void test18() throws InterruptedException, IOException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
	}
	
//	*******************************管理员界面*********************************
//	审核???只能打开第一个
	@Test
	public void test19() throws InterruptedException, IOException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='custom-control custom-switch']");
	}
	
//	用户组-普通用户
	@Test
	public void test20() throws InterruptedException, IOException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control yonghuzu']","普通用户");
	}
	
//	用户组-普通管理员
	@Test
	public void test21() throws InterruptedException, IOException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control yonghuzu']","普通管理员");
	}
	
//	用户组-高级管理员
	@Test
	public void test22() throws InterruptedException, IOException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.selectByVisibleText("xpath=//select[@class='form-control yonghuzu']","高级管理员");
	}
	
//	所有版主界面跳转到用户界面
	@Test
	public void test23() throws InterruptedException, IOException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.click("partLink=所有用户");
	}
	
//	所有版主界面跳转到管理员界面
	@Test
	public void test24() throws InterruptedException, IOException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.click("partLink=版主");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
