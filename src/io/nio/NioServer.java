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
			// 创建通道
			channel = ServerSocketChannel.open();

			// 建立服务
			channel.bind(adderss);

			// 设置通道非阻塞
			channel.configureBlocking(false);

			// 创建选择器
			selector = Selector.open();

			// 注册监听
			channel.register(selector, SelectionKey.OP_ACCEPT);
			// SelectionKey.OP_ACCEPT 接收
			// SelectionKey.OP_CONNECT;连接
			// SelectionKey.OP_READ 读取
			// SelectionKey.OP_WRITE 写

			System.out.println("启动服务");
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
				// 注册监听
				client.register(selector, SelectionKey.OP_READ);
				key.interestOps(SelectionKey.OP_ACCEPT);

				client.write(charset.encode("请输入"));
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
				// 读取数据
				while (socket.read(buffer) > 0)
				{
					buffer.flip();
					sb.append(charset.decode(buffer));
				}
				content = sb.toString();
				System.out.println("读取的数据为" + sb.toString());
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
				System.out.println("返回数据");
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
