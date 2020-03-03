package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketInfo
{
	public String InputMsg()
	{
		Scanner sc = new Scanner(System.in);
		String msg = sc.nextLine();

		System.out.println("输入：" + msg);
		return msg;
	}

	//
	public void createService()
	{

		try
		{
			ServerSocket ss = new ServerSocket(10086);
			Socket s = ss.accept();

			BufferedReader read = new BufferedReader(new InputStreamReader(
					s.getInputStream()));
			PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
			String msg = InputMsg();
			pw.write(msg);
			pw.close();
			s.close();
			// int len = 0;
			// char[] buffer = new char[1024];
			// while (true)
			// {
			// String str = read.readLine();
			// System.out.println("接收到的信息：" + str);
			// }

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		SocketInfo si = new SocketInfo();
		si.createService();
	}
}
