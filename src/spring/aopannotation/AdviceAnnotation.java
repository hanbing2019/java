package spring.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

//@Aspect
// ���ע�������ǰ�಻������һ��pojo,����һ������
//@Component
public class AdviceAnnotation
{
	// ʹ��ע����ʵ��֪ͨ

	// ʹ��execution()ָʾ���������е�
	// execution(* spring.aopannotation.SayDemo.say(..))
	// execution��ʾ�ڷ���ִ��ʱ������
	// * ��ʾ������������
	// spring.aopannotation.SayDemo ������������
	// say(..)ִ�еľ��巽����������*��ʾ����˼���������еķ�����..��ʾ����
	// spring.aopannotation.SayDemo.say(..)
	// -->spring.aopannotation.SayDemo.*(..)

	// �������е����õ�����ķ�����Ҳ�������õ���
	// ʹ��within()ָʾ��
	// execution(* spring.aopannotation.SayDemo.say(..)) && within(spring.*)
	// &&ͬand����execution��within��������
	// ||(or)���ϵ������
	// !(not)�ǲ���

	// ǰ��֪ͨ������value�Ǳ����
	@Before("execution(* spring.aopannotation.SayDemo.say(..))")
	public void before()
	{
		System.out.println("before");
	}

	// ����֪ͨ��value�Ǳ����
	@After("execution(* spring.aopannotation.SayDemo.*(..))")
	public void after()
	{
		System.out.println("---after---");
	}

	// ֪ͨ��������Ŀ�귽������֮�����
	@AfterReturning("execution(* spring.aopannotation.SayDemo.*(..))")
	public void afterReturn()
	{
		System.out.println("---afterReturn---");
	}

	// Ŀ�귽���׳��쳣�����
	@AfterThrowing("execution(* spring.aopannotation.SayDemo.*(..))")
	public void throwingException()
	{
		System.out.println("---throwingException--");
	}

	// ��Ŀ�귽����װ����
	@Around("execution(* spring.aopannotation.SayDemo.*(..))")
	public void around(ProceedingJoinPoint point)
	{
		try
		{
			point.proceed();
			System.out.println("---around--");
		} catch (Throwable e)
		{
			System.out.println("----" + e.getMessage());
			e.printStackTrace();
		}
	}

}
