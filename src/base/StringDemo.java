package base;

import java.util.ArrayList;

public class StringDemo
{

	public static void main(String[] args)
	{
		String a = "asesss";
		// a.charAt(index)
		Object object = new Object();
		object.notify();

		ArrayList<?> al;
		StringBuilder sb = new StringBuilder();
		StringBuffer sbuffer = new StringBuffer();
		System.out.println(a.indexOf("e"));
		a.indexOf("e");// �����Զ��ַ�������ʼλ�ã����û�и��ַ�������ô����-1
		// a.substring(beginIndex)��beginIndexλ������ʼ��ȡ����ȡ��beginIndex(����beginIndexΪ)֮��������ַ�������
		// a.substring(beginIndex,
		// endIndex);��beginIndexλ��ʼ��ȡ����ȡ������ΪendIndex-1�����ص��ַ�������ΪbeginIndex-endIndex

	}

	public void f1()
	{
		String a = "a";
		String result = new StringBuilder().append(a).append("b").append("c")
				.append("d").toString();
		String result1 = a + "b" + "c" + "d";
		System.out.println(result);
	}

	public void f2()
	{
		String a = "a" + "b" + "c";
		System.out.println(a);
	}

	public void f3(String[] args)
	{
		String result = "";
		for (int i = 0; i < args.length; i++)
		{
			result += args[i];
		}
	}

	public void f4()
	{
		String result = "";
		for (int i = 0; i < 4; i++)
		{
			result += "a";
		}
	}
}
