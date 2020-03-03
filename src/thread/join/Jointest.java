package thread.join;

public class Jointest
{
	public static void main(String args[]) throws InterruptedException
	{
		ThreadA ta = new ThreadA();
		ta.start();
		ta.join();// һֱ�ȵ����߳�ִ�н���
		// ta.join(2000);�ȴ�2��
		System.out.println("���߳�");
	}
}

class ThreadA extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + " wait");
		Tool.tl.set("tom");
		try
		{
			Thread.sleep(10000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(Tool.tl.get());
		System.out.println(Thread.currentThread().getName() + " release");

	}
}

class Tool
{
	protected static ThreadLocal tl = new ThreadLocal();

	public void func()
	{
		tl.set("value");
	}
}
