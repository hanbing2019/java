package spring.di;

public class DIDemo
{
	private IDemo iDemo;

	// 在构造器中传入对象
	DIDemo(IDemo iDemo)
	{
		this.iDemo = iDemo;
	}

	public void run()
	{
		iDemo.function();
	}

}
