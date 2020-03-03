package spring;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

public class Advices
{
	public void before(JoinPoint jp)
	{
		System.out.println(jp.getKind());
		// jp.getArgs()��ȡִ�з�������Ĳ��������Ϊobject����
		System.out.println("������� �� " + Arrays.toString(jp.getArgs()));
		// ���ط�����ȫ����������������void spring.JavaMath.add(String)
		System.out.println("--- " + jp.getSignature());
		// ���÷���������
		System.out.println(jp.getSignature().getName());

		System.out.println("before");
	}

	public void after()
	{
		System.out.println("after");
	}

	// ��������ִ�н�����ִ��
	// rvtΪ���صĽ�����������ļ�������aop:after-returning������ returning="rvt"
	public void afterReturning(Object rvt)
	{
		System.out.println("��������ֵ " + rvt);
		System.out.println("afterReturning");
	}

	// �����г����쳣��ִ��,�����ֵĵط�ʹ��try-catch������ִ�иķ���,(�����д������쳣�Ͳ���ִ��afterThrowing )
	// aop:after-throwing�������� throwing="ex"��exΪ�׳����쳣
	public void afterThrowing(Throwable ex)
	{
		System.out.println(ex);
		System.out.println("afterThrowing");
	}
}
