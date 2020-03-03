package spring;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class JavaMath
{
	public JavaMath()
	{

	}

	public JavaMath(String a)
	{
		System.out.println(" a= " + a);
	}

	public JavaMath(String a, String b)
	{
		System.out.println(" a= " + a + ", b= " + b);
	}

	public int add(String a) throws FileNotFoundException
	{
		// File file = new File("");

		// InputStream in = new FileInputStream(file);
		System.out.println("add func " + a);
		return 2;
	}

	public Map<String, Object> sub(String s, User u) throws Exception
	{
		System.out.println("sub func");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("k1", s);
		map.put("k2", u);
		throw new RuntimeException("test exception");
	}

}
