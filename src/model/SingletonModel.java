package model;

/**
 * 单例模式
 * 
 * 优点:防止其他对象对自己的实例化，确保对象唯一，节约了系统资源
 * 
 * 使用场景：1工具类，2共享统一资源或者操作同一个资源，spring
 * 
 * 好处：保证一个class对应一个实例，避免共享资源的多重占用，节约资源
 * 
 * 不能用反射来创建单例模式的实例，这样会生成一个新的对象
 * 
 * @author Administrator
 * 
 */
public class SingletonModel
{
	// 实现简单模式的方式
	// 采用单例模式的类的构造方法私有化（用private修饰）那么在其他的类中就不能创建对象
	private SingletonModel()
	{

	}

	// 1.饿汉模式：利用类加载的时候创建实例，不存在多个线程创建多个实例，会造成资源的浪费
	// 在其内部产生该类的实例化对象，并封装成private static类型
	private static SingletonModel singletonModel1 = new SingletonModel();

	// 定义一个静态方法返回该实例
	public static SingletonModel getInstance1()
	{
		return singletonModel1;
	}

	// 2.懒汉模式：在需要实例的时候去创建,再次获取的时候就不会重新创建，但是在多线程并发中会创建多个实例
	// 因此需要加锁来解决线程同步问题,加锁就实现了延迟加载，效率降低了
	private static SingletonModel singletonModel2 = null;

	public static synchronized SingletonModel getInstance2()
	{
		if (singletonModel2 == null)
		{
			singletonModel2 = new SingletonModel();
		}
		return singletonModel2;
	}

	// 3.双重校验锁:在同步代码快执行之前加一层对象是否为空的判断，当没有对象的时候，在执行同步代码块，创建对象
	// volatile:禁止代码指令重排序优化，保证对象被赋值的时候已经是初始化过的
	private static volatile SingletonModel singletonModel3 = null;

	public static SingletonModel getInstance3()
	{
		// 在同步代码块前面加一层对象非空判断
		if (singletonModel3 == null)
		{
			synchronized (SingletonModel.class)
			{
				if (singletonModel3 == null)
				{
					singletonModel3 = new SingletonModel();
				}
			}
		}
		return singletonModel3;
	}

	// 4.静态内部类实现单例:利用类加载机制来创建实例，在内部类中创建实例，只要不使用内部类，
	// jvm就不会加载这个实例,同时保证了线程安全和延迟加载
	private static class SingletonModelHandler
	{
		public static SingletonModel singletonModel4 = new SingletonModel();

		public static SingletonModel newInstance()
		{
			return SingletonModelHandler.singletonModel4;
		}
	}

	public static void main(String args[])
	{
		SingletonModel s = SingletonModel.SingletonModelHandler.newInstance();
		// ArrayList
	}
}
