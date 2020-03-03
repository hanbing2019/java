package base.collection;

public class Information implements Comparable<Information>
{

	int a;
	String name;

	public Information(int a, String name)
	{
		this.a = a;
		this.name = name;

	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Information [a=" + a + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Information o)
	{
		if (this.getA() > o.getA())
		{
			return 1;
		} else if (this.getA() == o.getA())
		{

			return -1;
		} else
		{
			return 0;
		}
	}
}
