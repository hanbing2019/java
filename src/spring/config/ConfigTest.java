package spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigTest
{
	public static void main(String args[])
	{
		// ComConfig.class
		ApplicationContext context = new AnnotationConfigApplicationContext(
				ComConfig.class);
		DiInfo diInfo = context.getBean(DiInfo.class);
		diInfo.test();
	}
}
