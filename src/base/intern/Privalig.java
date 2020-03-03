package base.intern;

public class Privalig
{
	public Privalig()
	{
		System.out.println("Privalig()");
	}

	protected void f3()
	{

	}

	void f()
	{
		System.out.println("ddd");
	}

	public static void main(String args[])
	{
		// p.f2();
	}

	private void f2()
	{
		System.out.println("private");
	}

}

class Pc extends Privalig
{
	@Override
	void f()
	{
		System.out.println("dddd");
	}
}
