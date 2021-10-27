package com.webtest.core;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

public class WebDriverEngine {

	WebDriver driver = null;
	ElementFinder finder = null;
	Actions action  =null;

	public WebDriverEngine(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().window().maximize();
		finder = new ElementFinder(driver);
		action = new Actions(driver);
	}
	public String[] getAllWindowTitles() {
		// TODO Auto-generated method stub
	    String current = driver.getWindowHandle();

	    List<String> attributes = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	      driver.switchTo().window(handle);
	      attributes.add(driver.getTitle());
	    }

	    driver.switchTo().window(current);

	    return attributes.toArray(new String[attributes.size()]);
	}



	public void enterFrame(String frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	public void enterFrame(int frameID) {
		this.pause(3000);
		driver.switchTo().frame(frameID);
		Log.info("Entered iframe " + frameID);
	}
	
	public void enterFrame1(String locator) {
		WebElement element = finder.findElement(locator);
		this.pause(3000);
		driver.switchTo().frame(element);
		Log.info("Entered iframe " + element);
	}


	public void leaveFrame() {
		driver.switchTo().defaultContent();
		Log.info("Left the iframe");
	}
//	打开网页链接
	public void open(String url) {

		try {
			driver.get(ReadProperties.getPropertyValue("baseurl")+url);
			pause(5000);
		} catch (Exception e) {
			e.printStackTrace();

		}
		Log.info("Opened url " + url);
	}
//	获得标题
	public String getTitle() {
		return driver.getTitle();
	}
//	方法阻塞
	private void pause(int time) {
		if (time <= 0) {
			return;
		}
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	是否有xx文字存在
	public boolean isTextPresent(String pattern) {

		String text = driver.getPageSource();
		text = text.trim();
		if (text.contains(pattern)) {
			return true;
		}
		return false;
	}
//	模拟键盘回车事件
	public void enter() {
		action.sendKeys(Keys.ENTER);
	}
//	清空并键入
	public void typeAndClear(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.clear();
			element.sendKeys(value);

		}
	}
//	键入
	public void type(String locator, String value) {
		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.sendKeys(value);
		}
	}
//	是否选中
	public boolean isChecked(String locator) {
		WebElement element = finder.findElement(locator);
		return element.isSelected();
	}
//	点击
	public void click(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			element.click();
			this.pause(3000);
		}
	}
//	长按
	public void clickLonger(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			runJs("window.scrollTo(0," + element.getLocation().x + ")");
			element.click();
			this.pause(3000);
		}
	}
//	双击
	public void doubleClick(String locator) throws InterruptedException {
		WebElement element = finder.findElement(locator);
	
		action.doubleClick(element).build().perform();
	}
//	是否展开
	public boolean isDisplayed(String locator) {

		WebElement element = finder.findElement(locator);
		if (element != null) {
			return element.isDisplayed();
		}
		return false;
	}
//	获得文本
	public String getText(String locator) {

		return finder.findElement(locator).getText().trim();
	}
//	元素是否存在
	public boolean isElementPresent(String locator) {

		WebElement element = null;
		try {
			element = finder.findElement(locator);
		} catch (Exception e) {

			Log.info(e.getMessage());
		}
		if (element != null) {
			return true;
		}
		{
			return false;
		}
	}
//	获取值
	public String getValue(String locator) {

		return finder.findElement(locator).getAttribute("value");
	}
//	获得url
	public String getUrl() {
		return driver.getCurrentUrl();
	}
//	返回
	public void goBack() {
		driver.navigate().back();
	}
//	前进
	public void goForward() {

		driver.navigate().forward();
	}
//	抓取提示框
	public Alert getAlert() {
		Alert alert = driver.switchTo().alert();
		return alert;
	}
//	获得提示框内容
	public String getAlertTest() {

		return getAlert().getText();
	}
//	提示框输入
	public void alertAccept() {

		getAlert().accept();
	}
//	获得选中项集合
	public Select getSelect(String locator) {
		Select inputSelect = new Select(finder.findElement(locator));
		return inputSelect;
	}
//	根据value值选中对应选项
	public void selectByValue(String locator, String value) {
		getSelect(locator).selectByValue(value);
		this.pause(5000);
	}
//	根据text值选中对应选项
	public void selectByVisibleText(String locator, String value) {
		getSelect(locator).selectByVisibleText(value);
	}
//	根据index值选中对应选项
	public void selectByIndex(String locator, int index) {
		getSelect(locator).selectByIndex(index);
	}
//	获取网页源代码
	public String getHtmlSource() {

		return driver.getPageSource();
	}
//	执行js代码
	public void runJs(String js) {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript(js);
	}
//	鼠标移动到某元素
	public void mouseToElement(String locator) throws InterruptedException {
		action.moveToElement(finder.findElement(locator)).perform();
	}
//	鼠标移动到某元素并点击
	public void mouseToElementandClick(String locator) throws InterruptedException {
		action.moveToElement(finder.findElement(locator)).click().perform();
	}
//	页面跳转
	public void switchWidow(int i){
	    List<String> windows = new ArrayList<String>();
	    for (String handle : driver.getWindowHandles()) {
	    
	    	windows.add(handle);
	    }
	    driver.switchTo().window(windows.get(i));
	}
//	右击
	public void rightClickMouse(String locator) throws InterruptedException {
		action.contextClick(finder.findElement(locator)).perform();
		}
//	Tab键
	public void tapClick(){
	
		action.sendKeys(Keys.TAB).perform();;
	}
//	按下某个键
	public void tapType(String content){
		
			action.sendKeys(content).perform();
		}
//	获得页面
	public void getWindow(int i){
		List<String> windows = new ArrayList<String>();
		for (String handle : driver.getWindowHandles())
		{
			windows.add(handle);
		}
		driver.switchTo().window(windows.get(i));
	}

	
}
