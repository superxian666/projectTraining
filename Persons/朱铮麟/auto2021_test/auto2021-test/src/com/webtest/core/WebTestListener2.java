package com.webtest.core;

import java.io.IOException;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener2 extends TestListenerAdapter {

	@Override
	public void onTestFailure(ITestResult tr) {


//		失败的测试用例截屏
		BaseTest tb = (BaseTest) tr.getInstance();
		SeleniumScreenShot screenShot = new SeleniumScreenShot(tb.getDriver());
		try {
			screenShot.screenShot();
			System.out.println("onTestFailure:" + tr.getInstanceName() + ":" + tr.getName() + "失败了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
