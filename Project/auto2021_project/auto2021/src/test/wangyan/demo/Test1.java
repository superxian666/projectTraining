package test.wangyan.demo;

import javax.xml.xpath.XPath;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.WebDriverEngine;

public class Test1 extends BaseTest{

//	登录成功
	@Test
	public void test1(){
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
	
		webtest.click("link=发新帖");
		
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
	}
	
	
	
	
	
//	//登录成功并进入前台
	@Test
	public void test2(){
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");
		
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");		
	}
	
	
	
	
//	发帖区-发新帖-发帖成功-只填写必填项
	@Test
	public void test3() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		webtest.click("id=formsubmit");
		
	}
	
	
//	发帖区-我的主帖-打开我的主贴界面
	@Test
	public void test4() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("link=我的主帖");
	}
	
	
	
	
//	发帖区-我的主贴-查看我的主贴
	@Test
	public void test5() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		
		webtest.click("link=我的主帖");
		webtest.click("class=text-info");
	}
	
	
	
	
//	发帖区-我的主帖-给自己发的帖子点赞失败提示不能给自己帖子点赞
	@Test
	public void test6() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");
		webtest.click("class=text-info");
		
		webtest.click("id=postzan");
		webtest.click("link=确定");
	}
	
	
	
	
//	发帖区-我的主帖-给自己发的帖子踩一踩失败提示不能踩自己帖子
	@Test
	public void test7() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");
		webtest.click("class=text-info");
		
		webtest.click("id=postcai");
		webtest.click("link=确定");
	}
	
	
	
	
//	发帖区-我的主帖-不能收藏自己的帖子
	@Test
	public void test8() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");
		webtest.click("class=text-info");
		
		webtest.click("id=postshoucang");
		webtest.click("link=确定");
	}
	
	
	
	
//	发帖区-我的主贴-修改主贴成功
	@Test
	public void test9() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");
		
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[7]/a/i");
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=second");
	}
	
	
	
	
//	发帖区-我的主贴-删除主贴成功
	@Test
	public void test10() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");
	
	    webtest.click("xpath=//*[@class='fa fa-trash-o']");	
	    webtest.click("xpath=//*[@class='btn btn-info']");
		
	}
	
	
	
//	发帖区-我的主贴-取消删除主贴
	@Test
	private void test11() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");

		webtest.click("xpath=//*[@class='fa fa-trash-o']");
		webtest.click("link=取消");
		
	}
	
	
	
//	发帖区-我的主贴-回复帖子
	@Test
	public void test12() {

		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		
		webtest.click("link=发新帖");
		
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的主帖");
		
		webtest.click("xpath=//*[@class='text-info']");
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/post/5.html");
		webtest.type("xpath=//*[@class='HandyEditor_editor']", "1");
	}
	
	
	
//	发帖区-发帖区-发新帖-发帖内容必填项之外插入附件
	@Test
	public void test13() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		webtest.type("id=fujian", "C:\\ksafe\\Samsung Galaxy S204020.jpg");
		webtest.click("id=formsubmit");
	}
	
	
	
//	发帖区-我的跟帖-打开我的跟帖界面
	@Test
	public void test14() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的跟帖");
	}
	
	
	
//	发帖区-我的跟帖-修改跟帖
	@Test
	public void test15() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的跟帖");
		
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[7]/a/i");
		
		webtest.type("xpath=//*[@class='HandyEditor_editor']", "1234");
		webtest.click("lingk=修改");
	}
	
	
	
//	发帖区-我的跟帖-取消修改我的跟帖
	@Test
	public void test16() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的跟帖");
		
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/table/tbody/tr[1]/td[7]/a/i");
		webtest.click("link=取消");
	}
	
	
	
//	发帖区-我的跟帖-删除跟帖
	@Test
	public void test17() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的跟帖");
		webtest.click("xpath=//*[@class='fa fa-trash-o']");
		webtest.click("xpath=//*[@class='btn btn-info']");
	}
	
	
	
	
//	发帖区-我的跟帖-取消删除跟帖
	@Test
	public void test18() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的跟帖");
		webtest.click("xpath=//*[@class='fa fa-trash-o']");
		webtest.click("xpath=//*[@class='btn btn-default']");
	}
	
	
	
//	发贴区-打开回收桶界面
	@Test
	public void test19() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=回收桶");
	}
	
	
	
	
//	发贴区-回收桶-还原被删除的帖子
	@Test
	public void test20() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=回收桶");
		webtest.click("link=还原");
		webtest.click("xpath=//*[@class='btn btn-info']");
	}
	
	
	
	
//	发帖区-回收桶-取消还原被删除的帖子
	@Test
	public void test21() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=回收桶");
		webtest.click("link=还原");
		webtest.click("xpath=//*[@class='btn btn-default']");
	}
	
	
	
	
//	发帖区-回收桶-彻底删除被删除的帖子
	@Test
	public void test22() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=回收桶");
		webtest.click("link= 彻底删除");
		webtest.click("xpath=//*[@class='btn btn-info']");
	}
	
	
	
	
//	发帖区-回收桶-取消彻底删除回收桶的帖子
	@Test
	public void test23() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=回收桶");
		webtest.click("link=彻底删除");
		webtest.click("xpath=//*[@class='btn btn-default']");
	}
	
	
	
//	发帖区-新发帖-发帖设置查看帖子需要1积分
	@Test
	public void test24() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		webtest.type("id=fujian", "C:\\ksafe\\Samsung Galaxy S204020.jpg");
		webtest.typeAndClear("name=jifen", "");
		webtest.type("name=jifen", "1");
		webtest.click("id=formsubmit");
		
	}
//	发帖区-新发帖-发帖设置下载附件需要3积分
	@Test
	public void test25() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		webtest.type("id=fujian", "C:\\ksafe\\Samsung Galaxy S204020.jpg");
		
		webtest.selectByValue("name=jifenleixing", "2");
		webtest.typeAndClear("name=jifen", "3");
		webtest.click("id=formsubmit");
	}
	
	
//	发帖区-发新帖-发帖成功-只填写必填项-发帖内容插入图片成功
	@Test
	public void test26() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		
		webtest.click("xpath=//*[@class='he-picture']");
		webtest.type("id=HandyEditor_newdiv_down_image", "C:\\ksafe\\plants-vs-zombies\\PlantsVsZombies\\reanim\\accessories_08.png");
		webtest.click("id=HandyEditor_newdiv_down_imageok");
		webtest.click("id=formsubmit");
		
	}
	
	
	
//	发帖区-发新帖-发帖成功-只填写必填项-发帖内容插入链接成功
	@Test
	public void test27() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		
		webtest.click("xpath=//*[@class='he-link']");
		webtest.type("id=HandyEditor_newdiv_down_link", "https://www.baidu.com");
		webtest.click("xpath=//*[@id='HandyEditor_newdiv_down_linkok']");
		webtest.click("id=formsubmit");
	}
	
	
	
//	发帖区-发新帖-发帖成功-只填写必填项-发帖内容插入链接成功后取消链接
	@Test
	public void test28() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		
		webtest.click("link=admin");
		webtest.click("link=用户中心");	
		
		webtest.click("xpath=//button[@class='btn btn-light dropdown-toggle\'][1]"); 
		webtest.click("link=first");
		webtest.click("xpath=/html/body/div[1]/div/div[2]/div/form/div[1]/div[2]/div/div/button");
		webtest.click("link=原创");
		webtest.type("name=biaoti", "1");
		webtest.type("class=HandyEditor_editor", "1");
		
		webtest.click("xpath=//*[@class='he-link']");
		webtest.type("id=HandyEditor_newdiv_down_link", "https://www.baidu.com");
		webtest.click("xpath=//*[@id='HandyEditor_newdiv_down_linkok']");
		webtest.click("xpath=//*[@class='he-unlink']");
		webtest.click("id=formsubmit");
		
		
	}
	
	
	
//	个人信息-打开我的头像界面
	@Test
	public void test29() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的头像");
	}
	
	
	
//	个人信息-我的头像-上传头像
	@Test
	public void test30() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的头像");
		webtest.click("xpath=//*[@class='docs-tooltip']");
		webtest.click("link=保存");
	}
	
	
	
	
//	个人信息-进入我的资料界面
	@Test
	private void test31() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
	
	}
	
	
//	个人信息-我的资料-修改昵称成功
	@Test
	public void  test32() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=nicheng", "");
		webtest.type("name=nicheng", "第32条冒烟测试");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-修改性别为女成功
	@Test
	public void test33() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.selectByValue("name=xingbie","2");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-修改个人邮箱成功
	@Test
	public void test34() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=email", "");
		webtest.type("name=email", "1233@qq.com");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-修改个人邮箱失败-提示邮箱格式不对
	@Test
	public void test35() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=email", "");
		webtest.type("name=email", "ssadas2313");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-补充个人手机号
	@Test
	public void test36() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=shouji", "18875746173");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-选择生日
	@Test
	public void test37() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=shengri", "2011-11-14");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-我的资料-补充完整非必填项
	@Test
	public void test38() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.typeAndClear("name=qq", "875012077");
		webtest.typeAndClear("name=weibo", "wangyan");
		webtest.typeAndClear("name=wechat", "weixin");
		webtest.typeAndClear("name=facebook", "lianshu");
		webtest.typeAndClear("name=twitter", "推特");
		webtest.typeAndClear("name=qianming", "第三十八条冒烟测试");
		webtest.click("id=formsubmit");
		
	}
	
	
//	个人信息-我的资料-填写个人网址
	@Test
	public void test39() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-填写学校信息
	@Test
	public void test40() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-我的资料-填写qq
	@Test
	public void test41() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
	
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.typeAndClear("name=qq", "875012077");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-填写微博信息
	@Test
	public void test42() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.typeAndClear("name=qq", "875012077");
		webtest.typeAndClear("name=weibo", "wangyan");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-填写微信信息
	@Test
	public void test43() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.typeAndClear("name=qq", "875012077");
		webtest.typeAndClear("name=weibo", "wangyan");
		webtest.typeAndClear("name=wechat", "weixin");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-我的资料-填写脸书信息
	@Test
	public void test44() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.typeAndClear("name=qq", "875012077");
		webtest.typeAndClear("name=weibo", "wangyan");
		webtest.typeAndClear("name=wechat", "weixin");
		webtest.typeAndClear("name=facebook", "lianshu");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-我的资料-填写推特信息
	@Test
	public void test45() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.typeAndClear("name=url", "www.baidu.com");
		webtest.typeAndClear("name=xuexiao", "河北师范大学");
		webtest.typeAndClear("name=qq", "875012077");
		webtest.typeAndClear("name=weibo", "wangyan");
		webtest.typeAndClear("name=wechat", "weixin");
		webtest.typeAndClear("name=facebook", "lianshu");
		webtest.typeAndClear("name=twitter", "推特");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-我的资料-填写个性签名
	@Test
	public void test46() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
		webtest.type("name=nicheng", "第32条冒烟测试");
		webtest.type("name=email", "1233@qq.com");
		webtest.typeAndClear("name=qianming", "第三十八条冒烟测试");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-进入修改密码界面
	@Test
	public void test47() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=我的资料");
	}
	
//	个人信息-修改密码-原密码输入错误
	@Test
	public void test48() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=修改密码");
		webtest.typeAndClear("name=opwd", "123456789");
		webtest.typeAndClear("name=npwd", "12345678");
		webtest.typeAndClear("name=rpwd", "12345678");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-修改密码-原密码和新密码一致
	@Test
	public void test49() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=修改密码");
		webtest.typeAndClear("name=opwd", "12345678");
		webtest.typeAndClear("name=npwd", "12345678");
		webtest.typeAndClear("name=rpwd", "12345678");
		webtest.click("id=formsubmit");
	}
	
	
//	个人信息-修改密码-两次新密码不一致
	@Test
	public void test50() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=修改密码");
		webtest.typeAndClear("name=opwd", "12345678");
		webtest.typeAndClear("name=npwd", "12345678");
		webtest.typeAndClear("name=rpwd", "123456789");
		webtest.click("id=formsubmit");
	}
	
//	个人信息-修改密码成功
	@Test
	public void test51() {
		webtest.open("localhost/jianyuluntan_2.4.6/index.php/index.html");
		webtest.click("link=发新帖");	
		webtest.type("name=user", "admin");
		webtest.type("name=pwd","12345678");
		webtest.click("id=submit");
		webtest.click("link=admin");
		webtest.click("link=用户中心");
		webtest.click("link=修改密码");
		webtest.typeAndClear("name=opwd", "12345678");
		webtest.typeAndClear("name=npwd", "12345678");
		webtest.typeAndClear("name=rpwd", "12345678");
		webtest.click("id=formsubmit");
	}
}
