package spring.aop;

import org.springframework.stereotype.Component;

@Component("dealInfo")
public class DealInfo
{
	public void func1()
	{
		System.out.println("------func1--------");
	}

}
