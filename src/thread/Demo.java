package thread;

import java.util.concurrent.locks.ReentrantLock;

public class Demo implements Runnable
{

	public static void main(String[] args) throws InterruptedException
	{
		Demo d = new Demo();
		Thread t = new Thread(d);
		t.start();

		Thread.sleep(200);
		t.interrupt();

		ReentrantLock rt;
	}

	@Override
	public void run()
	{
		System.out.println("kaishi sleep");
		try
		{
			Thread.sleep(2000000);
		} catch (InterruptedException e)
		{
			throw new RuntimeException("err");
		}
		System.out.println("sleep over");
		for (int i = 0; i < 10000; i++)
		{
			System.out.println("" + i);
		}

	}

}
