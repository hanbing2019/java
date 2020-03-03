package io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

public class NioServer
{

	ServerSocketChannel channel;

	private InetSocketAddress adderss = new InetSocketAddress(8889);

	private Charset charset = Charset.forName("UTF-8");

	Selector selector;

	public NioServer()
	{
		try
		{
			// ����ͨ��
			channel = ServerSocketChannel.open();

			// ��������
			channel.bind(adderss);

			// ����ͨ��������
			channel.configureBlocking(false);

			// ����ѡ����
			selector = Selector.open();

			// ע�����
			channel.register(selector, SelectionKey.OP_ACCEPT);
			// SelectionKey.OP_ACCEPT ����
			// SelectionKey.OP_CONNECT;����
			// SelectionKey.OP_READ ��ȡ
			// SelectionKey.OP_WRITE д

			System.out.println("��������");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void listener()
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
					procese(key);
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void procese(SelectionKey key) throws IOException
	{
		if (key.isAcceptable())
		{

			try
			{
				ServerSocketChannel nextchannel = (ServerSocketChannel) key
						.channel();
				SocketChannel client = nextchannel.accept();
				client.configureBlocking(false);
				// ע�����
				client.register(selector, SelectionKey.OP_READ);
				key.interestOps(SelectionKey.OP_ACCEPT);

				client.write(charset.encode("������"));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (key.isReadable())
		{
			SocketChannel socket = (SocketChannel) key.channel();

			ByteBuffer buffer = ByteBuffer.allocate(1024);
			StringBuilder sb = new StringBuilder();
			String content = "";
			try
			{
				// ��ȡ����
				while (socket.read(buffer) > 0)
				{
					buffer.flip();
					sb.append(charset.decode(buffer));
				}
				content = sb.toString();
				System.out.println("��ȡ������Ϊ" + sb.toString());
				key.interestOps(SelectionKey.OP_READ);
			} catch (IOException e)
			{
				key.cancel();
				if (key.channel() != null)
				{
					key.channel().close();
				}
			}
			if (content != null && !"".equals(content))
			{
				System.out.println("��������");
				try
				{
					// socket.write(charset.encode(content));

					Set<SelectionKey> set = selector.keys();
					System.out.println(set.size());
					for (SelectionKey selectionKey : set)
					{
						Channel c = selectionKey.channel();
						if (c instanceof SocketChannel && socket != c)
						{
							SocketChannel sc = (SocketChannel) c;
							sc.write(charset.encode(content));
						}

					}
				} catch (Exception e)
				{

				}

			}

		}

	}

	public static void main(String[] args)
	{
		new NioServer().listener();
	}

}
