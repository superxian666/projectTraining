package test.hanxinjie.demo;

import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.webtest.core.BaseTest;



public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin1() throws InterruptedException {
		
		webtest.open("localhost");
		Thread.sleep(3000);
		webtest.click("partLink=登录");
		webtest.type("name=user", "admin110");
		webtest.type("name=pwd", "00000000");
		webtest.click("id=submit");
	}
	


}
