package spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//@Aspect表名当前类是一个切面
@Aspect
@Component
public class Audience
{
	// @Pointcut设置的值是一个切点表达式
	// 定义命名的切点，在之后的aspectj注解的时候参数可以直接使用这个方法
	// 定义切点一次之后就直接应用
	@Pointcut("execution(* spring.aop.DealSomeThing.func1(..))")
	public void common()
	{
	}

	// 定义切点execution(* spring.aop.DealSomeThing.*(..))
	// execution(*
	// spring.aop.DealSomeThing.func1(..)||spring.aop.DealSomeThing.func2(..))

	// execution:表示方法执行时触发
	// *表示任意返回类型
	// spring.aop.DealSomeThing方法所属的类
	// 最后一个*:通配符表示类中所有的方法，也可以直接写某个方法名
	// ..表示方法任意的参数
	// 连接符||-》or &&->and !->not
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
