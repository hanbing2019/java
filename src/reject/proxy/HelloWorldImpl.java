package reject.proxy;

public class HelloWorldImpl implements HelloWorld
{
	public String say(String w)
	{
		System.out.println(w);
		return "say:" + w;
	}
}
