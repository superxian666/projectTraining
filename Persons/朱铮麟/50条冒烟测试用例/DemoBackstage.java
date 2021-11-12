package test.zhuzhenglin.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.dataprovider.NSDataProvider;

//后台界面—其他设计冒烟测试用例（已成功登陆）
public class DemoBackstage extends BaseTest {

	// 登录页面
	@Test
	public void testLogin() throws InterruptedException {

		webtest.open("/jianyuluntan_2.4.6/index.php/denglu.html");
		webtest.typeAndClear("name=user", "admin1");
		webtest.typeAndClear("name=pwd", "12345678");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@id='submit']");
		Thread.sleep(2000);
	}

//______________________________________________________________________________

	// 后台—其他—添加友情链接(打开方式默认“作为新窗口打开”)
	@Test
	public void test32() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='添加友情链接']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "百度地图");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—添加友情链接(打开方式修改为“在原窗口打开”)
	@Test
	public void test33() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='添加友情链接']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "百度地图");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@name='target']");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='_self']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—添加友情链接—链接格式不正确
	@Test
	public void test34() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='添加友情链接']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "百度地图");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "这是一条错误的链接");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@name='target']");
		Thread.sleep(2000);
		webtest.click("xpath=//option[@value='_self']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—添加链接图片（做测试前下载图片，并将图片路径粘贴）
	@Test
	public void test35() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='添加友情链接']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "百度地图");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.runJs("document.getElementById(\"tubiao\").type ='0'     ");
		Thread.sleep(2000);
		webtest.typeAndClear("id=tubiao", "data/uploads/20211110/2aac7cf553e8bd34b6285ba1f9fd3fde.png");
		Thread.sleep(2000);
		webtest.click("xpath=//label[@for='homelink']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—添加能在首页显示的友情链接
	@Test
	public void test36() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='添加友情链接']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "百度地图");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='dizhi']", "https://www.baidu.com/");
		Thread.sleep(2000);
		webtest.click("xpath=//label[@for='homelink']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—所有友情链接—排序
	@Test
	public void test37() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='所有友情链接']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info btn-sm submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—所有友情链接—修改链接排序数字后重新排序
	@Test
	public void test38() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='所有友情链接']");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@class='form-control form-control-sm'][1]", "20");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info btn-sm submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—所有友情链接—修改第一条链接名称
	@Test
	public void test39() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='所有友情链接']");
		Thread.sleep(2000);
		webtest.click("xpath=//table//tbody//tr[1]//td[6]//a//i[@class='fa fa-edit'][1]");
		Thread.sleep(2000);
		webtest.typeAndClear("xpath=//input[@name='mingcheng']", "新年快乐");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—所有友情链接—删除第一条链接
	@Test
	public void test40() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='所有友情链接']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='fa fa-trash-o']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—所有友情链接—将第一条链接首页显示
	@Test
	public void test41() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.doubleClick("xpath=//*[text()='所有友情链接']");
		Thread.sleep(2000);
		webtest.click("xpath=//table//tbody//tr[1]//td[6]//a//i[@class='fa fa-edit'][1]");
		Thread.sleep(2000);
		webtest.click("xpath=//label[@for='homelink']");
		Thread.sleep(2000);
		webtest.click("id=formsubmit");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—数据库备份—创建新备份
	@Test
	public void test42() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-outline-info btn-sm mb-2 submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—删除备份
	@Test
	public void test43() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-trash-o']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—取消删除备份
	@Test
	public void test44() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-trash-o']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-default']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—还原数据库
	@Test
	public void test45() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-reply-all']");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—数据库备份下载到本地
	@Test
	public void test46() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-download']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—上传数据库正确格式备份文件并还原
	@Test
	public void test47() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='上传本地备份文件并还原']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=file", "D:\\demo\\jianyuoldfile.jyb");
		Thread.sleep(2000);
		webtest.click("id=submitupreform");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));

	}

	// 后台—其他—数据库备份—连续创建20次新备份
	@Test
	public void test48() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		for (int i = 0; i < 20; i++) {
			webtest.click("xpath=//button[@class='btn btn-outline-info btn-sm mb-2 submit']");
		}
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—上传数据库错误格式备份文件并还原
	@Test
	public void test49() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='上传本地备份文件并还原']");
		Thread.sleep(2000);
		webtest.typeAndClear("id=file", "D:\\demo\\jianyufile.zip");
		Thread.sleep(2000);
		webtest.click("id=submitupreform");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—数据库备份—上传空文件并还原
	@Test
	public void test50() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='数据库备份']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='上传本地备份文件并还原']");
		Thread.sleep(2000);
		webtest.click("id=submitupreform");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—系统升级—跳转链接页面
	@Test
	public void test51() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='系统升级']");
		Thread.sleep(2000);
		webtest.click("xpath=//a[@href='http://jianyuluntan.com/post/152.html']");
		Thread.sleep(2000);

	}

	// 后台—其他—系统升级—上传升级包并升级系统
	@Test
	public void test52() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='系统升级']");
		Thread.sleep(2000);
		webtest.click("id=uploadfile");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—先折叠二级菜单，再展开二级菜单
	@Test
	public void test53() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//div[11]//i[@class='fa fa-minus-square-o float-right']");
		Thread.sleep(2000);
		webtest.click("xpath=//div[11]//i[@class='fa float-right fa-plus-square-o']");
		Thread.sleep(2000);
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—清除缓存
	@Test
	public void test54() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='清除缓存']");
		Thread.sleep(2000);
		webtest.click("xpath=//*[@class='btn btn-info submit']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=jianyuluntansidebar"));
	}

	// 后台—其他—退出
	@Test
	public void test55() throws InterruptedException {
		testLogin();
		webtest.runJs("document.getElementById(\"jianyuluntansidebar\").scrollTop=10000");
		Thread.sleep(2000);
		webtest.click("xpath=//*[text()='退出']");
		Thread.sleep(2000);
		Assert.assertTrue(webtest.isElementPresent("id=qiandao"));

	}

}
