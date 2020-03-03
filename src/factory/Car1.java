package factory;

public class Car1 implements Car
{

	@Override
	public Car get()
	{
		return new Car1();
	}

}
