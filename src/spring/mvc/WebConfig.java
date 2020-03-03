package spring.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@EnableWebMvc ��������springmvc
@Configuration
@EnableWebMvc
@ComponentScan("spring.mvc")
public class WebConfig extends WebMvcConfigurerAdapter
{
	// ����jsp��ͼ����
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver viewresolver = new InternalResourceViewResolver();
		viewresolver.setPrefix("/WEB-INF/views/");
		viewresolver.setSuffix(".jsp");
		viewresolver.setExposeContextBeansAsAttributes(true);
		return viewresolver;
	}

	// ���þ�̬��Դ�Ĵ���
	public void configDefaultServletHanding(
			DefaultServletHandlerConfigurer config)
	{
		config.enable();
	}
}
