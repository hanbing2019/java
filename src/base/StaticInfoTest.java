package base;

public class StaticInfoTest
{
	public void f1()
	{
		System.out.println("f1");
		f2();
	}

	public static void f2()
	{
	}

	public static void main(String[] args)
	{

		/*
		 * System.out.println("����һ�������"); StaticInfo s;
		 * System.out.println("--------����ʵ��"); s = new StaticInfo();
		 */
		/*
		 * System.gc(); System.out.println(Runtime.getRuntime().maxMemory() /
		 * 1024 / 1024); System.out.println(Runtime.getRuntime().totalMemory() /
		 * 1024 / 1024); System.out.println(StaticInfo.infoFunc());
		 */
		byte b[] = null;
		for (int i = 0; i < 10; i++)
		{
			b = new byte[1 * 1024 * 1024];
		}
	}
}
