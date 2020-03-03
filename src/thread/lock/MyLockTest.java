package thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class MyLockTest
{

	public static void main(String[] args)
	{

		CountDownLatch sd;
		CyclicBarrier d;

		Executors.newSingleThreadScheduledExecutor();
	}
}

class ThreadDemo extends Thread
{
	AutoAdd aa;
	CountDownLatch dd;

	ThreadDemo(AutoAdd num, CountDownLatch dd)
	{
		this.aa = num;
		this.dd = dd;
	}

	public void run()
	{
		try
		{
			dd.await();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		aa.add();
	}
}

class AutoAdd
{
	int num;

	MyLock ml = new MyLock();

	AutoAdd(int num)
	{
		this.num = num;
	}

	public void add()
	{
		ml.lock();
		num++;
		System.out.println(num);
		ml.unlock();
	}
}
