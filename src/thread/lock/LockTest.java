package thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest
{
	/**
	 * ReentrantLockʵ���߳�ͬ��
	 */
	Lock lock = new ReentrantLock();// ��

	Condition c = lock.newCondition();
	int a = 100;

	// ����ʵ���̵߳ȴ�
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

	// ���ڻ����߳�
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

		// corePoolSize���̳߳صĻ�����С������ʱ����С�߳�����
		// maximumPoolSize���̳߳����������������߳���
		// keepAliveTime�������߳̿��к󣬱��ִ���ʱ��
		// unit�����ʱ��ĵ�λ
		// workQueue ��ŵ��������
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
