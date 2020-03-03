package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class NioChatClient
{

	private int port = 8081;
	private InetSocketAddress local = new InetSocketAddress("localhost", port);

	private SocketChannel client;
	private Selector selector;

	private Charset charset = Charset.forName("utf-8");

	public NioChatClient()
	{
		try
		{

			this.client = SocketChannel.open();
			this.client.connect(local);
			this.client.configureBlocking(false);

			this.selector = Selector.open();

			this.client.register(selector, SelectionKey.OP_READ);

			System.out.println("client start");

		} catch (Exception e)
		{

		}
	}

	public void start()
	{
		new Thread(new ReadThread()).start();
		new Thread(new WriteThread()).start();
	}

	public static void main(String[] args)
	{
		new NioChatClient().start();

	}

	// 2ge线程，读数据，写数据

	private class ReadThread implements Runnable
	{

		@Override
		public void run()
		{
			while (true)
			{

				try
				{
					int wait = selector.select();
					if (wait == 0)
					{
						continue;
					}
					// 服务端 选择器selector调用keys()
					Set<SelectionKey> sets = selector.selectedKeys();
					Iterator<SelectionKey> i = sets.iterator();
					while (i.hasNext())
					{
						SelectionKey key = i.next();
						i.remove();
						read(key);
					}
				} catch (IOException e1)
				{
					e1.printStackTrace();
				}

			}

		}

		public void read(SelectionKey key)
		{
			if (key.isReadable())
			{
				SocketChannel sc = (SocketChannel) key.channel();

				ByteBuffer buff = ByteBuffer.allocate(1024);

				try
				{
					StringBuilder sb = new StringBuilder();
					while (sc.read(buff) > 0)
					{
						buff.flip();
						sb.append(new String(buff.array(), "utf-8"));
					}
					System.out.println("接收:" + sb.toString());
					key.interestOps(SelectionKey.OP_READ);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	private class WriteThread implements Runnable
	{

		@Override
		public void run()
		{
			try
			{
				Scanner scanner = new Scanner(System.in);
				while (scanner.hasNextLine())
				{
					String line = scanner.nextLine();
					client.write(charset.encode(line));
				}
				scanner.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}

		}
	}

}
