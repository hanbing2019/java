package rmi.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class User_Skeleton implements Runnable
{

	private String url;
	private Object object;

	public User_Skeleton(String url, Object object)
	{
		this.url = url;
		this.object = object;
	}

	@Override
	public void run()
	{
		ServerSocket server = null;
		Socket socket = null;

		try
		{
			server = new ServerSocket(8888);
			System.out.println("90909");
			System.out.println("开启服务-----");
			while (true)
			{
				socket = server.accept();
				System.out.println("---接收数据---");
				ObjectInputStream read = new ObjectInputStream(
						socket.getInputStream());
				String method = (String) read.readObject();

				System.out.println("--- " + method);
				if (url.endsWith(method))
				{
					System.out.println("-----------------------------");
					ObjectOutputStream write = new ObjectOutputStream(
							socket.getOutputStream());

					System.out.println("传送数据");
					write.writeObject(object);
					write.flush();

				}
				if (socket != null)
				{
					socket.close();
				}
			}
		} catch (IOException | ClassNotFoundException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (server != null)
				{
					server.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
