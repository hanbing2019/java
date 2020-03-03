package spring.propery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// ָ�����ص�properties�ļ�
@PropertySource(value = "classpath:/test.properties")
@ComponentScan(basePackages = "spring.propery")
public class PropertyConfig
{
	// �������������ļ�bean
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
}
