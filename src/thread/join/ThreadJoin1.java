package thread.join;

public class ThreadJoin1 extends Thread
{
	@Override
	public void run()
	{
		System.out.println("1 start");
		ThreadJoin2 t2 = new ThreadJoin2();
		t2.start();
		try
		{
			t2.join();
			// this.join();
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("1 end");
	}

	public static void main(String[] args) throws InterruptedException
	{
		ThreadJoin1 t1 = new ThreadJoin1();
		t1.start();
	}

}

class ThreadJoin2 extends Thread
{
	@Override
	public void run()
	{
		System.out.println("2 start");

		ThreadJoin3 t3 = new ThreadJoin3();
		t3.start();
		try
		{
			t3.join();
			// this.join();
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("2 end");
	}
}

class ThreadJoin3 extends Thread
{
	@Override
	public void run()
	{
		System.out.println("3 start");

		try
		{
			Thread.sleep(5000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("3 end");
	}
}