package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest
{
	public static void main(String args[])
	{
		LockServer ls = new LockServer();

		LockThread1 lt1 = new LockThread1(ls);
		LockThread2 lt2 = new LockThread2(ls);
		lt2.start();
		lt1.start();

		/*
		 * LockThread l1 = new LockThread(ls); LockThread l2 = new
		 * LockThread(ls); LockThread l3 = new LockThread(ls); l1.setName("l1");
		 * l2.setName("l2"); l3.setName("l3"); l1.start(); l2.start();
		 * l3.start();
		 */
	}
}

class LockServer
{
	Lock lock = new ReentrantLock();
	int a = 100;

	public void run()
	{
		lock.lock();
		for (int i = 0; i < 5; i++)
		{
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
		System.out.println("-----------------------");
		try
		{
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		lock.unlock();
	}

	public void method1()
	{
		lock.lock();
		for (int i = 0; i < 10; i++)
		{
			a++;
			System.out.println("+++++++");
		}
		System.out.println("a = " + a);
		lock.unlock();
	}

	public void method2()
	{
		lock.lock();
		for (int i = 0; i < 10; i++)
		{
			a = a - 2;
			System.out.println("------");
		}
		System.out.println("a = " + a);
		lock.unlock();
	}
}

class LockThread extends Thread
{
	LockServer ls;

	LockThread(LockServer ls)
	{
		this.ls = ls;
	}

	public void run()
	{
		ls.run();
	}
}

class LockThread1 extends Thread
{
	LockServer ls;

	LockThread1(LockServer ls)
	{
		this.ls = ls;
	}

	public void run()
	{
		ls.method1();
	}
}

class LockThread2 extends Thread
{
	LockServer ls;

	LockThread2(LockServer ls)
	{
		this.ls = ls;
	}

	public void run()
	{
		ls.method2();
	}
}
