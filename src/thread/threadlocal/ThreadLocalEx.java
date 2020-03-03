package thread.threadlocal;

public class ThreadLocalEx extends ThreadLocal
{
	@Override
	protected Object initialValue()
	{
		return "init";
	}
}
