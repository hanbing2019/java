package spring.profile;

import java.awt.print.Book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile(value = "dev")注解使用在类上面时，
//它会告诉spring配置类bean只有在dev profile被激活时才会创建
//如果bean没有被激活，那么带有@Bean的方法会被忽略掉
@Configuration
@Profile(value = "dev")
public class ProfileConfig
{
	@Bean
	public Book getBook()
	{
		return new Book();
	}

}
