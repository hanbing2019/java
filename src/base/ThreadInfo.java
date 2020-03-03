package base;

/**
 * �����ֳ��ķ�����1�̳�Thread�࣬2ʵ��Runnable�ӿ�
 * 
 * ��дrun����ʵ��ҵ�����
 * 
 * �����ֳ�����Thread���start()����������ֱ�ӵ���run����
 * 
 * @author Administrator
 * 
 */

public class ThreadInfo extends Thread
{
	// ��дrun����
	public void run()
	{
		System.out.println("d");
		// �ж��߳��Ƿ��жϣ�Thread.interrupted()����true�߳��ж�;
		// �ж��߳��ж�һ����run()�����У����߳��жϺ�ִ����������
		// System.out.println(new Date());
	}

	public static void main(String args[])
	{
		// �̵߳�״̬
		// �½�NEW��������RUNNABLE������ֵBLOCKED���ȴ�WAITING����ʱ�ȴ�TIMED_WAITING������ֹTERMINATED
		// �������߳̿������������У�����û������
		// �߳���������ʹ�ù�ͬ�����ݣ��������Ƕ��������������߳�ʹ�ã�
		// ��ô���߳̽�������״ֱ̬����һ���߳�ʹ����

		// ThreadInfo ti = new ThreadInfo();
		RunnableInfo ri = new RunnableInfo();
		for (int a = 1; a < 10; a++)
		{
			Thread thread1 = new Thread(ri);
			System.out.println(Thread.activeCount());
			thread1.start();
		}
		// Thread thread = new Thread(ti);
		// thread.getState()��ȡ�߳�״̬��NEW RUNNABLE BlOCKED WAITING TIMED_WAITING
		// thread.stop();ֹͣ�̣߳����ǹ�ȥʱ����
		// thread.suspend();��ͣ�̣߳����ǹ�ȥʱ����
		// thread.resume();�ָ���ͣ�ķ��� ʹ����suspend()��������

		// thread.setPriority(newPriority);// �����߳����ȼ�
		// Thread.MAX_PRIORITY;������ȼ� 10
		// thread.MIN_PRIORITY;��С���ȼ� 1
		// thread.NORM_PRIORITY;Ĭ�����ȼ�5

		// System.out.println(thread.getState());

		// thread.setDaemon(true);// �ػ��̣߳�Ϊ�����߳��ṩ���񣬱���ػ��̣߳��������߳�����֮ǰʹ��
		// �����߳�
		// thread.start();
		// System.out.println(thread.getState());

		// �ж��߳�ʹ��interrupt()����
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
			System.out.println(Thread.currentThread().getName() + "��Ʒ�������Ժ�����");
			return;
		}
		this.product++;
		System.out.println(Thread.currentThread().getName() + "������������"
				+ this.product + "����Ʒ");
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
						+ "��Ʒ������������ͣ����");
			} catch (Exception e)
			{
				e.printStackTrace();
			}
			return;
		}
		this.product--;
		System.out.println(Thread.currentThread().getName() + "��ʣ��Ʒ��"
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
