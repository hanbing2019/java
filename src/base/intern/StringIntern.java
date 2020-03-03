package base.intern;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class StringIntern
{
	byte a;
	short b;
	int c;
	long d;
	char e;
	boolean f;
	float g;
	double h;

	void f()
	{

	}

	public static void main(String[] args)
	{
		// P.fun();
		StringIntern ss = new StringIntern();
		StringIntern s = new StringIntern();
		ReferenceQueue<StringIntern> q = new ReferenceQueue<>();
		PhantomReference<StringIntern> p = new PhantomReference<StringIntern>(
				s, q);
		s = null;
		System.gc();
		System.out.println("----");
		System.out.println(p.isEnqueued());
	}

	public void fe()
	{
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
	}

	public static void f1()
	{
		String s = new String("1");// 生成常量池中的"1"和堆空间中的字符串对象
		String b = s.intern();//
		String s2 = "1";
		System.out.println(s2 == b);
		System.out.println(s == s2);

		System.out.println("---------------------");

		String s3 = new String("1") + new String("1");
		String a = s3.intern();
		String s4 = "11";
		System.out.println(a == s4);
		System.out.println(s4 == s3);
	}

	public void create()
	{
		String str1 = new String("abc");
		// 用new创建string对象
		// 首先在栈中定义一个str1对象，然后在堆中开辟空间创建对象，将对象地址赋值给str1,
		// "abc"是常量；在常量池中判断是否存在"abc"字符串对象，没有的话分配一个空间存在abc,
		// 并将其"abc"空间的地址存入堆中new出来的空间
		String str2 = "qwe";
		// 至少创建一个或者不创建对象，如果"qwe"这个字符串在,直接将该对象的地址赋给str2，
		// (没有的话就创建一个存放字符串对象的空间，然后把对象地址赋给str2)
	}
}

class P extends StringIntern
{
	int a;
	int b;

	/**
	 * @return the a
	 */
	public int getA()
	{
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(int a)
	{
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public int getB()
	{
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b)
	{
		this.b = b;
	}

	/**
	 * jdk1.7
	 */
	public static void fun()
	{
		String s1 = new StringBuilder().append("计算机").append("软件").toString();
		System.out.println(s1.intern() == s1);

		String s2 = new StringBuilder().append("ja").append("va").toString();
		System.out.println(s2.intern() == s2);

		String s3 = new StringBuilder().append("qwer").append("rtt").toString();
		System.out.println(s3.intern() == s3);
	}

}
