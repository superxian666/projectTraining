package com.webtest.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class WebTestListener1 extends TestListenerAdapter {
	
	
	@Override
	public void onFinish(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onFinish(testContext);
//		打印出所有的测试用例数目
		ITestNGMethod[] methods=this.getAllTestMethods();
		String items="一共执行了："+methods.length+"条测试用例";
		System.out.println(items);
		
//		成功的测试用例名称和数目
		List<ITestResult> successList=this.getPassedTests();
		List successList1=new ArrayList();
		int len_success=successList.size();
		System.out.println("成功的测试用例："+len_success);
		for(int i=0;i<len_success;i++) {
			ITestResult tr=successList.get(i);
			String success_item=tr.getInstanceName()+":"+tr.getName();
			System.out.println(success_item+"成功了");
			successList1.add(tr);
		}
		
//		失败的测试用例名称和数目
		List<ITestResult> failList=this.getFailedTests();
		List failList1=new ArrayList();
		int len_fail=failList.size();
		System.out.println("失败的测试用例："+len_fail);
		for(int i=0;i<len_fail;i++) {
			ITestResult tr=failList.get(i);
			String fail_item=tr.getInstanceName()+":"+tr.getName();
			System.out.println(fail_item+"失败了");
			failList1.add(tr);
		}

		
			
		Map context=new HashMap();
		context.put("failList",failList);
		context.put("successList",successList);
		System.out.println(context);

		
		
	}
	


}
