package spring;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class Advices
{
	public void before(JoinPoint jp)
	{
		System.out.println(jp.getKind());
		// jp.getArgs()获取执行方法传入的参数，结果为object数组
		System.out.println("请求参数 ： " + Arrays.toString(jp.getArgs()));
		// 返回方法的全类名包括返回类型void spring.JavaMath.add(String)
		System.out.println("--- " + jp.getSignature());
		// 调用方法的名称
		System.out.println(jp.getSignature().getName());

		System.out.println("before");
	}

	public void after()
	{
		System.out.println("after");
	}

	// 方法正常执行结束后执行
	// rvt为返回的结果，在配置文件中配置aop:after-returning的属性 returning="rvt"
	public void afterReturning(Object rvt)
	{
		System.out.println("方法返回值 " + rvt);
		System.out.println("afterReturning");
	}

	// 方法中出现异常才执行,但出现的地方使用try-catch，不会执行改方法,(方法中处理了异常就不会执行afterThrowing )
	// aop:after-throwing配置属性 throwing="ex"，ex为抛出的异常
	public void afterThrowing(Throwable ex)
	{
		System.out.println(ex);
		System.out.println("afterThrowing");
	}
}
