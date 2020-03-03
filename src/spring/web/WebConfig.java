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
// ����springmvc
@ComponentScan(basePackages = "spring.web", excludeFilters =
{ @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class) })
public class WebConfig extends WebMvcConfigurerAdapter
{
	// ������ͼ����ͼ
	@Bean
	public ViewResolver getViewResolver()
	{
		// ����jsp��ͼ������
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/page");// ����ǰ׺
		resolver.setSuffix(".jsp");// ���ú�׺
		return resolver;
	}

	// ���þ�̬��Դ�Ĵ���
	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer)
	{
		configurer.enable();
	}

}
