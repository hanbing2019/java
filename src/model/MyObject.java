package model;

public class MyObject
{
	private static MyObject myObject = new MyObject();

	private MyObject()
	{

	}

	public static MyObject getInstance()
	{
		return myObject;
	}

	public void test()
	{
		System.out.println("------------");
	}

	public static void main(String args[])
	{
		MyObject mo = MyObject.getInstance();
		mo.test();
	}
}

class Inform
{
	public static void main(String args[])
	{
		MyObject mo = MyObject.getInstance();
		mo.test();
	}
}
