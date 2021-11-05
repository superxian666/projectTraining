package test.hanxinjie.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.ExcelDataProvider;

public class TestMore extends BaseTest {
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
	
//	*******************************上方导航栏*********************************
//	隐藏菜单
	@Test
	public void test38() {
		webtest.click("xpath=//i[@class='fa fa-chevron-circle-left fa-lg']");
	}
	
//	展开菜单
	@Test
	public void test39() {
		webtest.click("xpath=//i[@class='fa fa-lg fa-chevron-circle-right']");
	}
	
//	清理缓存（上标垃圾桶图案），返回后台
	@Test
	public void test40() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-trash-o fa-lg']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@style='position: relative; z-index: 1200;']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@data-toggle='dropdown']");
		Thread.sleep(2000);
		webtest.click("partLink=用户中心");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=管理后台");
	}
	
//	退出（上标），返回后台
	@Test
	public void test41() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-sign-out fa-lg']");
		Thread.sleep(2000);
		webtest.click("partLink=登录");
		webtest.type("name=user", "admin110");
		webtest.type("name=pwd", "00000000");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}
	
//	首页（右上，下拉菜单），返回后台
	@Test
	public void test42() throws InterruptedException {
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=首页");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@role='button']");
		Thread.sleep(2000);
		webtest.click("partLink=用户中心");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=管理后台");
	}
	
//	用户中心（右上，下拉菜单），返回后台
	@Test
	public void test43() throws InterruptedException {
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=用户中心");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=管理后台");
	}
	
//	修改密码（右上，下拉菜单），返回后台
	@Test
	public void test44() throws InterruptedException {
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=修改密码");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=管理后台");
	}
	
//	退出（右上，下拉菜单），返回后台
	@Test
	public void test45() throws InterruptedException {
		webtest.click("xpath=//a[@class='nav-link text-light dropdown-toggle']");
		Thread.sleep(2000);
		webtest.click("partLink=退出");
		Thread.sleep(2000);
		webtest.click("partLink=登录");
		webtest.type("name=user", "admin110");
		webtest.type("name=pwd", "00000000");
		Thread.sleep(2000);
		webtest.click("id=submit");
	}
	
//	*******************************两个模块间的页面跳转*********************************
//	所有用户->用户积分
	@Test
	public void test46() throws InterruptedException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
	}
	
//	版主->用户积分
	@Test
	public void test47() throws InterruptedException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
	}
	
//	管理员->用户积分
	@Test
	public void test48() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=用户积分");
	}
	
//	所有用户->积分兑换
	@Test
	public void test49() throws InterruptedException {
		webtest.click("partLink=所有用户");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
	}
	
//	版主->积分兑换
	@Test
	public void test50() throws InterruptedException {
		webtest.click("partLink=版主");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
	}
	
//	管理员->积分兑换
	@Test
	public void test51() throws InterruptedException {
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=管理员");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("partLink=积分兑换");
	}
	
}
