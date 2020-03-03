package spring.aop.xml;

import org.springframework.stereotype.Component;

@Component("df")
public class Dealfunc
{
	public void func(String a)
	{
		System.out.println("deal func");
	}

	public void func2(int num, String str)
	{
		System.out.println("--func2-- " + num);
		System.out.println("--func2-- " + str);
	}
}
