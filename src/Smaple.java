public class Smaple
{
	public Smaple()
	{
		System.out.println("Smaple loaded by :"
				+ this.getClass().getClassLoader());
		new Dog();
	}

}
