package spring.editor;

import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EditorDemo
{

	public static void main(String[] args)
	{
		BeanDefinitionRegistryPostProcessor d;
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:bean-config-editor.xml");
		User user = (User) context.getBean("u");
		System.out.println(user);
	}

}
