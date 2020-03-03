package io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class BioClient
{
	private static int port = 8888;

	public static void main(String[] args)
	{
		try
		{
			Socket s = new Socket("localhost", port);

			OutputStream os = s.getOutputStream();

			os.write("hello world".getBytes());

			os.close();
			s.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
