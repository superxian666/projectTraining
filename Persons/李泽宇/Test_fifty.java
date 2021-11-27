package test.hanxinjie.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebTestListener1;


public class Test_fifty extends BaseTest {
	
	@BeforeClass
	public void testLogin() throws InterruptedException {
		
		webtest.open("localhost");
		Thread.sleep(3000);
		webtest.click("partLink=登录");
		webtest.type("name=user", "admin");
		webtest.type("name=pwd", "12345678");
		webtest.click("id=submit");
		
	}
	/*******发帖管理-主贴-审核*******/
	@Test
	public void test01() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("partLink=主帖");
		webtest.click("xpath=//div[@class='custom-control custom-switch']");
	}
	
	
	/*******发帖管理-主贴-删除-取消*******/
	@Test
	public void test02() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='confirm text-info']");
		webtest.click("xpath=//button[@class='btn btn-default']");

	}
	
	/*******发帖管理-主贴-删除-继续*******/
	@Test
	public void test03() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='confirm text-info']");
		webtest.click("xpath=//button[@class='btn btn-info']");

	}
	
	/*******发帖管理-主贴-关键字*******/
	@Test
	public void test04() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("partLink=主帖");
		Thread.sleep(2000);
		webtest.type("name=guanjianzi","文件");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	/*******发帖管理-主贴-用户名*******/
	@Test
	public void test05() throws InterruptedException {
		Thread.sleep(2000);
		webtest.type("name=yonghuming","admin");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	/*******发帖管理-跟贴-审核*******/
	@Test
	public void test06() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("partLink=跟帖");
		webtest.click("xpath=//div[@class='custom-control custom-switch']");
	}
	
	/*******发帖管理-跟贴-删除-取消 *******/
	@Test
	public void test07() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='confirm text-info']");
		webtest.click("xpath=//button[@class='btn btn-default']");
	}
	
	/*******发帖管理-跟贴-删除-继续*******/
	@Test
	public void test08() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//a[@class='confirm text-info']");
		webtest.click("xpath=//button[@class='btn btn-info']");
	}
	
	/*******发帖管理-跟贴-关键字 *******/
	@Test
	public void test09() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("partLink=跟帖");
		webtest.type("name=guanjianzi","好");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	/*******发帖管理-跟贴-用户名*******/
	@Test
	public void test10() throws InterruptedException {
		Thread.sleep(2000);
		webtest.type("name=yonghuming","admin");
		webtest.click("xpath=//button[@type='submit']");
	}
	
	/*******发帖管理-首页置顶-审核 *******/
	@Test
	public void test11() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("partLink=首页置顶");
		webtest.click("xpath=//div[@class='custom-control custom-switch']");
	}

	/***********跟贴-主贴-签到 ***********/
	@Test
	public void test12() throws InterruptedException {
		Thread.sleep(3000);
		webtest.open("localhost/index.php/post/4.html");
		webtest.click("xpath=//button[@id='qiandao']");
	}
	
	/***********跟贴-主贴-再次签到 显示今日已签到***********/
	@Test
	public void test13() throws InterruptedException {
		Thread.sleep(2000);
		webtest.open("localhost/index.php/post/4.html");
		Thread.sleep(2000);
		webtest.click("xpath=//button[@id='qiandao']");
		webtest.click("xpath=//div[@class='jconfirm-buttons']");
	}
	
	/***********跟贴-主贴-按跟帖顺序 ***********/
	@Test
	public void test14() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-sort']");
		webtest.click("partLink=按跟帖顺序");
	}

	/***********跟贴-主贴-按最新跟帖 ***********/
	@Test
	public void test15() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-sort']");
		webtest.click("partLink=按最新跟帖");
	}
	
	/***********跟贴-主贴-输入框（加粗） ***********/
	@Test
	public void test16() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_bold']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（斜体） ***********/
	@Test
	public void test17() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_italic']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（删除线） ***********/
	@Test
	public void test18() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_strike']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（下划线） ***********/
	@Test
	public void test19() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_underline']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（字体大小） ***********/
	@Test
	public void test20() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_fontsize']");
		webtest.click("xpath=//div[@id='HandyEditor_newdiv_down_5']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（字体名称） ***********/
	@Test
	public void test21() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_fontname']");
		webtest.click("xpath=//div[@id='HandyEditor_newdiv_down_kaiti']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（字体颜色选择） ***********/
	@Test
	public void test22() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_color']");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_colorblock_base_ff0000']");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_colorok']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
		
	}
	
	/***********跟贴-主贴-输入框（字体颜色输入） ***********/
	@Test
	public void test23() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_color']");
		webtest.type("xpath=//input[@id='HandyEditor_newdiv_down_color']","#f79646");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_colorok']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（缩进） ***********/
	@Test
	public void test24() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_indent']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
		
	}
	
	/***********跟贴-主贴-输入框（减少缩进） ***********/
	@Test
	public void test25() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_indent']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_outdent']");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（链接）  ***********/
	@Test
	public void test26() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_link']");
		webtest.type("xpath=//input[@id='HandyEditor_newdiv_down_link']","http://localhost/index.php/post/4.html?order=latest");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_linkok']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
		
	}
	
	/***********跟贴-主贴-输入框（取消链接） ***********/
	@Test
	public void test27() throws InterruptedException   {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_link']");
		webtest.type("xpath=//input[@id='HandyEditor_newdiv_down_link']","http://localhost/index.php/post/4.html?order=latest");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_linkok']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_unlink']");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（文本框）***********/
	@Test
	public void test28() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_textblock']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（全选） ***********/
	@Test
	public void test29() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_selectall']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_bold']");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（去除格式）***********/
	@Test
	public void test30() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_selectall']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_bold']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_removeformat']");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（图片）***********/
	@Test
	public void test31() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_image']");
		webtest.type("xpath=//input[@id='HandyEditor_newdiv_down_image']","http://localhost/public/common/images/avatar.png ");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_imageok']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（表情包） ***********/
	@Test
	public void test32() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_expression']");
		webtest.click("xpath=//span[@id='HandyEditor_newdiv_down_expression_kiss']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（下角标）  ***********/
	@Test
	public void test33() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_subscript']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","30");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（上角标）***********/
	@Test
	public void test34() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_superscript']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","30");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（水平线）***********/
	@Test
	public void test35() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_horizontal']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","30");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（有序列表）***********/
	@Test
	public void test36() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_orderedlist']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（无序列表）***********/
	@Test
	public void test37() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_unorderedlist']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（撤销）***********/
	@Test
	public void test38() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_undo']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","30");
		webtest.click("xpath=//button[@id='gentie']");
	}
	
	/***********跟贴-主贴-输入框（重做）***********/
	@Test
	public void test39() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","123");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_undo']");
		webtest.click("xpath=//span[@id='HandyEditor_pinglun_redo']");
		webtest.click("xpath=//button[@id='gentie']");
	}

	/***********跟贴-回复-取消***********/
	@Test
	public void test40() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-light btn-sm jianyu_huifu']");
		webtest.click("xpath=//button[@id='quxiaohuifu']");
	}
	
	/***********跟贴-回复-回复***********/
	@Test
	public void test41() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-light btn-sm jianyu_huifu']");
		webtest.click("xpath=//div[@class='HandyEditor_editor']");
		webtest.type("xpath=//div[@class='HandyEditor_editor']","回复1");
		webtest.click("xpath=//button[@id='huifu']");
	}
	
	/***********跟贴-点赞（自己不能给自己点赞）***********/
	@Test
	public void test42() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-info btn-sm mr-1 denglu jianyu_gentiezan']");
		webtest.click("xpath=//div[@class='jconfirm-buttons']");
	}
	
	/***********跟贴-踩一下（自己不能给自己踩一下）***********/
	@Test
	public void test43() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-secondary btn-sm denglu jianyu_gentiecai']");
		webtest.click("xpath=//div[@class='jconfirm-buttons']");
	}
	
	/***********跟贴-主贴-输入框（删除帖）-取消***********/
	@Test
	public void test44() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-trash-o']");
		webtest.click("xpath=//button[@class='btn btn-default']");
	}
	
	/***********跟贴-主贴-输入框（删除帖）-继续***********/
	@Test
	public void test45() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//i[@class='fa fa-trash-o']");
		webtest.click("xpath=//button[text()='继续']");
	}
	
	/***********板块管理-新建版块-板块名***********/
	@Test
	public void test46() throws InterruptedException {
		Thread.sleep(2000);
		webtest.open("localhost/index.php/admin/index/mainpost.html");
		webtest.click("partLink=新建版块");
		webtest.type("xpath=//input[@name='sname']","板块名1");
	}
	
	/***********板块管理-新建版块-板块别名***********/
	@Test
	public void test47() throws InterruptedException {
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='bieming']","板块名1的别名");
	}
	
	/***********板块管理-新建版块-上级版块***********/
	@Test
	public void test48() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle']");
		webtest.click("xpath=//a[text()='first']");
	}
	
	/***********板块管理-新建版块-用于菜单***********/
	@Test
	public void test49() throws InterruptedException {
		Thread.sleep(2000);
		webtest.click("xpath=//label[@class='custom-control-label']");
	}
	
	/***********板块管理-新建版块-关键字设置***********/
	@Test
	public void test50() throws InterruptedException {
		Thread.sleep(2000);
		webtest.type("xpath=//input[@name='guanjianzi']","板块名关键字");
//		webtest.click("xpath=//button[text()='提交']");
	}
}
