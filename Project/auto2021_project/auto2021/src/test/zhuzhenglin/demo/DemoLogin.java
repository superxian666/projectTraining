package test.zhuzhenglin.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

//登录界面设计冒烟测试用例（已成功登陆）
public class DemoLogin extends BaseTest {

	// 登录页面—正确登录用户名、密码
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

	// 登录页面—登录成功后退出登录
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

	// 登录页面—首页页面—未登录签到
	@Test
	public void test03() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='首页']");
		Thread.sleep(2000);
		webtest.click("id=qiandao");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@class='card-header bg-info text-white']"));
	}

	// 登录页面—首页页面—未登录发新帖
	@Test
	public void test04() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='首页']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='发新帖']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("xpath=//div[@class='card-header bg-info text-white']"));
	}

	// 登录页面—登录用户并记住密码
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

	// 登录页面—登录成功后跳转首页页面
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

	// 登录页面—登录成功后在首页签到
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

	// 登录页面—输入错误用户名、正确密码
	@Test
	public void test08() throws InterruptedException {
		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin4");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);
	}

	// 登录页面—输入正确用户名、错误密码
	@Test
	public void test09() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "87654321");
		Thread.sleep(3000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(3000);

	}

	// 登录页面—在登录前频繁更换验证码
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

	// 登录页面—跳转注册页面
	@Test
	public void test11() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
		Thread.sleep(2000);
	}

	// 登录页面—跳转注册页面—注册新用户
	@Test
	public void test12() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
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

	// 登录页面—跳转注册页面—注册已存在用户
	@Test
	public void test13() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
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

	// 登录页面—跳转注册页面—注册时，密码位数小于8位
	@Test
	public void test14() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
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

	// 登录页面—跳转注册页面—注册时，用户名包含非法字符*
	@Test
	public void test15() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
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

	// 登录页面—跳转注册页面—注册时，邮箱格式错误
	@Test
	public void test16() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
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

	// 登录页面—跳转注册页面—注册时两次输入密码不一致
	@Test
	public void test17() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='注册']");
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

	// 登录页面—找回密码页面—不输入验证码，进行找回密码操作
	@Test
	public void test18() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='找回密码']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "2026116788@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
		Thread.sleep(2000);
	}

	// 登录页面—找回密码页面—输入邮箱不是在本站登记的邮箱
	@Test
	public void test19() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.click("xpath=//*[text()='找回密码']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='user']", "yonghu01");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='email']", "963451229@qq.com");
		Thread.sleep(2000);
		webtest.click("id=submit");
		Thread.sleep(2000);
	}

	// 登录页面—后台界面—跳转首页
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

	// 登录页面—登陆成功—跳转发新帖页面
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
		webtest.click("xpath=//*[text()='发新帖']");
		Thread.sleep(2000);
	}

	// 登录页面——登录成功—首页默认搜索内容
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
		webtest.click("xpath=//*[text()='搜索']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='text-info text-decoration-none']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

	// 登录页面——登录成功—首页搜索内容“剑鱼论坛”
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
		webtest.typeAndClear("name=find", "剑鱼论坛");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='搜索']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='text-info text-decoration-none']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

	// 登录页面——登录成功—首页更换按照“最新发布”排序
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
		webtest.click("xpath=//*[text()='最新发布']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));
	}

//	// 登录页面—登录成功—后台首页清除缓存  
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

	// 登录页面—登录成功—后台首页先隐藏左侧菜单，再展开左侧菜单
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

	// 登录页面—登录成功—后台首页连续清除缓存20次
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

	// 登录页面—登录成功—后台首页跳转修改密码页面
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

	// 登录页面—登录成功—后台首页跳转修改密码页面修改密码
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

	// 登录页面—登录成功—后台首页跳转用户中心页面
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

	// 登录页面—登录成功—后台首页连续点击图标5次自动刷新页面
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
