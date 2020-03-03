package factory;

public class Car2 implements Car
{

	@Override
	public Car get()
	{
		return new Car2();
	}

}
