package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration ��������Ϊ������
@Configuration
public class ComConfig
{

	// @Bean ����spring����һ�����󣬸ö���ע��Ϊspring�������е�bean(�����൱����xml���ö�Ӧ��bean)
	// Ĭ�������bean��idΪ����@Beanע��ķ�������һ��
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
