package factory;

public abstract class AbstractFactory
{

	public abstract Car get();

	public Car get(String name)
	{

		if ("car1".equals(name))
		{
			return new Car1();
		} else if ("car2".equals(name))
		{
			return new Car2();
		} else
		{
			return null;
		}

	}
}
