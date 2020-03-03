package spring.aop.xml;

import org.aspectj.lang.JoinPoint;

public class AspectInfo
{
	public void before(JoinPoint jp)
	{
		System.out.println("�������" + jp.getArgs());
		System.out.println("before");
	}

	public void after()
	{
		System.out.println("after");
	}

}
