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
		// ͨ��ConditionContext��ȡEnvironment����
		// ͨ��Environment�����黷�����Ƿ����ָ�����ƣ�����book���Ļ�������
		// ����ֵ��ʲô����ν��ֻҪ�������true����ô�ͻ�ȥ����bean,���򲻻�
		Environment e = context.getEnvironment();
		return e.containsProperty("book");// ��������Ƿ����
	}

}
