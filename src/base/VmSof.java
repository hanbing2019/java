package base;

public class VmSof
{

	public void func()
	{
		func();
	}

	public static void main(String[] args)
	{
		VmSof v = new VmSof();
		try
		{
			v.func();
		} catch (Throwable e)
		{
			throw e;
		}
	}
}
