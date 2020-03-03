package spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class AspectXml
{
	@Pointcut("execution (* spring.aop.xml.DealXml.func1(..))")
	public void common()
	{
	}

	// @Before("common()")
	// public void before()
	// {
	// System.out.println("xml  before");
	// }
	//
	// @After("common()")
	// public void after()
	// {
	// System.out.println("------after-------");
	// }
	//
	// @AfterThrowing("common()")
	// public void afterThrowing()
	// {
	// System.out.println("------afterThrowing-------");
	// }
	//
	// @AfterReturning("common()")
	// public void afterRetruning()
	// {
	// System.out.println("------afterRetruning-------");
	// }
	// @Around:表名当前通知为环绕通知，将common()作为切点，方法中必须添加ProceedingJoinPoint参数
	// 用来调用要执行的方法，可以在执行前后或者异常是做任何处理
	@Around("common()")
	public void arround(ProceedingJoinPoint jp)
	{
		try
		{
			System.out.println("this arround");
			jp.proceed();
			System.out.println("arround end");
		} catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
}
