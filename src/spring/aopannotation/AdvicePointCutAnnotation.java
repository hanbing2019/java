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
		// ����һ���շ���
	}

	// ǰ��֪ͨ������value�Ǳ����
	@Before("pointcut()")
	public void before()
	{
		System.out.println("before");
	}

	// ����֪ͨ��value�Ǳ����
	@After("pointcut()")
	public void after()
	{
		System.out.println("---after---");
	}

	// ֪ͨ��������Ŀ�귽������֮�����
	@AfterReturning("pointcut()")
	public void afterReturn()
	{
		System.out.println("---afterReturn---");
	}

	// Ŀ�귽���׳��쳣�����
	@AfterThrowing("pointcut()")
	public void throwingException()
	{
		System.out.println("---throwingException--");
	}

	// ��Ŀ�귽����װ����
	@Around("pointcut()")
	public void around(ProceedingJoinPoint point)
	{
		try
		{
			System.out.println("before");
			// ���û���֪ͨʱ��ͨ��ProceedingJoinPoint����proceed������ִ��Ŀ�귽��
			// ��������������ͻ᲻�����Ŀ�귽��
			point.proceed();
			System.out.println("---after--");
		} catch (Throwable e)
		{
			System.out.println("----" + e.getMessage());
			e.printStackTrace();
		}
	}
}
