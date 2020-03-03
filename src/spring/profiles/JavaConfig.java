package spring.profiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JavaConfig
{
	@Bean
	@Profile("dao1")
	public BaseDao dao1Impl()
	{
		return new Dao1Impl();
	}

	@Bean
	@Profile("dao2")
	public BaseDao dao2Impl()
	{
		return new Dao2Impl();
	}

	@Bean
	public ServiceDeal deal()
	{
		ServiceDeal sd = new ServiceDeal();
		sd.setBaseDao(dao2Impl());
		return sd;
	}
}
