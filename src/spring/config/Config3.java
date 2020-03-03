package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@Configuration
@Import(value =
{ Config1.class, Config2.class })
@ImportResource("classpath:application.xml")
public class Config3
{
	// 单独定义一个配置来，将其他配置类同一导入
	// 使用@ImportResource注解将xml配置文件导入，启动是就会加载xml配置文件
}
