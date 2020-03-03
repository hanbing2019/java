package spring.conditional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.Book;

@Configuration
public class ConditionalBean
{

	// @Conditional��value��ʵ��Condition�ӿڵ��κ��࣬ʵ�ֽӿں�ֻ��дmatches()�������ɣ�
	// �������true����ô�ͻᴴ������@Conditionalע���bean,�������false�Ͳ��ᴴ��
	@Bean
	@Conditional(value = BookCondition.class)
	@Profile(value = "d")
	public Book getBook()
	{
		return new Book();
	}
}
