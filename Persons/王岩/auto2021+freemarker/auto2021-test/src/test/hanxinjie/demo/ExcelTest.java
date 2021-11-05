package test.hanxinjie.demo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.WebTestListener;
import com.webtest.dataprovider.ExcelDataProvider;

import freemarker.FreemarkerTest;
@Listeners(WebTestListener.class)
public class ExcelTest extends ExcelDataProvider {
    
	@Test
	public void num() throws IOException {
		System.out.println(getTestDataByExcel("C:/Users/user/Desktop/user.xlsx", "sheet1",0,0));
		System.out.println(getTestDataByExcel("C:/Users/user/Desktop/user.xlsx", "sheet1",0,1));
	}
	@Test
	public void test1() {
		assertEquals(1, 2);
	}
	@Test
	public void test2() {
		assertEquals(1, 1);
	}
	

    
}
