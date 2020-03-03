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

public class NioClient
{

	private InetSocketAddress address = new InetSocketAddress("localhost", 8081);

	private SocketChannel client;

	private Selector selector;

	private Charset charset = Charset.forName("UTF-8");

	public NioClient()
	{
		try
		{
			client = SocketChannel.open(address);
			client.configureBlocking(false);

			selector = Selector.open();

			client.register(selector, SelectionKey.OP_READ);

		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void listener()
	{
		new Thread(new Reader()).start();
		new Thread(new Write()).start();
	}

	public static void main(String[] args)
	{
		new NioClient().listener();
	}

	private class Write implements Runnable
	{

		@Override
		public void run()
		{
			Scanner scanner = new Scanner(System.in);
			while (scanner.hasNextLine())
			{
				String line = scanner.nextLine();

				try
				{
					client.write(charset.encode(line));
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
			scanner.close();

		}

	}

	// ∂¡»°
	private class Reader implements Runnable
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
						continue;

					Set<SelectionKey> set = selector.selectedKeys();

					Iterator<SelectionKey> iterator = set.iterator();
					while (iterator.hasNext())
					{
						SelectionKey key = iterator.next();
						iterator.remove();
						process(key);
					}

				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

		public void process(SelectionKey key)
		{

			if (key.isReadable())
			{
				SocketChannel n = (SocketChannel) key.channel();
				ByteBuffer dst = ByteBuffer.allocate(1024);
				StringBuilder sb = new StringBuilder();
				try
				{
					while (n.read(dst) > 0)
					{
						dst.flip();
						sb.append(charset.decode(dst));
					}
					System.out.println("from service" + sb.toString());
					key.interestOps(SelectionKey.OP_READ);
				} catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		}

	}
}
