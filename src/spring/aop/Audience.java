package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect������ǰ����һ������
@Aspect
@Component
public class Audience
{
	// @Pointcut���õ�ֵ��һ���е���ʽ
	// �����������е㣬��֮���aspectjע���ʱ���������ֱ��ʹ���������
	// �����е�һ��֮���ֱ��Ӧ��
	@Pointcut("execution(* spring.aop.DealSomeThing.func1(..))")
	public void common()
	{
	}

	// �����е�execution(* spring.aop.DealSomeThing.*(..))
	// execution(*
	// spring.aop.DealSomeThing.func1(..)||spring.aop.DealSomeThing.func2(..))

	// execution:��ʾ����ִ��ʱ����
	// *��ʾ���ⷵ������
	// spring.aop.DealSomeThing������������
	// ���һ��*:ͨ�����ʾ�������еķ�����Ҳ����ֱ��дĳ��������
	// ..��ʾ��������Ĳ���
	// ���ӷ�||-��or &&->and !->not
	// @Before("execution(* spring.aop.DealSomeThing.func1(..))")
	@Before("common()")
	public void before()
	{
		System.out.println("------before-------");
	}

	@After("execution(* spring.aop.DealSomeThing.func1(..))")
	public void after()
	{
		System.out.println("------after-------");
	}

	@AfterThrowing("execution(* spring.aop.DealSomeThing.*(..))")
	public void afterThrowing()
	{
		System.out.println("------afterThrowing-------");
	}

	@AfterReturning("execution(* spring.aop.DealSomeThing.*(..))")
	public void afterRetruning()
	{
		System.out.println("------afterRetruning-------");
	}
}
