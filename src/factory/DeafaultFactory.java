package factory;

public class DeafaultFactory extends AbstractFactory
{

	@Override
	public Car get()
	{
		return new Car1();
	}

}
