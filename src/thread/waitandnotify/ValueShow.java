package thread.waitandnotify;

public class ValueShow
{

	public boolean flag = true;

	public void showA()
	{
		synchronized (this)
		{
			if (flag)
			{
				try
				{
					wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			for (int i = 0; i < 2; i++)
			{
				System.out.println("aaaaaaaaaa");
			}
			flag = true;
			notify();
		}

	}

	public void showB()
	{
		synchronized (this)
		{
			if (!flag)
			{
				try
				{
					wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			}
			for (int i = 0; i < 2; i++)
			{
				System.out.println("bbbbbbbbbbbb");
			}
			flag = false;
			notify();

		}

	}

	public static void main(String[] args)
	{
		ValueShow vs = new ValueShow();
		for (int i = 0; i < 5; i++)
		{
			BackAThread bat = new BackAThread(vs);
			bat.start();
			BackBThread bbt = new BackBThread(vs);
			bbt.start();
		}
	}

}

class BackAThread extends Thread
{
	ValueShow vs;

	BackAThread(ValueShow vs)
	{
		this.vs = vs;
	}

	@Override
	public void run()
	{
		vs.showA();
	}
}

class BackBThread extends Thread
{
	ValueShow vs;

	BackBThread(ValueShow vs)
	{
		this.vs = vs;
	}

	@Override
	public void run()
	{
		vs.showB();
	}
}
