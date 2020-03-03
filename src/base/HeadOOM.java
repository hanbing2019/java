package base;

import java.util.ArrayList;
import java.util.List;

public class HeadOOM
{
	static class OOMObject
	{

	}

	public static void main(String args[])
	{
		List<OOMObject> list = new ArrayList<>(10);

		while (true)
		{
			list.add(new OOMObject());
		}
	}
}
