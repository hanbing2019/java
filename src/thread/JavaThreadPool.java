package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaThreadPool
{

	public static void main(String[] args)
	{
		// ����һ�������ù̶��߳������̳߳�
		ExecutorService pool = Executors.newFixedThreadPool(5);
		// ����ʵ����Runnable�ӿڶ���Thread����ȻҲʵ����Runnable�ӿ�
		Thread t1 = new MyThread1();
		Thread t2 = new MyThread1();
		Thread t3 = new MyThread1();
		Thread t4 = new MyThread1();
		Thread t5 = new MyThread1();
		// ���̷߳�����н���ִ��
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.execute(t4);
		pool.execute(t5);

		// �ر��̳߳�
		pool.shutdown();
	}
}

class MyThread1 extends Thread
{
	@Override
	public void run()
	{
		System.out.println(Thread.currentThread().getName() + "����ִ�С� ��");
	}
}
