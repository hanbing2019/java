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
		// ����serverSocketchannel����
		try
		{
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.bind(new InetSocketAddress("localhost", 8081));// ��ip����������
			ssc.configureBlocking(false);// ����Ϊ������ģʽ
			SocketChannel ss = ssc.accept();// �������Ļ�ȡsocketchannel����
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public static void createSSObject()
	{
		try
		{
			SocketChannel sc = SocketChannel.open();// ����SocketChannel����
			sc.connect(new InetSocketAddress("localhost", 8081));
			sc.configureBlocking(false);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
