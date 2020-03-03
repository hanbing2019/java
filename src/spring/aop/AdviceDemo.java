package spring.aop;

public class AdviceDemo
{
	public void before()
	{
		System.out.println("业务组件执行前");
	}

	public void after()
	{
		System.out.println("业务组件执行后");
	}

}
