package spring.component;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = JavaBeanDemo.class)
public class JavaBeanTest
{
	@Autowired
	JavaBeanDemo javaBeanDemo;

	@Test
	public void test()
	{
		javaBeanDemo.say();
	}
}
