package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration 声明该类为配置类
@Configuration
public class ComConfig
{

	// @Bean 告诉spring返回一个对象，该对象被注册为spring上下文中的bean(功能相当于在xml配置对应的bean)
	// 默认情况下bean的id为带有@Bean注解的方法名称一样
	@Bean
	public ComInterImpl comInterImpl()
	{
		return new ComInterImpl();
	}

	@Bean
	public DiInfo diInfo()
	{
		DiInfo di = new DiInfo();
		di.setComInterImpl(comInterImpl());
		return di;
	}
}
