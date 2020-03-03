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
		Environment e = context.getEnvironment();// ��ȡϵͳ��������
		// e.containsProperty ȡ��ĳ�����ã��ж��Ƿ����
		System.out.println("----" + e.containsProperty("JAVA_HOME"));
		return e.containsProperty("JAVA_HOME");
	}
}
