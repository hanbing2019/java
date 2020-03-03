package thread.waitandnotify;

import java.util.ArrayList;
import java.util.List;

public class ValueStack
{
	private List<String> list = new ArrayList<String>();

	public List<String> getList()
	{
		return list;
	}

	public void setList(List<String> list)
	{
		this.list = list;
	}

	public int getSize()
	{
		return this.list.size();
	}

	synchronized public void push()
	{
		if (list.size() == 1)
		{
			try
			{
				// list中有数据时进入等待
				System.out.println(Thread.currentThread().getName()
						+ " list有数据，等待");
				this.wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		}
		list.add(System.currentTimeMillis() + Thread.currentThread().getName());
		// 唤醒pop
		System.out.println(Thread.currentThread().getName() + " 唤醒清除list线程");
		this.notify();

	}

	synchronized public void pop()
	{
		while (list.size() == 0)
		{
			try
			{
				System.out.println(Thread.currentThread().getName()
						+ " list中没有数据，进入等待");
				this.wait();
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		list.remove(0);
		System.out
				.println(Thread.currentThread().getName() + " 清除了list，唤醒push");
		this.notifyAll();

	}

	public static void main(String[] args)
	{
		ValueStack vs = new ValueStack();
		ThreadPush tpush = new ThreadPush(vs);
		ThreadPop tpop = new ThreadPop(vs);
		ThreadPop tpop1 = new ThreadPop(vs);
		ThreadPop tpop2 = new ThreadPop(vs);
		ThreadPop tpop3 = new ThreadPop(vs);
		ThreadPop tpop4 = new ThreadPop(vs);
		ThreadPop tpop5 = new ThreadPop(vs);

		tpush.setName("push");
		tpop.setName("pop");
		tpop1.setName("pop1");
		tpop2.setName("pop2");
		tpop3.setName("pop3");
		tpop4.setName("pop4");
		tpop5.setName("pop5");
		tpush.start();
		tpop.start();
		tpop1.start();
		tpop2.start();
		tpop3.start();
		tpop4.start();
		tpop5.start();

	}

}

class ThreadPush extends Thread
{

	ValueStack vs;

	ThreadPush(ValueStack vs)
	{
		this.vs = vs;
	}

	@Override
	public void run()
	{
		while (true)
		{
			vs.push();
		}
	}
}

class ThreadPop extends Thread
{

	ValueStack vs;

	ThreadPop(ValueStack vs)
	{
		this.vs = vs;
	}

	@Override
	public void run()
	{
		while (true)
		{
			vs.pop();
		}
	}
}
