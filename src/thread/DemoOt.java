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
		System.out.println("��ǰʱ�䣺" + current);

		long future = current + mills;
		long remaining = mills;
		while (remaining > 0)
		{
			Thread.sleep(mills);
			// wait(mills);

			remaining = future - System.currentTimeMillis();
		}

		System.out.println("�ȴ�֮��" + System.currentTimeMillis());

	}

}
