package spring.propery;

import org.springframework.stereotype.Component;

@Component
public class LoadDemo
{
	String username;
	String password;

	public void show()
	{
		System.out.println("LoadDemo [username=" + username + ", password="
				+ password + "]");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "LoadDemo [username=" + username + ", password=" + password
				+ "]";
	}

}
