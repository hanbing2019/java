package base.collection;

import java.util.Comparator;

public class ComparatorImpl implements Comparator<Information>
{

	@Override
	public int compare(Information o1, Information o2)
	{
		if (o1.getA() >= o2.getA())
		{
			return 1;

		}
		return -1;
	}
}
