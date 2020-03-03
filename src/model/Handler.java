package model;

public abstract class Handler
{

	private Handler next;

	public void setNest(Handler next)
	{
		this.next = next;
	}

	public abstract void dealRequest(String request);

}
