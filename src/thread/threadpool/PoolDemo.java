package thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PoolDemo
{

	public static void main(String[] args) throws InterruptedException,
			ExecutionException
	{
		int corePoolSize = 1;
		int maximumPoolSize = 2;
		long keepAliveTime = 2;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(16);
		ThreadPoolExecutor tpe = new ThreadPoolExecutor(corePoolSize,
				maximumPoolSize, keepAliveTime, unit, workQueue);
		ReentrantLock rc = new ReentrantLock();
		rc.unlock();
		Runnable command = new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					Thread.sleep(1000);
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("runnable");
			}
		};

		CallerRunsPolicy d;// 只用调用者所在的线程来运行任务
		DiscardOldestPolicy s;// 丢弃队列中的最近一个任务，并执行当前任务
		DiscardPolicy p;// 不处理，不丢弃
		// Future<String> ss = tpe.submit(command, "tom");
		// System.out.println(ss.get());
		// tpe.execute(command);
		// tpe.shutdown();
		// tpe.shutdownNow();

		// 使用Executors创建线程池
		Executors.newFixedThreadPool(2);
		Executors.newCachedThreadPool();// ThreadPoolExecutor
		Executors.newSingleThreadExecutor();// FinalizableDelegatedExecutorService->
											// ThreadPoolExecutor
		Executors.newScheduledThreadPool(corePoolSize);
		Executors.newSingleThreadScheduledExecutor();// ThreadPoolExecutor
		tpe.isTerminated();
		int COUNT_BITS = Integer.SIZE - 3;
		int CAPACITY = (1 << COUNT_BITS) - 1;
		int RUNNING = -1 << COUNT_BITS;
		// int STOP = 1 << COUNT_BITS;
		// int TIDYING = 2 << COUNT_BITS;
		// int TERMINATED = 3 << COUNT_BITS;

		// System.out.println(CAPACITY);
		//
		// System.out.println(RUNNING);
		//
		// System.out.println(STOP);
		// System.out.println(TIDYING);
		// System.out.println(TERMINATED);

		// 0000 0000 0000 0000 0000 0000 0000 0001
		// 1000 0000 0000 0000 0000 0000 0000 0001
		// 1010 0000 0000 0000 0000 0000 0000 0000

		// 1101 1111 1111 1111 1111 1111 1111 1111 -1

		// 1111 1111 1111 1111 1111 1111 1111 1111

		// 1110 0000 0000 0000 0000 0000 0000 0000

		// System.out.println(Integer.toBinaryString(-1));

		// System.out.println(RUNNING);
		// AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));

		// System.out.println(ctl.get());
		// System.out.println(Integer.toBinaryString(-536870912));
		// 11100000000000000000000000000000
		// ( 当前状态为SHUTDOWN、 && 且传入的任务为null， && 且队列不为null ) -->false
		// 都满足返回true,其中一个不满足就返回false

		// rs != SHUTDOWN || firstTask != null || workQueue.isEmpty()

		ThreadDemo tt = new ThreadDemo();
		tt.start();

		// Future<String> f;
		// FutureTask<String> ft = new FutureTask<>(command, "tom");
		// ft.run();
		// System.out.println(ft.get());
		Callable<String> callable = new Callable<String>()
		{

			@Override
			public String call() throws Exception
			{
				return "20202";
			}
		};
		// Future<String> rf = tpe.submit(callable);
		// System.out.println(rf.get());
	}

	private static int ctlOf(int rs, int wc)
	{
		return rs | wc;
	}
}

class ClassTest
{
	String str = new String("hello");
	char[] ch =
	{ 'a', 'b', 'c' };

	public void fun(String str, char ch[])
	{
		str = "world";
		ch[0] = 'd';
	}
}

class ThreadDemo extends Thread
{

	public void run()
	{
		System.out.println("--启动线程--");
		for (int i = 0; i < 100000; i++)
		{
			if (i > 50000 && !this.isInterrupted())
			{
				System.out.println(Thread.interrupted());
				System.out.println("中断" + i);
				this.interrupt();
				// this.isInterrupted();
				// this.interrupted();

			}
			System.out.println("执行" + i);

		}
	}
}

class ThreadDemo1 extends Thread
{

	public void run()
	{
		System.out.println("--启动线程1--");
		for (int i = 0; i < 100000000; i++)
		{
			if (i > 50000000)
			{
				System.out.println("中断" + i);
				// this.isInterrupted();
				// this.interrupted();

			}

		}
	}
}
