package base;

public class ObjectSave
{

	static ObjectSave os = null;

	String a = "a";

	/**
	 * @return the os
	 */
	public ObjectSave getOs()
	{
		return os;
	}

	/**
	 * @param os
	 *            the os to set
	 */
	public void setOs(ObjectSave os)
	{
		this.os = os;
	}

	@Override
	protected void finalize()
	{
		System.out.println("----------开始自救----------");
		os = this;
	}

	public static void main(String[] args)
	{
		os = new ObjectSave();
		os = null;
		System.gc();

		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		if (os != null)
		{
			System.out.println(os.a);
		}
		os = null;
		System.out.println("-------再次回收------");
		System.gc();
		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		if (os != null)
		{
			System.out.println(os.a);
		} else
		{
			System.out.println("--救不了了--");
		}
	}
}
