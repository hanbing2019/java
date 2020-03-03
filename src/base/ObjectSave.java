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
		System.out.println("----------��ʼ�Ծ�----------");
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
		System.out.println("-------�ٴλ���------");
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
			System.out.println("--�Ȳ�����--");
		}
	}
}
