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
			// ��������
			server = new ServerSocket(port);
			System.out.println("�����������");
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
				System.out.println("��ʼ����");
				Socket socket = server.accept();

				InputStream in = socket.getInputStream();

				byte[] b = new byte[1024];
				int len;
				while ((len = in.read(b)) != -1)
				{
					System.out.println("���յ���Ϣ:" + new String(b, 0, len));
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
