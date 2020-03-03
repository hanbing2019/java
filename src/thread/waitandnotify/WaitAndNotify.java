package thread.waitandnotify;

import java.util.ArrayList;
import java.util.List;

public class WaitAndNotify
{
	public static void main(String args[]) throws InterruptedException
	{
		Object lock = new Object();

		// ThreadA a = new ThreadA(lock);
		// a.setName("a");
		// a.start();
		// Thread.sleep(3000);
		// ThreadB b = new ThreadB(lock);
		// b.setName("b");
		// b.start();
		WaitThread wt = new WaitThread(lock);
		wt.setName("wt");
		wt.start();
		NotifyThread nt = new NotifyThread(lock);
		nt.setName("nt");
		nt.start();
	}
}

class ThreadA extends Thread
{
	Object lock;

	ThreadA(Object lock)
	{
		this.lock = lock;
	}

	@Override
	public void run()
	{
		synchronized (lock)
		{
			System.out.println(Thread.currentThread().getName() + " wait");
			try
			{
				lock.wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " notified");
		}
	}
}

class ThreadB extends Thread
{
	Object lock;

	ThreadB(Object lock)
	{
		this.lock = lock;
	}

	@Override
	public void run()
	{
		synchronized (lock)
		{
			System.out.println(Thread.currentThread().getName() + " notify");
			lock.notify();
			System.out.println(Thread.currentThread().getName() + " notify ok");
		}
	}
}

class MyList
{
	public static List<String> list = new ArrayList<String>();

	public static void add()
	{
		list.add("addinfo");
	}

	public static int getSize()
	{
		return list.size();
	}
}

class WaitThread extends Thread
{
	Object lock;

	WaitThread(Object lock)
	{
		this.lock = lock;
	}

	@Override
	public void run()
	{
		synchronized (lock)
		{
			if (MyList.getSize() != 5)
			{
				System.out.println(Thread.currentThread().getName() + " wait");
				try
				{
					lock.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()
						+ " notified");
			}

		}

	}
}

class NotifyThread extends Thread
{
	Object lock;

	NotifyThread(Object lock)
	{
		this.lock = lock;
	}

	@Override
	public void run()
	{
		synchronized (lock)
		{
			for (int i = 0; i < 10; i++)
			{
				MyList.add();
				if (MyList.getSize() == 5)
				{
					System.out.println(Thread.currentThread().getName()
							+ " notify");
					lock.notify();
					//
					System.out
							.println("发起了唤醒，但是当前线程任然占用对象锁，被唤起的线程进入等待队列，进入可运行状态");
					System.out.println(Thread.currentThread().getName()
							+ " notify ok");
				}
				try
				{
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		}

	}
}
