package com.JavaMailTask.www;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(JavaMailTestListener.class)
public class Demo {
	@Test
	public void test1() {
		Assert.assertEquals(1, 1);
	}
	@Test
	public void test2() {
		Assert.assertEquals(2, 2);
	}
	@Test
	public void test3() {
		Assert.assertEquals(3, 4);
	}
	@Test
	public void test4() {
		Assert.assertEquals(4, 5);
	}
	@Test
	public void test5() {
		Assert.assertEquals(5,6);
	}

}
