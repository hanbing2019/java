package spring.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
// 启动springmvc
@ComponentScan(basePackages = "spring.web", excludeFilters =
{ @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class WebConfig extends WebMvcConfigurerAdapter
{
	// 配置视图解析图
	@Bean
	public ViewResolver getViewResolver()
	{
		// 配置jsp视图解析器
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/page");// 设置前缀
		resolver.setSuffix(".jsp");// 设置后缀
		return resolver;
	}

	// 配置静态资源的处理
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

}
