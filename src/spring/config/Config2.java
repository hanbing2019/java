package spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = Config1.class)
public class Config2
{
	// 创建了多个配置类，使用@Import注解将配置类关联起来
}
