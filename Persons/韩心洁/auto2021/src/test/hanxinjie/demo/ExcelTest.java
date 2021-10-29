package test.hanxinjie.demo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webtest.dataprovider.ExcelDataProvider;

public class ExcelTest extends ExcelDataProvider {
	@Test
	public void num() throws IOException {
		System.out.println(getTestDataByExcel("C:/Users/user/Desktop/user.xlsx", "sheet1",0,0));
		System.out.println(getTestDataByExcel("C:/Users/user/Desktop/user.xlsx", "sheet1",0,1));
	}
}
