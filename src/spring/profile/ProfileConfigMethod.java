package spring.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.Advices;
import spring.Book;

@Configuration
public class ProfileConfigMethod
{

	// @Profile使用在方法上，那么profile激活执行相应的创建bean方法，没有激活的方法就会忽略
	// 没有使用@Profile注解的bean始终都会创建，与激活那个profile没有关系
	@Profile(value = "dev")
	public Book getBook()
	{
		return new Book();
	}

	@Profile(value = "prof")
	public Advices getAdvices()
	{
		return new Advices();
	}

}
