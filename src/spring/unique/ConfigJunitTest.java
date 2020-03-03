package spring.unique;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FruitConfig.class)
public class ConfigJunitTest
{

	@Autowired
	Service service;

	@Test
	public void test()
	{
		service.choose();
	}
}
