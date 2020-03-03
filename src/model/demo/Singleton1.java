package model.demo;

/**
 * 静态内部类模式
 * 
 * @author Administrator
 * 
 */
public class Singleton1
{
	private Singleton1()
	{

	}

	public static Singleton1 getInstance()
	{
		return InnerInit.singleton;
	}

	private static class InnerInit
	{
		public static Singleton1 singleton = new Singleton1();

	}

}
