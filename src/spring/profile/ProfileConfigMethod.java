package spring.profile;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import spring.Advices;
import spring.Book;

@Configuration
public class ProfileConfigMethod
{

	// @Profileʹ���ڷ����ϣ���ôprofile����ִ����Ӧ�Ĵ���bean������û�м���ķ����ͻ����
	// û��ʹ��@Profileע���beanʼ�ն��ᴴ�����뼤���Ǹ�profileû�й�ϵ
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
