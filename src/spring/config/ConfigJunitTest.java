package spring.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ComConfig.class)
public class ConfigJunitTest
{
	@Autowired
	DiInfo diInfo;

	@Test
	public void test()
	{
		diInfo.test();
	}
}
