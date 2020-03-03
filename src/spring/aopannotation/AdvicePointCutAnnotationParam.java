package spring.aopannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdvicePointCutAnnotationParam
{

	// count(int):ִ�з�����int�Ƿ�����������
	// args(num)ָ����������������ҲҪ���е㷽��ǩ���еĲ�����ƥ��
	// ��������ͻᴫ�ݵ�֪ͨ����
	@Pointcut("execution(* spring.aopannotation.SayDemo.count(int)) && args(num)")
	public void pointcut(int num)
	{
		// ����һ���շ���
	}

	@Before("pointcut(num)")
	public void before(int num)
	{
		System.out.println("before " + num);
	}
}
