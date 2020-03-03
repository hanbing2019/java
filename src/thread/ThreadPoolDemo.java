package thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo implements ThreadPool<Runnable>
{

	private static final int init_work_size = 2;

	private static final int max_work_size = 5;
	// 任务队列
	LinkedList<Runnable> jobList = new LinkedList<Runnable>();

	// 工作线程
	List<Worker> workers = Collections
			.synchronizedList(new ArrayList<Worker>());

	public ThreadPoolDemo()
	{
		initWork(init_work_size);
	}

	@Override
	public void execute(Runnable job)
	{
		// 向任务队列中添加
		synchronized (jobList)
		{
			jobList.add(job);
			jobList.notifyAll();
		}

	}

	@Override
	public void addWorker(int num)
	{
		if (max_work_size < num)
		{
			num = max_work_size;
		}

		if (init_work_size < num)
		{
			initWork(num - init_work_size);
		}
	}

	// 初始化工作线程
	void initWork(int num)
	{
		for (int i = 0; i < num; i++)
		{
			Worker w = new Worker();
			Thread thread = new Thread(w, "work - thread -"
					+ System.currentTimeMillis());
			thread.start();
			workers.add(w);
		}

	}

	@Override
	public void shutdown()
	{
		for (Worker worker : workers)
		{
			worker.shutdown();
		}

	}

	@Override
	public void removeWorker(int num)
	{
		if (num >= workers.size())
		{
			// 数量超过不能操作
			return;
		}
		synchronized (workers)
		{
			int index = 0;
			while (workers.size() > 0)
			{

				Worker w = workers.get(index);
				w.shutdown();
				workers.remove(w);
				index++;
			}

		}

	}

	@Override
	public int getJobSize()
	{
		return jobList.size();
	}

	private class Worker implements Runnable
	{

		private boolean running = true;

		@Override
		public void run()
		{
			while (running)
			{
				Runnable job = null;
				synchronized (jobList)
				{
					// 任务队列为空就等待
					while (jobList.isEmpty())
					{
						try
						{
							jobList.wait();
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}
					job = jobList.removeFirst();
				}
				if (job != null)
				{
					job.run();
				}
			}

		}

		public void shutdown()
		{
			ReentrantLock lock = new ReentrantLock();
			lock.lock();
			lock.unlock();
			running = false;
		}

	}

	public static void main(String[] args) throws InterruptedException
	{
		long lastTime = System.nanoTime();

		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());

		// 0x0000FFFF -->>65535
		// 低16位为1： 0000 0000 0000 0000 1111 1111 1111 1111
		System.out.println(0x0000FFFF);
		System.out.println(Integer.toBinaryString(65535));
		ReentrantLock l = new ReentrantLock();
		Condition c = l.newCondition();
		c.await();
		c.signal();
		// 0000 0000 0000 0000 0000 0000 0000 0001
		// 0000 0000 0000 0001 0000 0000 0000 0000
		// 0000 0000 0000 0000 1111 1111 1111 1111
		System.out.println((1 << 16) - 1);

	}
}
