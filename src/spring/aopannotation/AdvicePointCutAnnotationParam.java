package spring.aopannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdvicePointCutAnnotationParam
{

	// count(int):执行方法，int是方法参数类型
	// args(num)指定参数，参数名称也要与切点方法签名中的参数相匹配
	// 这个参数就会传递到通知方法
	@Pointcut("execution(* spring.aopannotation.SayDemo.count(int)) && args(num)")
	public void pointcut(int num)
	{
		// 定义一个空方法
	}

	@Before("pointcut(num)")
	public void before(int num)
	{
		System.out.println("before " + num);
	}
}
