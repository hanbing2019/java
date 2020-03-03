package thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest
{
	public static void fixedThread()
	{
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= 5; i++)
		{
			fixedThreadPool.execute(new Thread(new ThreadInfo(), "name" + i));
		}
	}

	public void catchThread()
	{
		ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
		for (int i = 1; i <= 5; i++)
		{
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			cacheThreadPool.execute(new Thread(new ThreadInfo(), "name" + i));
		}
	}

	public static void main(String[] args)
	{
		fixedThread();
	}
}

class ThreadInfo extends Thread
{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName());
	}
}
