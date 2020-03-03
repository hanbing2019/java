package spring.component;

import org.springframework.stereotype.Component;

//使用@Component注解，告诉spring启动是创建当前类的bean
@Component
public class ComponentDemo
{
	public void say()
	{
		System.out.println("hello world!!");
	}

}
