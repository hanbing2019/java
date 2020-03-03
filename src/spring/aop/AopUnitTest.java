package spring.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ScanConfig.class)
public class AopUnitTest
{
	@Autowired
	DealSomeThing dst;

	@Test
	public void test()
	{
		dst.func1();
	}

}
