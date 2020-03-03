package spring.config;

public class DiInfo
{
	ComInterImpl comInterImpl;

	public void setComInterImpl(ComInterImpl comInterImpl)
	{
		this.comInterImpl = comInterImpl;
	}

	public void test()
	{
		comInterImpl.func1();
	}

}
