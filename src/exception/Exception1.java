package exception;

import java.util.ArrayList;
import java.util.HashMap;

public class Exception1
{

	public static void main(String[] args)
	{
		HashMap<Demo, Object> map = new HashMap<Demo, Object>();
		Demo d = new Demo();
		map.put(d, "dd");
		Comparable c;

		String s = "dsd";

		ArrayList<String> ass = new ArrayList<String>();

	}

	static final int tableSizeFor(int cap)
	{
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return n + 1;
	}
}

class Demo
{

}
