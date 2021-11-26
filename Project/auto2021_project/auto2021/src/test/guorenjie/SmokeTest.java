package com.webtest.demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SmokeTest {
	String baseUrl = "http://localhost/jianyuluntan_2.4.6/index.php/denglu.html";
	WebDriver driver;

	@BeforeClass
	public void initDriver() throws InterruptedException, IOException {
		System.setProperty("webdriver.gecko.driver", "D:\\software intalling\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\software intalling\\firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get(this.baseUrl);
		Thread.sleep(3000);
		driver.findElement(By.name("user")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("12345678");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[5]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[7]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[10]/nav/a[1]")).click();

	}

	@Test
	public void test000_forumNameIsEmptySubmitFail() throws InterruptedException {
		driver.findElement(By.name("title")).clear();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
	}

	@Test
	public void test001_forumNameIsSpaceSubmitFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("title")).clear();
		driver.findElement(By.name("title")).sendKeys(Keys.SPACE);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();
	}

	@Test
	public void test002_forumNameIsStringMergeSubmitSuccess() throws InterruptedException {
		WebElement element = driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("title")).clear();
		driver.findElement(By.name("title")).sendKeys("jianyuluntan123");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test003_forumNameIsJSSubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("title")).clear();
		driver.findElement(By.name("title")).sendKeys("<script>alert('论坛')</script>");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test004_forumViceNameIsEmptySubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("subtitle")).clear();
		driver.findElement(By.name("title")).sendKeys("jianyuluntan123");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test005_forumViceNameIsEmptySubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("subtitle")).clear();
		driver.findElement(By.name("subtitle")).sendKeys(Keys.SPACE);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test006_forumUrlIsRequirementSubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("domain")).clear(); //
		driver.findElement(By.name("domain")).sendKeys("http://localhost/jianyuluntan_2.4.6/");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test007_forumKeyWordsIsRequirementSubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("keyword")).clear(); //
		driver.findElement(By.name("keyword")).sendKeys("新闻,娱乐,军事"); //
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test008_forumKeyWordsIsEmptySubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("keyword")).clear();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test009_forumDescribeIsEmptySubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("description")).clear();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test010_forumDescribeIsEmptySubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("description")).clear();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test011_forumDescribeIsStringSubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("description")).clear(); //
		driver.findElement(By.name("description")).sendKeys("一个剑鱼论坛"); //
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test012_forumFilterUsernameIsStandardSubmitSuccess() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("filtername")).clear(); //
		driver.findElement(By.name("filtername")).sendKeys("习近平，温家宝"); //
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}

	@Test
	public void test013_forumFilterUsernameIsNoStandardSubmitFail() throws InterruptedException {
		WebElement element =

				driver.findElement(By.name("title"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); //
		driver.findElement(By.name("filtername")).clear(); //
		driver.findElement(By.name("filtername")).sendKeys("习近平|温家宝"); //
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)"); //
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}
//
	@Test
	public void test014_newUsernameBeforeSomePostInputNegativeSubmitFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[5]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[7]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[10]/nav/a[2]")).click();
		WebElement element = driver.findElement(By.name("yanzhengzt"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("yanzhengzt")).clear();
		driver.findElement(By.name("yanzhengzt")).sendKeys("-1");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}
	@Test
	public void test015_newUsernameBeforeSomePostInputZeroSubmitSuccess() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.name("yanzhengzt"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("yanzhengzt")).clear();
		driver.findElement(By.name("yanzhengzt")).sendKeys("0");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}
	@Test
	public void test016_newUsernameBeforeSomeCommentInputZeroSubmitSuccess() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.name("yanzhengzt"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("yanzhenggt")).clear();
		driver.findElement(By.name("yanzhenggt")).sendKeys("0");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}
	@Test
	public void test017_newUsernameBeforeSomeCommentInputNegativeSubmitFail() throws InterruptedException {
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.name("yanzhengzt"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("yanzhenggt")).clear();
		driver.findElement(By.name("yanzhenggt")).sendKeys("-1");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(1000);
		driver.findElement(By.id("formsubmit")).click();
	}
	@Test
	public void test018_gradeSetIncreseOneGradeNormal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[5]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[7]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[10]/nav/a[3]")).click();
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[11]/td[1]/div/input")).sendKeys("ggg");
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[11]/td[2]/div/input")).sendKeys("5000");
		
	}
	@Test
	public void test019_gradeSetReduceOneGradeNormal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/a[2]")).click();

	}
	@Test
	public void test020_gradeSetIncreseOneGradeDescriptionExistentialFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/a[2]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[11]/td[1]/div/input")).sendKeys("博士后");
		driver.findElement(By.linkText("减少一级")).click();
	}
	@Test
	public void test021_gradeSetIncreseOneGradeGrowthValueLessLowGradeFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/a[1]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[11]/td[1]/div/input")).sendKeys("后");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[11]/td[2]/div/input")).sendKeys("500");
		driver.findElement(By.linkText("减少一级")).click();
	}
	@Test
	public void test022_gradeSetGradeDescriptionModifyNormal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[10]/td[1]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[10]/td[1]/div/input")).sendKeys("校长");
	}
	@Test
	public void test023_gradeSetGrowthValueModifyNormal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[10]/td[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[10]/td[2]/div/input")).sendKeys("3000");
		
	}
	@Test
	public void test024_gradeSetGrowthValueModifyUpHighGradeFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[9]/td[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[9]/td[2]/div/input")).sendKeys("5000");
		
	}
	@Test
	public void test025_gradeSetGrowthValueModifyBelowLowGradeFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[9]/td[2]/div/input")).clear();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[9]/td[2]/div/input")).sendKeys("20");
		
	}
	@Test
	public void test026_growthValueSetNumberNormal() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[5]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[7]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[10]/nav/a[4]")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[2]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[2]/div/input")).sendKeys("5000");		
	}
	@Test
	public void test027_growthValueSetNegativeFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[2]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[2]/div/input")).sendKeys("-5000");		
	}
	@Test
	public void test028_growthValueSetSpaceFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[2]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[2]/div/input")).sendKeys(" ");		
	}
	@Test
	public void test029_growthValueSetNumberNormal() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).sendKeys("2");		
	}
	@Test
	public void test030_growthValueSetChineseFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).sendKeys("换行");		
	}
	@Test
	public void test031_growthValueSetEnglishFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).sendKeys("aa");		
	}
	@Test
	public void test032_growthValueSetNegativeFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).sendKeys("-1");		
	}
	@Test
	public void test033_growthValueSetSymbolFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).sendKeys("@");		
	}
	@Test
	public void test034_growthValueSetSpaceFail() throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).clear();		

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[3]/div/input")).sendKeys(" ");	
		
	}
	@Test
	public void test035_signInGetIntegralSetNegativeFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[5]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[7]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[10]/nav/a[5]")).click();
		driver.findElement(By.name("checkin")).clear();
		driver.findElement(By.name("checkin")).sendKeys("-1");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/button")).click();		

	}
	@Test
	public void test036_signInGetIntegralSetChineseFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkin"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkin")).clear();
		driver.findElement(By.name("checkin")).sendKeys("你好");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test037_signInGetIntegralSetEnglishFail() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[1]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[3]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[5]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[7]/i")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div[10]/nav/a[5]")).click();
		WebElement element = driver.findElement(By.name("checkin"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkin")).clear();
		driver.findElement(By.name("checkin")).sendKeys("ssss");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/form/div[11]/button")).click();		

	}
	@Test
	public void test038_signInGetIntegralSetSymbolFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkin"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkin")).clear();
		driver.findElement(By.name("checkin")).sendKeys("!");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test039_signInGetIntegralSetSpaceFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkin"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkin")).clear();
		driver.findElement(By.name("checkin")).sendKeys(" ");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();

	}
	@Test
	public void test040_continueSignInGetIntegralSetSpaceFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkincontinu"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkincontinu")).clear();
		driver.findElement(By.name("checkincontinu")).sendKeys(" ");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test042_continueSignInGetIntegralSetNegativeFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkincontinu"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkincontinu")).clear();

		driver.findElement(By.name("checkincontinu")).sendKeys("-100");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test043_continueSignInGetIntegralSetChineseFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkincontinu"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkincontinu")).clear();

		driver.findElement(By.name("checkincontinu")).sendKeys("你好");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test044_continueSignInGetIntegralSetSymbolFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkincontinu"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkincontinu")).clear();

		driver.findElement(By.name("checkincontinu")).sendKeys("!");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test045_continue3DaysSignInGetIntegralSetNumberSuccess() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkinthreedays"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkinthreedays")).clear();		
		driver.findElement(By.name("checkinthreedays")).sendKeys("1");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test046_continue3DaysSignInGetIntegralSetChineseFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkinthreedays"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkinthreedays")).clear();		

		driver.findElement(By.name("checkinthreedays")).sendKeys("你好");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test047_continue3DaysSignInGetIntegralSetEnglishFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkinthreedays"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkinthreedays")).clear();		

		driver.findElement(By.name("checkinthreedays")).sendKeys("sss");
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test048_continue3DaysSignInGetIntegralSetSymbolFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkinthreedays"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkinthreedays")).clear();		
		driver.findElement(By.name("checkinthreedays")).sendKeys("!");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();		

	}
	@Test
	public void test049_continue3DaysSignInGetIntegralSetSpaceFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkinthreedays"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkinthreedays")).clear();		
		driver.findElement(By.name("checkinthreedays")).sendKeys(" ");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();

	}
	@Test
	public void test050_continue3DaysSignInGetIntegralSetSpaceFail() throws InterruptedException {
		WebElement element = driver.findElement(By.name("checkinthreedays"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		driver.findElement(By.name("checkinthreedays")).clear();		
		driver.findElement(By.name("checkinthreedays")).sendKeys(" ");	
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");

		driver.findElement(By.id("formsubmit")).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath("/html/body/div[13]/div[2]/div/div/div/div/div/div/div/div[4]/button")).click();

	}
	@AfterClass
	public void quiteDriver() throws InterruptedException {
		Thread.sleep(10000);
		if (driver != null) {
			driver.quit();
		}
	}
}
