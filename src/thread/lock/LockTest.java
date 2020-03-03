package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest
{
	/**
	 * ReentrantLock实现线程同步
	 */
	Lock lock = new ReentrantLock();// 锁

	Condition c = lock.newCondition();
	int a = 100;

	// 用于实现线程等待
	public void await()
	{
		lock.lock();
		try
		{
			c.await();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			lock.unlock();
		}

	}

	// 用于唤醒线程
	public void single()
	{
		lock.lock();
		try
		{
			c.signal();
		} finally
		{
			lock.unlock();
		}
	}

	public void test()
	{
		lock.lock();
		a--;
		System.out.println(a);
		lock.unlock();

	}

	public static void main(String[] args) throws InterruptedException
	{
		LockTest lt = new LockTest();
		// for (int i = 0; i < 10; i++)
		// {
		// ThreadLock tl = new ThreadLock(lt);
		// tl.start();
		// }
		WaitThread wt = new WaitThread(lt);
		wt.start();
		System.out.println("wait");
		Thread.sleep(2000);
		lt.single();

		// corePoolSize：线程池的基本大小：空闲时的最小线程数据
		// maximumPoolSize：线程池最大允许创建的最大线程数
		// keepAliveTime：工作线程空闲后，保持存活的时间
		// unit：存活时间的单位
		// workQueue 存放的任务队列
		// new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
		// unit, workQueue)

	}
}

class ThreadLock extends Thread
{
	LockTest lt;

	ThreadLock(LockTest lt)
	{
		this.lt = lt;
	}

	@Override
	public void run()
	{
		lt.test();
	}
}

class WaitThread extends Thread
{
	LockTest lt;

	WaitThread(LockTest lt)
	{
		this.lt = lt;
	}

	@Override
	public void run()
	{
		lt.await();
	}

}
