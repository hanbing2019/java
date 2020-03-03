package spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@EnableWebMvc 作用启动springmvc
@Configuration
@EnableWebMvc
@ComponentScan("spring.mvc")
public class WebConfig extends WebMvcConfigurerAdapter
{
	// 设置jsp视图解析
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/views/");
		viewresolver.setSuffix(".jsp");
		viewresolver.setExposeContextBeansAsAttributes(true);
		return viewresolver;
	}

	// 配置静态资源的处理
	public void configDefaultServletHanding(
			DefaultServletHandlerConfigurer config)
	{
		config.enable();
	}
}
