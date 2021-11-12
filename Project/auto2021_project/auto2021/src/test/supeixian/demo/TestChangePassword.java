package test.supeixian.demo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;


public class TestChangePassword extends BaseTest{
	
//	登录的方法，方便后面复用，减少代码重复量
	public void login(String username,String password) {
		webtest.open("");
//		webtest.open("localhost/jianyuluntan_2.4.6/");
		
		webtest.click("link=登录");
		webtest.click("name=user");
		webtest.type("name=user",username);
		
		webtest.click("name=pwd");
		webtest.type("name=pwd", password);

		webtest.click("id=submit");

	}
	
	@BeforeMethod
	public void doBeforeMehod() throws Exception {

		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	}
	
	
//	测试修改密码时输入错误的原密码
//	输入符合条件的新密码
	
	@Test(priority=0)
	public void test01_change_password_oldpwd_fail() {
		
		login("superxian", "123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("class=form-control");
		webtest.type("class=form-control","123456");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789132");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789132");
		webtest.click("id=formsubmit");

		Assert.assertEquals(false,webtest.isElementPresent("link=原密码错误"));
		driver.quit();
	}
	
//	测试修改密码时，原密码输入正确，新密码输入1234
	
	@Test
	public void test02_change_password_newpwd_fail() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "1234");
		webtest.tapClick();
		webtest.type("name=rpwd", "1234");
		webtest.click("id=formsubmit");
		
		Assert.assertEquals(false, webtest.isElementPresent("link=新密码长度不能小于8个字符"));
		driver.quit();
	}
	
//	测试修改密码时，原密码输入正确，新密码输入1234567890，确认新密码输入1234567890

	@Test
	public void test03_change_password_success() {
		
//		已运行成功为不影响后续运行，故进行注释
		
//		login("superxian","123456789spx");
//		
//		webtest.click("link=superxian");
//		webtest.click("link=修改密码");
//		webtest.click("name=opwd");
//		webtest.type("name=opwd", "123456789spx");
//		webtest.tapClick();
//		webtest.type("name=npwd", "123456789");
//		webtest.tapClick();
//		webtest.type("name=rpwd", "123456789");
//		webtest.click("id=formsubmit");
//		
////		Assert.assertEquals("修改成功", webtest.getAlertTest());
//		driver.quit();
	}
	
//	测试修改密码时，原密码输入正确，新密码输入1234567890，确认新密码输入12345678
	@Test
	public void test04_change_password_different() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "1234567890");
		webtest.tapClick();
		webtest.type("name=rpwd", "12345678");
		webtest.click("id=formsubmit");
		
//		Assert.assertEquals("重复新密码和新密码不一致", webtest.getAlertTest());
		driver.quit();
	}
	
//	测试修改密码时，原密码输入正确，新密码输入！@#￥%asd123，确认新密码输入！@#￥%asd123
	@Test
	public void test05_change_password_specialpwd() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "！@#￥%asd123");
		webtest.tapClick();
		webtest.type("name=rpwd", "！@#￥%asd123");
		webtest.click("id=formsubmit");
		driver.quit();
	}
	
//	测试修改密码时，原密码输入正确，新密码输入123456789123456789123456789123456789123456789，确认新密码输入123456789123456789123456789123456789123456789
	@Test
	public void test06_change_password_tolong_pwd() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789123456789123456789123456789123456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789123456789123456789123456789123456789");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
	
//	测试修改密码输入正确的旧密码，输入新密码为空，再次输入新密码为空
	@Test
	public void test07_change_password_new_pwdnull() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "");
		webtest.tapClick();
		webtest.type("name=rpwd", "");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
//	测试修改密码输入正确的旧密码，输入符合条件的新密码，再次输入新密码为空
	@Test
	public void test08_change_password_rpwdnull() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
//	测试修改密码，输入旧密码为空，输入符合条件的新密码，确认新密码与新密码一直
//  新密码为最少字符+1，内点
	@Test
	public void test09_change_password_pwdnull_npwdrpwd_true() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
	
//	测试修改密码，输入正确的旧密码，输入新密码有空格，再次输入符合条件的新密码
	@Test
	public void test10_change_password_npwdwithbnull() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "123  456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "123  456789");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
//	测试修改密码时，输入正确的旧密码，新密码与确认新密码与旧密码一致
	@Test
	public void test11_change_password_all_same() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789spx");
		webtest.click("id=formsubmit");	
		driver.quit();
		
	}
	
//	测试修改密码时，输入正确的原密码，新密码输入12345abcde，确认新密码输入12345ABCDE
	@Test
	public void test12_change_password_case() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "12345abcde");
		webtest.tapClick();
		webtest.type("name=rpwd", "12345ABCDE");
		webtest.click("id=formsubmit");	
		driver.quit();
		
	}
	
	
//	测试修改密码时，输入正确的旧密码，新密码为空，确认新密码为123456789
	@Test
	public void test13_change_password_npwdnull() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
//	测试修改密码时，输入正确的旧密码，新密码为最少字符-1即为七位（输入1234567），确认新密码输入1234567
//  内点
	@Test
	public void test14_change_password() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "1234567");
		webtest.tapClick();
		webtest.type("name=rpwd", "1234567");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
//	测试修改密码修改成功后能否用新密码登录成功
	@Test
	public void test15_change_password_success_loginWithNewPwd() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789");
		webtest.click("id=formsubmit");	
		driver.quit();
		
		login("superxian","123456789");
	}
	
//	测试修改密码修改成功后能否用旧密码登录成功
	@Test
	public void test16_change_password_success_loginWithOldPwd() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "123456789spx");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789");
		webtest.click("id=formsubmit");	
		driver.quit();
		
		login("superxian","123456789spx");
	}
	
//	测试修改密码时，原密码输入1' and 1=1 #，输入符合要求的新密码和确认新密码
	@Test
	public void test17_change_password_sql() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=修改密码");
		webtest.click("name=opwd");
		webtest.type("name=opwd", "1' and 1=1 #");
		webtest.tapClick();
		webtest.type("name=npwd", "123456789");
		webtest.tapClick();
		webtest.type("name=rpwd", "123456789");
		webtest.click("id=formsubmit");	
		driver.quit();
	}
	
}
