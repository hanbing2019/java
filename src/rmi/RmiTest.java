package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RmiTest
{
	public static void main(String[] args) throws RemoteException
	{

		Isay say = new SayHelloImpl();
		LocateRegistry.createRegistry(8888);

		try
		{
			Naming.bind("rmi://localhost:8888/say", say);
			System.out.println("发布服务");
		} catch (MalformedURLException | AlreadyBoundException e)
		{
			e.printStackTrace();
		}
	}
}
