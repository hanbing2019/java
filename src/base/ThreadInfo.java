package base;

/**
 * 创建现场的方法：1继承Thread类，2实现Runnable接口
 * 
 * 重写run方法实现业务操作
 * 
 * 启动现场调用Thread类的start()方法而不是直接调用run方法
 * 
 * @author Administrator
 * 
 */

public class ThreadInfo extends Thread
{
	// 重写run方法
	public void run()
	{
		System.out.println("d");
		// 判读线程是否中断，Thread.interrupted()返回true线程中断;
		// 判断线程中断一般在run()方法中，当线程中断后执行其他操作
		// System.out.println(new Date());
	}

	public static void main(String args[])
	{
		// 线程的状态
		// 新建NEW，可运行RUNNABLE，被阻值BLOCKED，等待WAITING，计时等待TIMED_WAITING，被终止TERMINATED
		// 可运行线程可能是正在运行，或者没有运行
		// 线程阻塞：当使用共同的数据，该数据是对象锁，被其他线程使用，
		// 那么该线程进入阻塞状态直到另一个线程使用完

		// ThreadInfo ti = new ThreadInfo();
		RunnableInfo ri = new RunnableInfo();
		for (int a = 1; a < 10; a++)
		{
			Thread thread1 = new Thread(ri);
			System.out.println(Thread.activeCount());
			thread1.start();
		}
		// Thread thread = new Thread(ti);
		// thread.getState()获取线程状态：NEW RUNNABLE BlOCKED WAITING TIMED_WAITING
		// thread.stop();停止线程，已是过去时方法
		// thread.suspend();暂停线程，已是过去时方法
		// thread.resume();恢复暂停的方法 使用在suspend()方法后面

		// thread.setPriority(newPriority);// 设置线程优先级
		// Thread.MAX_PRIORITY;最大优先级 10
		// thread.MIN_PRIORITY;最小优先级 1
		// thread.NORM_PRIORITY;默认优先级5

		// System.out.println(thread.getState());

		// thread.setDaemon(true);// 守护线程：为其他线程提供服务，标记守护线程，必须在线程启动之前使用
		// 启动线程
		// thread.start();
		// System.out.println(thread.getState());

		// 中断线程使用interrupt()方法
		// thread.interrupt();

	}
}

class RunnableInfo implements Runnable
{
	int a = 100;

	@Override
	public void run()
	{
		deleteNum();
		System.out.println(a);

		// System.out.println("ds");
	}

	public void deleteNum()
	{
		a = a - 1;
		try
		{
			// wait();
			Thread.sleep(2000);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

class Synchr implements Runnable
{
	int product = 1;

	int MAX_PRODUCT = 30;
	int WARN_LINE = 10;

	public synchronized void produce()
	{
		if (this.product >= MAX_PRODUCT)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "产品已满，稍后生产");
			return;
		}
		this.product++;
		System.out.println(Thread.currentThread().getName() + "生产者生产地"
				+ this.product + "个产品");
		notifyAll();
	}

	public synchronized void customer()
	{
		if (this.product < WARN_LINE)
		{
			try
			{
				wait();
				System.out.println(Thread.currentThread().getName()
						+ "产品数量不够，暂停销售");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return;
		}
		this.product--;
		System.out.println(Thread.currentThread().getName() + "还剩产品量"
				+ this.product);
		notifyAll();
	}

	@Override
	public void run()
	{
		produce();
		customer();
	}

	public static void main(String args[])
	{
		Synchr s = new Synchr();
		for (int i = 0; i < 30; i++)
		{
			Thread t = new Thread(s);
			t.setName("i= " + i);
			t.start();
		}

	}
}
