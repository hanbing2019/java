package exception.deside;

public class ChaneException
{
	public static void main(String[] args) throws Exception
	{
		test1();
	}

	private static void test1() throws Exception
	{
		try
		{
			test2();
		} catch (NullPointerException ex)
		{
			// Exception bussinessEx = new Exception("packag exception");
			// bussinessEx.initCause(ex);
			// throw bussinessEx;
			System.out.println(ex.getMessage());
			throw new Exception("packag exception", ex);
			// 3 throw (Exception)ex.fillInStackTrace().initCause(ex);
		}
	}

	private static void test2()
	{
		test3();
	}

	private static void test3()
	{
		throw new NullPointerException("str is null");
	}
}
