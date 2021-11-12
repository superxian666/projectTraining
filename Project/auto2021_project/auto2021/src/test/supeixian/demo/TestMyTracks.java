package test.supeixian.demo;

import javax.lang.model.element.Element;

import org.openqa.selenium.interactions.ClickAction;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.schemas.office.visio.x2012.main.impl.VisioDocumentDocument1Impl;
import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;
import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

public class TestMyTracks extends BaseTest{
	
//	登录的方法，方便后面复用，减少代码重复量
	public void login(String username,String password) {
		
		webtest.open("");
//		webtest.open("localhost/jianyuluntan_2.4.6/");
		
		webtest.click("link=登录");
		webtest.click("name=user");
		webtest.type("name=user",username);
		
		webtest.click("name=pwd");
		webtest.type("name=pwd", password);

		webtest.click("id=submit");

		
	}
	
	@BeforeMethod
	public void doBeforeMehod() throws Exception {

		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	}

	
//	登录进入我的足迹，能否正确进入我的收藏页面
	@Test(priority=0)
	public void test01_collection() {

		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=我的收藏");
		
		String url = webtest.getUrl();
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/mycollection.html",url);
		System.out.println("test01成功");
		
		driver.quit();

	}
	
	
//	测试能否正确跳转到收藏记录中的帖子详情页
	@Test
	public void test02_collection_details() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=我的收藏");
		
		webtest.click("link=富商大贾");
		
		System.out.println("test02成功");
		
		driver.quit();


		
	}
	
//	测试删除收藏记录
	@Test
	public void test03_collection_delete_success() {
		
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=我的收藏");
		webtest.click("class=confirm text-info");
		webtest.click("class=btn btn-info");
		
		System.out.println("test03成功");
		driver.quit();


	}
	
//	测试删除收藏记录时点击取消，收藏记录是否删除
	@Test
	public void test04_collection_delete_fail() {
		
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=我的收藏");
		webtest.click("class=confirm text-info");
		webtest.click("class=btn btn-default");
		driver.quit();

	}
	
	
//	测试对一篇帖子多次点击收藏，收藏记录会不会重复显示
	@Test
	public void test05_collection_many() {
		
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=我的收藏");
		
		webtest.click("link=富商大贾");
		
		for(int i=0;i<5;i++) {
			webtest.click("id=postshoucang");
			webtest.click("link=确认");
		}
		webtest.click("id=navbarDropdowny");
		webtest.click("link=用户中心");
		webtest.click("link=我的收藏");
		driver.quit();

	}
	

//	测试对收藏记录中的记录长按会不会触发其他操作
	@Test
	public void test06_collection_clicklong() {
		
		login("superxian","123456789spx");
		webtest.click("link=我的收藏");
		webtest.clickLonger("link=华润大厦");
		driver.quit();

	}
	
//	测试连续收藏多篇帖子，所有收藏记录能够正确显示
	@Test
	public void test07_collection_more() {
		
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=首页");
		
//		点击第一篇帖子
		webtest.click("link=测试测试");
		webtest.click("id=postshoucang");
		webtest.click("class=text-info text-decoration-none mx-2");
//		点击第二篇帖子
		webtest.click("link=测试测试2");
		webtest.click("id=postshoucang");
		webtest.click("class=text-info text-decoration-none mx-2");
//		点击第三篇帖子
		webtest.click("link=测试测试3");
		webtest.click("id=postshoucang");
		webtest.click("class=text-info text-decoration-none mx-2");
//		点击第四篇帖子
		webtest.click("link=测试测试4");
		webtest.click("id=postshoucang");
		webtest.click("class=text-info text-decoration-none mx-2");
//		点击第五篇帖子
		webtest.click("link=测试测试5");
		webtest.click("id=postshoucang");
		webtest.click("class=text-info text-decoration-none mx-2");
//		查看我的收藏记录
		webtest.click("id=navbarDropdowny");
		webtest.click("link=用户中心");
		webtest.click("link=我的收藏");
		
		Assert.assertEquals(true,webtest.isElementPresent("link=测试测试"));
		System.out.println("第一条帖子收藏成功");
		Assert.assertEquals(true,webtest.isElementPresent("link=测试测试2"));
		System.out.println("第二条帖子收藏成功");
		Assert.assertEquals(true,webtest.isElementPresent("link=测试测试3"));
		System.out.println("第三条帖子收藏成功");
		Assert.assertEquals(true,webtest.isElementPresent("link=测试测试4"));
		System.out.println("第四条帖子收藏成功");
		Assert.assertEquals(true,webtest.isElementPresent("link=测试测试5"));
		System.out.println("第五条帖子收藏成功");
		driver.quit();

	}
	
	
//	测试进入我的足迹能否进入访问过的帖子页面
	@Test
	public void test08_visited_posts() {
		
		login("superxian","123456789spx");
		webtest.click("link=访问过的帖子");	
		String url = webtest.getUrl();	
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/postsvisited.html",url);
		System.out.println("test08成功");
		
		driver.quit();

	}
	
	
//	测试能否在访问过的帖子页面进入主贴
	@Test
	public void test09_visited_posts_enter_main() {
		
		login("superxian","123456789spx");
		webtest.click("link=访问过的帖子");
		
		webtest.click("link=富商大贾");
		
//		String title=webtest.getTitle();
//		Assert.assertEquals("富商大贾",title);
		driver.quit();

	}
	
	
	//测试页面左侧栏目的折叠功能
	@Test
	public void test10_fold() {
		
		login("superxian","123456789spx");
		webtest.click("class=fa float-right fa-minus-square-o");
		driver.quit();

	}
	
	
	//测试进入赞过的帖子页面
	@Test
	public void test11_fabulous() {
		login("superxian","123456789spx");
		
		webtest.click("link=赞过的帖子");
		
		String url = webtest.getUrl();
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/likedposts.html", url);
		driver.quit();

	}
	
//	测试多次点击赞过的帖子，页面是否正确显示
	@Test
	public void test12_zan_moretime() {
		login("superxian","123456789spx");
		
		for(int i=0;i<10;i++) {
			webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
			webtest.click("link=赞过的帖子");
			
			String url = webtest.getUrl();
			Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/likedposts.html", url);
		}
		driver.quit();

	}
	
	
//	测试删除赞过的帖子记录
	@Test
	public void test13_dele_fabulous_record() throws InterruptedException {
		login("superxian","123456789spx");
		
		 
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("link=赞过的帖子");
//		webtest.click("class=fa fa-trash-o");
		
		
		
		webtest.click("xpath=//table[@class=table table-hover]/thead/tbody/tr[1]/td[3]/a/i[@class=fa fa-trash-o]");
		
//		webtest.click("xpath=//tbody/tr/td[3]/a/i[@class=fa fa-trash-o]");
		
		
		Thread.sleep(10000);
//		webtest.click("class=btn btn-info");
		
//		webtest.isElementPresent("link=富商大贾");
//		Assert.assertEquals(false,webtest.isElementPresent("link=富商大贾"));
		driver.quit();

	}
	
//	测试对帖子点赞后点赞记录中是否出现赞过的帖子记录
	@Test
	public void test14_fabulous_success() {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=首页");	
		
		webtest.click("link=富商大贾");
		webtest.click("class=fa fa-thumbs-o-up");
		webtest.click("id=navbarDropdowny");
		webtest.click("link=用户中心");
		webtest.click("link=赞过的帖子");
		
		Assert.assertEquals(true,webtest.isElementPresent("link=富商大贾"));
		driver.quit();

		
	}
	
//	测试进入踩过的帖子页面
	@Test
	public void test15_into_dislike_post() {
		
		login("superxian","123456789spx");
		webtest.click("link=踩过的帖子");
		String url=webtest.getUrl();
		
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/dislikedpost.html",url);
		driver.quit();
 
	}
	
	
	
//	测试删除踩过的帖子记录
	@Test
	public void test16_dele_dislike_post() {
		
		login("superxian","123456789spx");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");

		webtest.click("link=踩过的帖子");

//		webtest.click("xpath=//tbody/tr[0]/td[3]/a[@class=fa fa-trash-o]/i");
		webtest.click("class=fa fa-trash-o");
		webtest.click("class=btn btn-info");
		
//		Assert.assertEquals(false,webtest.isElementPresent("link=测试测试"));
		driver.quit();

		
	}
	
//	测试踩过帖子后踩过的记录是否正确显示在踩过的帖子记录中
	@Test
	public void test17_dislike_success() throws InterruptedException {
		
		login("superxian","123456789spx");
		
		webtest.click("link=首页");
		Thread.sleep(3000);
		webtest.click("link=积分支付测试");
		Thread.sleep(3000);
		webtest.click("id=postcai");
		webtest.click("class=nav-link dropdown-toggle");
		webtest.click("link=用户中心");
		webtest.click("link=踩过的帖子");
		
//		Boolean result = webtest.isElementPresent("link=积分支付测试");
//		Assert.assertEquals(true, webtest.isElementPresent("link=积分支付测试"));
		driver.quit();

		
	}
	
//	测试能否正确进入赞过的跟帖页面
	@Test
	public void test18_into_comment() {
		
		login("superxian","123456789spx");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("link=赞过的跟帖");
		
		String url=webtest.getUrl();
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/likedfollow.html",url);
		driver.quit();

	}
	
//	测试通过赞过的跟帖记录进入帖子主页
	@Test
	public void test19_from_comment_into_post() {
		
		login("superxian", "123456789spx");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("link=赞过的跟帖");
		
		webtest.click("link=测试的帖子123");
		driver.quit();

	}
	
//	测试删除赞过的跟帖记录
	@Test
	public void test20_dele_like_follow_post() {
		
		login("superxian", "123456789spx");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("link=赞过的跟帖");
		
		webtest.click("class=fa fa-trash-o");
		webtest.click("class=btn btn-info");
		
		Assert.assertEquals(false, webtest.isElementPresent("link=测试删除"));
		driver.quit();

	}
	
//	测试对一条跟帖点赞，点赞记录中能否正确出现赞过的记录
	@Test
	public void test21_like_follow_post_success() {
		
		login("superxian", "123456789spx");
		
		webtest.click("link=首页");
		webtest.click("link=测试的帖子");
		webtest.click("link=btn btn-info btn-sm mr-1 denglu jianyu_gentiezan");
		webtest.click("id=navbarDropdowny");
		webtest.click("link=用户中心");
		webtest.click("link=赞过的跟帖");
		
//		Assert.assertEquals(true,webtest.isElementPresent("link=测试点赞跟帖"));
		driver.quit();

		
	}
	
//	测试能否进入踩过的跟帖页面
	@Test
	public void test22_into_disliked_follow() {
		
		login("superxian", "123456789spx");
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=踩过的跟帖");
		String url = webtest.getUrl();
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/dislikedfollow.html",url);
		driver.quit();
	}
	
//	测试能否通过踩过的跟帖进入帖子详情页面
	@Test
	public void test23_into_details() {
		
		login("superxian", "123456789spx");
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("link=踩过的跟帖");
		
		webtest.click("link=查看主贴");
		String url = webtest.getUrl();
//		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/post/1.html",url);
		driver.quit();
		
	}

//	测试能否删除踩过的跟帖记录
//	删除内容为测试删除跟帖的跟帖
	@Test
	public void test24_dele_disliked_follows() {
		
		login("superxian", "123456789spx");
		webtest.click("踩过的跟帖");
		
		webtest.click("class=fa fa-trash-o");
		webtest.click("class=btn btn-info");
		
		Assert.assertEquals(false,webtest.isElementPresent("link=测试删除跟帖"));
		driver.quit();

	}
	
//	测试删除踩过的跟帖时点击取消是否会继续删除
//	测试删除内容为测试跟帖删除失败的跟帖
	@Test
	public void test25_dele_disliked_follows_fail() {
		
		login("superxian", "123456789spx");
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("踩过的跟帖");
		
		webtest.click("class=fa fa-trash-o");
		webtest.click("link=取消");
		
//		Assert.assertEquals(true, webtest.isElementPresent("link=测试删除跟帖失败"));
		driver.quit();
	}
	
	
//	测试踩一条跟帖，踩过的跟帖记录中能否出现对应的记录
//	主贴标题为踩跟帖测试，跟帖标题为跟帖
	@Test
	public void test26_dislike_follows() {
		
		login("superxian", "123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=首页");
		webtest.click("link=踩跟帖测试");
		webtest.click("跟帖");
		webtest.click("class=btn btn-secondary btn-sm denglu jianyu_gentiecai");
		webtest.click("class=nav-link dropdown-toggle");
		webtest.click("link=用户中心");
		webtest.click("link=踩过的跟帖");
		
//		Assert.assertEquals(true,webtest.isElementPresent("link=跟帖"));
		driver.quit();
	}
	
	
//	测试能否正确进入积分支付过的帖子记录页面
	@Test
	public void test27_into_payment_history_page() {
		
		login("superxian", "123456789spx");
		webtest.click("link=积分支付过的帖子");
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/pointspaidposts.html", webtest.getUrl());
		driver.quit();
	}
	
//	测试能否通过积分支付过的帖子记录页面访问帖子详情
//	测试的帖子名字为 测试积分支付过的帖子
	@Test
	public void test28_into_payment_page() {
		
		login("superxian", "123456789spx");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		
		webtest.click("link=积分支付过的帖子");
		
		webtest.click("link=测试积分支付过的帖子");
		String url = webtest.getUrl();
//		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/post/22.html", url);
		driver.quit();
	}
	
//	测试返回页面的上一页
	@Test
	public void test29_return_page() {
		
		login("superxian", "123456789spx");
		
		webtest.click("link=积分支付过的帖子");
		webtest.goBack();
		String url = webtest.getUrl();
		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/user/index/index.html",url);
		driver.quit();
	}
	
	
	
//	测试进入用户中心，我的足迹页面滚动条滚动,页面正确显示
	@Test
	public void test30_scroll_banner() {
		login("superxian","123456789spx");
		
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10");
		driver.quit();
	}
	
	
//	测试对自己写的跟帖进行踩，踩的记录否正确显示
	@Test
	public void test31_cai_genteibyself() {
		login("superxian","123456789spx");
		
		webtest.click("class=nav-link text-light dropdown-toggle");
		webtest.click("link=首页");
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div[2]/div/h6/a");

//		webtest.click("class=HandyEditor_editor");
//		webtest.type("class=HandyEditor_editor", "测试跟帖");
		webtest.type("xpath=/html/body/div[1]/div/div[1]/div/div[3]/div[2]/div[1]/div[3]", "测试跟帖");
		webtest.click("xpath=//*[@id=\"gentie\"]");
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div/ul/li[6]/div[3]/button[2]");
		
		webtest.click("xpath=//*[@id=\"navbarDropdowny\"]");
		webtest.click("link=用户中心");
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		webtest.click("踩过的跟帖");
		

	}
	
//	测试访问过的帖子，删除主贴后，是否还能通过访问记录页访问主贴
	
	@Test
	public void test32_after_delete_into_mainpage() {
		login("superxian","123456789spx");
		
		webtest.click("link=访问过的帖子");
		
		webtest.click("link=测试能否进入访问删除过的帖子页面");
		String url=webtest.getUrl();
//		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/post/20.html", url);
		
	}
	
	
//	测试进入访问过的帖子，翻页功能
	@Test
	public void test33_change_page() {
		login("superxian","123456789spx");
		
		webtest.click("link=访问过的帖子");
		
		for(int i=0;i<10;i++) {
			webtest.tapType("Keys.DOWN");
		}
//		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/nav/ul/li[3]/a");
	}
	
	
//	测试访问帖子后，访问记录是否出现在访问过的帖子页面
	@Test
	public void test34_visit_history() throws InterruptedException {
		login("superxian","123456789spx");
		
		webtest.click("link=superxian");
		webtest.click("link=首页");
		Thread.sleep(3000);
		webtest.click("link=测试访问记录");
		Thread.sleep(3000);
		webtest.click("id=postcai");
		webtest.click("class=nav-link dropdown-toggle");
		webtest.click("link=用户中心");
		webtest.click("link=访问过的帖子");
		
//		Boolean result = webtest.isElementPresent("link=测试访问记录");
//		Assert.assertEquals(true, webtest.isElementPresent("link=测试访问记录"));
//		driver.quit();
	}
	
	
//	测试进入积分支付过的帖子
	@Test
	public void test35_payment_page() {
		login("superxian","123456789spx");
		
		webtest.click("xpath=/html/body/div[1]/div/div[1]/div/div/div[8]/nav/a[3]");
		webtest.click("link=测试积分支付过的帖子");
		
		String url = webtest.getUrl();
//		Assert.assertEquals("http://localhost/jianyuluntan_2.4.6/index.php/post/20.html", url);
	}


}
