package spring.di;

public class DIDemo
{
	private IDemo iDemo;

	// �ڹ������д������
	DIDemo(IDemo iDemo)
	{
		this.iDemo = iDemo;
	}

	public void run()
	{
		iDemo.function();
	}

}
