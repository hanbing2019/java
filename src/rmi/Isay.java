package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Isay extends Remote
{
	// throws RemoteException �����׳��쳣RemoteException
	// ���򷢲�����ʱ����java.lang.IllegalArgumentException:�쳣
	public void sayHello(String name) throws RemoteException;
}
