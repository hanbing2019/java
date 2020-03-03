package spring.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class BookCondition implements Condition
{

	@Override
	public boolean matches(ConditionContext context,
			AnnotatedTypeMetadata metadata)
	{
		// 通过ConditionContext获取Environment对象
		// 通过Environment对象检查环境中是否存在指定名称（比如book）的环境属性
		// 属性值是什么无所谓，只要结果返回true，那么就会去创建bean,否则不会
		Environment e = context.getEnvironment();
		return e.containsProperty("book");// 检查属性是否存在
	}

}
