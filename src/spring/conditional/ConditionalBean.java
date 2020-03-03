package spring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.Book;

@Configuration
public class ConditionalBean
{

	// @Conditional的value是实现Condition接口的任何类，实现接口后只重写matches()方法即可，
	// 如果返回true，那么就会创建带有@Conditional注解的bean,如果返回false就不会创建
	@Bean
	@Conditional(value = BookCondition.class)
	@Profile(value = "d")
	public Book getBook()
	{
		return new Book();
	}
}
