package thread;

public class DemoOt
{

	public static void main(String[] args) throws InterruptedException
	{
		DemoOt dt = new DemoOt();
		dt.waitSometime(1000);
	}

	public void waitSometime(long mills) throws InterruptedException
	{
		long current = System.currentTimeMillis();
		System.out.println("当前时间：" + current);

		long future = current + mills;
		long remaining = mills;
		while (remaining > 0)
		{
			Thread.sleep(mills);
			// wait(mills);

			remaining = future - System.currentTimeMillis();
		}

		System.out.println("等待之后：" + System.currentTimeMillis());

	}

}
