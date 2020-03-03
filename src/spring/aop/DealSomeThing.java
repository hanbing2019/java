package spring.aop;

import org.springframework.stereotype.Component;

@Component
public class DealSomeThing
{
	public void func1()
	{
		System.out.println("---func1---");
	}

	public String func2()
	{
		return "func2";
	}

}
