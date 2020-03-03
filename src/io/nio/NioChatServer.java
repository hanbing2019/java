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

public class NioChatServer
{
	private int port = 8081;
	private InetSocketAddress local = new InetSocketAddress("localhost", port);

	private ServerSocketChannel server;

	private Selector selector;

	private Charset charset = Charset.forName("utf-8");

	public NioChatServer()
	{

		try
		{

			this.server = ServerSocketChannel.open();
			this.server.bind(local);
			this.server.configureBlocking(false);// ����Nio�ķ�����ģʽ

			// ����ѡ����
			this.selector = Selector.open();

			this.server.register(selector, SelectionKey.OP_ACCEPT);

			System.out.println("--start--");
		} catch (Exception e)
		{
			e.printStackTrace();

		}
	}

	public void process()
	{
		try
		{
			while (true)
			{
				int wait = this.selector.select();
				if (wait == 0)
				{
					continue;
				}

				Set<SelectionKey> sets = this.selector.selectedKeys();
				Iterator<SelectionKey> i = sets.iterator();
				while (i.hasNext())
				{
					SelectionKey key = i.next();
					work(key);
					i.remove();
				}
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public void work(SelectionKey key) throws IOException
	{
		if (key.isAcceptable())
		{
			// ���״����ӵķ�����Ϣ
			ServerSocketChannel channel = (ServerSocketChannel) key.channel();
			SocketChannel client = channel.accept();
			client.configureBlocking(false);

			client.register(selector, SelectionKey.OP_READ);
			key.interestOps(SelectionKey.OP_ACCEPT);
			Charset charset = Charset.forName("utf-8");
			client.write(charset.encode("coming "));
		}
		if (key.isReadable())
		{
			// ��ȡ����
			SocketChannel client = (SocketChannel) key.channel();
			ByteBuffer buff = ByteBuffer.allocate(1024);
			StringBuilder sb = new StringBuilder();
			while (client.read(buff) > 0)
			{
				// �л�����ȡ״̬
				buff.flip();
				sb.append(new String(buff.array(), "utf-8"));
			}
			System.out.println("��ȡ��������" + sb.toString());
			// ��ͻ���д����
			sendMsg(client, sb.toString());
		}
	}

	public void sendMsg(SocketChannel client, String content)
			throws IOException
	{
		Set<SelectionKey> sets = this.selector.keys();
		for (SelectionKey skey : sets)
		{
			Channel c = skey.channel();
			if (c instanceof SocketChannel && c != client)
			{
				SocketChannel sc = (SocketChannel) c;
				sc.write(charset.encode("�������ݵ��ͻ��� :" + content));
			}
		}
	}

	public static void main(String[] args)
	{
		new NioChatServer().process();

	}

}
