package base;

public class ObjectSaveView
{

	public static void main(String[] args)
	{
		ObjectSave.os = new ObjectSave();
		ObjectSave.os = null;
		System.gc();

		try
		{
			Thread.sleep(500);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		if (ObjectSave.os != null)
		{
			System.out.println(ObjectSave.os.a);
		} else
		{

		}

	}

}
