package spring.propery;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonDemo
{

	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;

	public void func()
	{
		System.out.println("username " + username + " password " + password);
	}

}
