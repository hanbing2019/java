package model.demo;

/**
 * ��̬�ڲ���ģʽ
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
