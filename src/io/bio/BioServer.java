package io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer
{

	private int port = 8888;
	private ServerSocket server;

	public BioServer()
	{
		try
		{
			// 创建服务
			server = new ServerSocket(port);
			System.out.println("创建服务完成");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void start()
	{
		while (true)
		{
			try
			{
				System.out.println("开始连接");
				Socket socket = server.accept();

				InputStream in = socket.getInputStream();

				byte[] b = new byte[1024];
				int len;
				while ((len = in.read(b)) != -1)
				{
					System.out.println("接收的消息:" + new String(b, 0, len));
				}
				in.close();
				socket.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args)
	{
		new BioServer().start();
	}

}
