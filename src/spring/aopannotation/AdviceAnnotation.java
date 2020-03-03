package spring.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;

//@Aspect
// 这个注解表名当前类不仅仅是一个pojo,还是一个切面
//@Component
public class AdviceAnnotation
{
	// 使用注解来实现通知

	// 使用execution()指示器来配置切点
	// execution(* spring.aopannotation.SayDemo.say(..))
	// execution表示在方法执行时触发，
	// * 表示返回任意类型
	// spring.aopannotation.SayDemo 方法所属的类
	// say(..)执行的具体方法，可以用*表示，意思是类中所有的方法，..表示参数
	// spring.aopannotation.SayDemo.say(..)
	// -->spring.aopannotation.SayDemo.*(..)

	// 以上是切点配置到具体的方法，也可以配置到包
	// 使用within()指示器
	// execution(* spring.aopannotation.SayDemo.say(..)) && within(spring.*)
	// &&同and，把execution和within来接起来
	// ||(or)或关系操作符
	// !(not)非操作

	// 前置通知方法，value是必须的
	@Before("execution(* spring.aopannotation.SayDemo.say(..))")
	public void before()
	{
		System.out.println("before");
	}

	// 后置通知，value是必须的
	@After("execution(* spring.aopannotation.SayDemo.*(..))")
	public void after()
	{
		System.out.println("---after---");
	}

	// 通知方法会在目标方法返回之后调用
	@AfterReturning("execution(* spring.aopannotation.SayDemo.*(..))")
	public void afterReturn()
	{
		System.out.println("---afterReturn---");
	}

	// 目标方法抛出异常后调用
	@AfterThrowing("execution(* spring.aopannotation.SayDemo.*(..))")
	public void throwingException()
	{
		System.out.println("---throwingException--");
	}

	// 将目标方法封装起来
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
