package spring.aop.aspectJ;

public class SayHello implements SaySomething
{

	public static void main(String args[])
	{
		SayProxy sp = new SayProxy();
		sp.say();
	}

	@Override
	public void say()
	{

		System.out.println("say hello");
	}
}
