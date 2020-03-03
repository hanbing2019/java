package spring.propery;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
// 指定加载的properties文件
@PropertySource(value = "classpath:/test.properties")
@ComponentScan(basePackages = "spring.propery")
public class PropertyConfig
{
	// 创建解析配置文件bean
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
}
