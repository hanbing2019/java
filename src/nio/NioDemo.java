package nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class NioDemo
{
	static private final byte message[] =
	{ 83, 111, 109, 101, 32, 98, 121, 116, 101, 115, 46 };

	public static void main(String[] args) throws IOException
	{
		Selector selector = Selector.open();
		ServerSocketChannel ssc = ServerSocketChannel.open();
		SelectionKey s = ssc.register(selector, 16);
		System.out.println(ssc.validOps());
		write();
		// CharBuffer.allocate(capacity)
		// �Լ�������������Ϊ�������Ĵ洢��
		char[] array = new char[100];
		CharBuffer buffer = CharBuffer.wrap(array);
		CharBuffer buffer1 = buffer.duplicate();
		CharBuffer buffer2 = buffer.slice();
		CharBuffer buffer3 = buffer.asReadOnlyBuffer();
		// CharBuffer.wrap(array, offset, length);
		// CharBuffer.wrap(csq)
		// CharBuffer.wrap(csq, start, end)
	}

	public static void createBuffer()
	{
		byte[] array = new byte[1024];

		ByteBuffer b = ByteBuffer.wrap(array);
		b.clear();
	}

	/**
	 * ��ȡ�ļ�
	 * 
	 * @throws IOException
	 */
	public static void readfile() throws IOException
	{
		String filePath = "D:/text.txt";
		File file = new File(filePath);
		FileInputStream is = new FileInputStream(file);
		// ͨ�������ݵ����壬buffer�Ǵ洢���ݵĵط����߳�ÿ�δ�buffer�������֪ͨ��ͨ��

		// �����ļ��Ĳ����ܵ�
		FileChannel channel = is.getChannel();
		// ������������Ҳ���Ǵ���һ��ָ����С��byte����
		ByteBuffer buffer = ByteBuffer.allocate(10);
		// ��ȡ
		channel.read(buffer);
		// ����������Χ
		buffer.flip();// �����������֮����ܶ�ȡ����
		System.out.println(buffer.remaining());
		while (buffer.remaining() > 0)
		{
			// ��ȡ����
			byte b = buffer.get();
			System.out.println(b);
		}
		// �������
		buffer.clear();
		// �رչܵ�
		channel.close();
	}

	/**
	 * д���ļ�
	 * 
	 * @throws IOException
	 */
	public static void write() throws IOException
	{
		String pathname = "D:/text.txt";
		File file = new File(pathname);

		FileOutputStream out = new FileOutputStream(file);

		FileChannel channel = out.getChannel();
		// ����������
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		String s = "hello world";

		byte[] msg = s.getBytes();
		for (byte m : msg)
		{
			buffer.put(m);
		}
		// ����������Χ
		buffer.flip();
		channel.write(buffer);
		buffer.clear();
		channel.close();
	}
}
