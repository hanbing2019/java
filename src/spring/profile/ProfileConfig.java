package spring.profile;

import java.awt.print.Book;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Profile(value = "dev")ע��ʹ����������ʱ��
//�������spring������beanֻ����dev profile������ʱ�Żᴴ��
//���beanû�б������ô����@Bean�ķ����ᱻ���Ե�
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
