package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo
{

	public static void main(String[] args)
	{

	}

	public static void createSSCObject()
	{
		// 创建serverSocketchannel对象
		try
		{
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.bind(new InetSocketAddress("localhost", 8081));// 绑定ip，建立服务
			ssc.configureBlocking(false);// 设置为非阻塞模式
			SocketChannel ss = ssc.accept();// 非阻塞的获取socketchannel对象
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void createSSObject()
	{
		try
		{
			SocketChannel sc = SocketChannel.open();// 创建SocketChannel对象
			sc.connect(new InetSocketAddress("localhost", 8081));
			sc.configureBlocking(false);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
