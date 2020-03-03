package spring.aop.aspectJ;

public class SayProxy implements SaySomething
{
	SaySomething ss = new SayHello();

	@Override
	public void say()
	{
		beforefunc();
		ss.say();
		afterfunc();
	}

	public void beforefunc()
	{
		System.out.println("��ʼ��������");
	}

	public void afterfunc()
	{
		System.out.println("������������");
	}
}
