package spring.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//junit≤‚ ‘£¨
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComponentConfig.class)
public class ComponentTest
{
	@Autowired
	ComponentDemo componentDemo;

	@Test
	public void test()
	{
		componentDemo.say();
	}

}
