package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiServer
{

	public static void main(String[] args)
	{
		try
		{
			Isay say = (Isay) Naming.lookup("rmi://localhost:8888/say");
			say.sayHello("abc");
		} catch (MalformedURLException | RemoteException | NotBoundException e)
		{
			e.printStackTrace();
		}

	}
}
