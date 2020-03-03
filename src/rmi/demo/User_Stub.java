package rmi.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class User_Stub
{
	private Socket socket;

	public User_Stub()
	{
		try
		{
			socket = new Socket("localhost", 8888);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public Object getUser()
	{
		try
		{
			ObjectOutputStream os = new ObjectOutputStream(
					socket.getOutputStream());
			os.writeObject("age");
			os.flush();

			ObjectInputStream is = new ObjectInputStream(
					socket.getInputStream());
			Object obj = is.readObject();

			return obj;

		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		} finally
		{
			if (socket != null)
			{
				try
				{
					socket.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		return null;
	}
}
