package spring.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig
{
	@Bean(name = "javaBeanDemo")
	public JavaBeanDemo getJavaBeanDemo()
	{
		return new JavaBeanDemo();
	}

	@Bean
	public JavaBeanInset getJavaBeanInset()
	{
		// 注入其他的bean
		return new JavaBeanInset(getJavaBeanDemo());
	}
}
