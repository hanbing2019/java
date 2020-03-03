package spring.profiles.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistCondition implements Condition
{

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata meta)
	{
		Environment e = context.getEnvironment();// 获取系统环境变量
		// e.containsProperty 取出某个配置，判断是否存在
		System.out.println("----" + e.containsProperty("JAVA_HOME"));
		return e.containsProperty("JAVA_HOME");
	}
}
