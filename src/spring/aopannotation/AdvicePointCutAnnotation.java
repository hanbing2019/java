package spring.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Aspect
//@Component
public class AdvicePointCutAnnotation
{
	@Pointcut("execution(* spring.aopannotation.SayDemo.*(..))")
	public void pointcut()
	{
		// 定义一个空方法
	}

	// 前置通知方法，value是必须的
	@Before("pointcut()")
	public void before()
	{
		System.out.println("before");
	}

	// 后置通知，value是必须的
	@After("pointcut()")
	public void after()
	{
		System.out.println("---after---");
	}

	// 通知方法会在目标方法返回之后调用
	@AfterReturning("pointcut()")
	public void afterReturn()
	{
		System.out.println("---afterReturn---");
	}

	// 目标方法抛出异常后调用
	@AfterThrowing("pointcut()")
	public void throwingException()
	{
		System.out.println("---throwingException--");
	}

	// 将目标方法封装起来
	@Around("pointcut()")
	public void around(ProceedingJoinPoint point)
	{
		try
		{
			System.out.println("before");
			// 配置环绕通知时，通过ProceedingJoinPoint调用proceed方法来执行目标方法
			// 不调用这个方法就会不会访问目标方法
			point.proceed();
			System.out.println("---after--");
		} catch (Throwable e)
		{
			System.out.println("----" + e.getMessage());
			e.printStackTrace();
		}
	}
}
