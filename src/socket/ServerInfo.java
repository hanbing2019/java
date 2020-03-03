package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerInfo
{

	public ServerSocket createServer() throws IOException
	{
		int port = 10086;// 端口
		// 创建服务端
		ServerSocket ss = new ServerSocket(port);
		return ss;
	}

	public Socket getSocket(ServerSocket ss) throws IOException
	{
		Socket socket = ss.accept();
		return socket;
	}

	public void sendMsg(String str, Socket socket) throws IOException
	{

		// 发送消息

		PrintWriter pw = new PrintWriter(socket.getOutputStream());

		if (null != str && !"".equals(str))
		{
			System.out.println("发送消息:" + str);
			pw.write(str);
		}

		pw.close();
	}

	public void getMsg(Socket socket) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		int len = 0;
		char[] buffer = new char[1024];
		StringBuffer sb = new StringBuffer();
		while ((len = reader.read(buffer)) > 0)
		{
			String str = new String(buffer);
			sb.append(str);
		}

		System.out.println("接收到的消息:" + sb.toString());

	}
}
