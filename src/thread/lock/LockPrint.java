package thread.lock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPrint
{
	Lock lock = new ReentrantLock();
	Condition c = lock.newCondition();

	boolean flag = true;

	public void showA()
	{
		try
		{
			lock.lock();
			while (flag)
			{
				c.await();
			}
			System.out.println("print a");
			flag = true;
			// c.signal();唤醒一个
			c.signalAll();// 唤醒所有

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			lock.unlock();
		}
	}

	public void showB()
	{
		try
		{
			lock.lock();
			while (!flag)
			{
				c.await();
			}
			flag = false;
			System.out.println("print B");
			// 唤醒
			// c.signal();
			c.signalAll();

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{
			lock.unlock();
		}
	}

	public static void main(String args[]) throws ParseException
	{
		LockPrint lp = new LockPrint();

		// 多通知等待打印
		// Thread[] athread = new Thread[5];
		// Thread[] bthread = new Thread[5];
		// PrintAThread pats = new PrintAThread(lp);
		// PrintBThread pbts = new PrintBThread(lp);
		// for (int i = 0; i < 5; i++)
		// {
		// athread[i] = new Thread(pats);
		// athread[i].start();
		// bthread[i] = new Thread(pbts);
		// bthread[i].start();
		// }
		// PrintAThread pat = new PrintAThread(lp);
		// pat.start();
		// PrintBThread pbt = new PrintBThread(lp);
		// pbt.start();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse("2018-05-28 09:14:00");
		Timer timer = new Timer();
		timer.schedule(new MyTime(), date, 4000);

	}
}

class PrintAThread extends Thread
{
	LockPrint lp;

	PrintAThread(LockPrint lp)
	{
		this.lp = lp;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			lp.showA();
		}

	}
}

class PrintBThread extends Thread
{
	LockPrint lp;

	PrintBThread(LockPrint lp)
	{
		this.lp = lp;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			lp.showB();
		}

	}
}

class MyTime extends TimerTask
{
	@Override
	public void run()
	{
		System.out.println("--------ff--------");
	}

}
