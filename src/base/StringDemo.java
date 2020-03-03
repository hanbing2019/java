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
		a.indexOf("e");// 返回自定字符串的起始位置，如果没有改字符串，那么返回-1
		// a.substring(beginIndex)从beginIndex位索引开始截取，截取从beginIndex(包括beginIndex为)之后的所有字符并返回
		// a.substring(beginIndex,
		// endIndex);从beginIndex位开始截取，截取到索引为endIndex-1，返回的字符串长度为beginIndex-endIndex

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
