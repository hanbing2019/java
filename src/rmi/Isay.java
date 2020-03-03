package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Isay extends Remote
{
	// throws RemoteException 必须抛出异常RemoteException
	// 否则发布服务时会抛java.lang.IllegalArgumentException:异常
	public void sayHello(String name) throws RemoteException;
}
