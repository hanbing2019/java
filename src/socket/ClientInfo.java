package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientInfo
{
	//
	public static void getMsg() throws UnknownHostException, IOException
	{
		System.out.println(Inet4Address.getByName("localhost"));
		Socket socket = new Socket("127.0.0.1", 10086);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));

		while (true)
		{

			String str = reader.readLine();
			if (str != null && !"".equals(str))
			{
				System.out.println("接收到的信息: " + str);
			}

		}
	}

	public static void main(String args[]) throws UnknownHostException,
			IOException
	{
		ClientInfo.getMsg();
	}
}
