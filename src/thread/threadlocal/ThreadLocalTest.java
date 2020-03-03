package thread.threadlocal;

public class ThreadLocalTest
{
	// 类threadlocal主要作用，让每个线程绑定自己的值
	public static ThreadLocal t = new ThreadLocalEx();

	// 子线程中获取父线程的绑定值
	public static InheritableThreadLocal it = new InheritableThreadLocal();

	public static void main(String args[])
	{
		it.set("main value");
		ThreadA a = new ThreadA();
		// ThreadB b = new ThreadB();
		a.start();
		// b.start();
		System.out.println(t.get());

	}
}

class ThreadA extends Thread
{
	public void run()
	{
		System.out.println(ThreadLocalTest.it.get());
		for (int i = 0; i < 10; i++)
		{
			Thread.currentThread().setName("ThreadA");
			ThreadLocalTest.t.set(Thread.currentThread().getName() + " value "
					+ i);
			System.out.println(ThreadLocalTest.t.get());
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class ThreadB extends Thread
{
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			Thread.currentThread().setName("ThreadB");
			ThreadLocalTest.t.set(Thread.currentThread().getName() + " value "
					+ i);
			System.out.println(ThreadLocalTest.t.get());
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
