package thread;

import java.io.IOException;

public class MyThread
{
	static String value = "";
	static boolean flag = true;

	public static void main(String[] args) throws InterruptedException,
			IOException
	{
		Object obj = new Object();
		BackUpA ba = new BackUpA(obj);
		BackUpB bb = new BackUpB(obj);
		Thread[] threadsa = new Thread[20];
		Thread[] threadsb = new Thread[20];
		for (int i = 0; i < 20; i++)
		{
			threadsa[i] = new Thread(new ThreadA(ba));
			threadsb[i] = new Thread(new ThreadB(bb));
			threadsa[i].start();
			threadsb[i].start();
		}
	}
}

class BackUpA
{
	Object obj;

	BackUpA(Object obj)
	{
		this.obj = obj;
	}

	public void ba()
	{
		synchronized (obj)
		{
			while (MyThread.flag == true)
			{
				try
				{
					obj.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 5; i++)
			{
				System.out.println("aaaaaaa");
			}

			MyThread.flag = true;
			obj.notifyAll();
		}
	}
}

class BackUpB
{
	Object obj;

	BackUpB(Object obj)
	{
		this.obj = obj;
	}

	public void bb()
	{
		synchronized (obj)
		{
			while (MyThread.flag == false)
			{
				try
				{
					obj.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 5; i++)
			{
				System.out.println("bbbbbbb");
			}

			MyThread.flag = false;
			obj.notifyAll();
		}
	}
}

class ThreadA extends Thread
{
	BackUpA ba;

	ThreadA(BackUpA ba)
	{
		this.ba = ba;
	}

	public void run()
	{
		ba.ba();
	}
}

class ThreadB extends Thread
{
	BackUpB bb;

	ThreadB(BackUpB bb)
	{
		this.bb = bb;
	}

	public void run()
	{
		bb.bb();
	}
}