package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SayHelloImpl extends UnicastRemoteObject implements Isay
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SayHelloImpl() throws RemoteException
	{
	}

	@Override
	public void sayHello(String name)
	{
		System.out.println("say -> :" + name);
	}

}
