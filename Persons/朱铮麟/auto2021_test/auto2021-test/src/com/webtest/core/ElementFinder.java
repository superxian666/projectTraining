package com.webtest.core;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webtest.utils.Log;

public class ElementFinder {
	
	WebDriver driver;
	public  ElementFinder(WebDriver driver)
	{
		this.driver=driver;
	}
	

	
	public WebElement findElement(String target) {
		WebElement element = null;

		try {
			element = findElementByPrefix(target);
		} catch (Exception e) {
			Log.info(e.toString());
		}
		return element;

	}
	
//	定位元素方法
	public WebElement findElementByPrefix(String locator)
	{
		String target=locator.trim();
//		id定位
		if(target.startsWith("id="))
		{
			locator = locator.substring("id=".length());
			return driver.findElement(By.id(locator));
		}
//		class定位
		else if(target.startsWith("class="))
		{
			locator = locator.substring("class=".length());
			return driver.findElement(By.className(locator));
		}
//		name定位
		else if(target.startsWith("name="))
		{
			locator = locator.substring("name=".length());
			return driver.findElement(By.name(locator));
		}
//		link定位
		else if(target.startsWith("link="))
		{
			locator = locator.substring("link=".length());
	
			return driver.findElement(By.linkText(locator));
		}
//		partlink定位
		else if(target.startsWith("partLink="))
		{
			locator = locator.substring("partLink=".length());
		
			return driver.findElement(By.partialLinkText(locator));
		}
//		css定位
		else if(target.startsWith("css="))
		{
			locator = locator.substring("css=".length());
			return driver.findElement(By.cssSelector(locator));
		}
//		xpath定位
		else if(target.startsWith("xpath="))
		{
			locator = locator.substring("xpath=".length());
			return driver.findElement(By.xpath(locator));
		}
//		tag标签定位
		else if(target.startsWith("tag="))
		{
			locator = locator.substring("tag=".length());
			return driver.findElement(By.tagName(locator));
		}
//		无法定位到元素
		else
		{
			Log.info(locator+"can't find element by prefix.");
			return null;
		}
	}
	
	
}
