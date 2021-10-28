//任务6 2021年5月19日 星期三
//朱铮麟 2019级 软件六班 2019012499 

package demo;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import demo.JavaMailTestListener;

@Listeners({ JavaMailTestListener.class })
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
		Assert.assertEquals(2, 2);
	}

	@Test
	public void test4() {
		Assert.assertEquals(3, 3);
	}

	@Test
	public void test5() {
		Assert.assertEquals(3, 3);
	}
}
