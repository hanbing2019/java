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
		// 自己创建数组来作为缓冲区的存储器
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
	 * 读取文件
	 * 
	 * @throws IOException
	 */
	public static void readfile() throws IOException
	{
		String filePath = "D:/text.txt";
		File file = new File(filePath);
		FileInputStream is = new FileInputStream(file);
		// 通道是数据的载体，buffer是存储数据的地方，线程每次从buffer检查数据通知给通道

		// 创建文件的操作管道
		FileChannel channel = is.getChannel();
		// 创建缓冲区，也就是创建一个指定大小的byte数组
		ByteBuffer buffer = ByteBuffer.allocate(10);
		// 读取
		channel.read(buffer);
		// 锁定操作范围
		buffer.flip();// 调用这个方法之后才能读取数据
		System.out.println(buffer.remaining());
		while (buffer.remaining() > 0)
		{
			// 读取数据
			byte b = buffer.get();
			System.out.println(b);
		}
		// 解除锁定
		buffer.clear();
		// 关闭管道
		channel.close();
	}

	/**
	 * 写入文件
	 * 
	 * @throws IOException
	 */
	public static void write() throws IOException
	{
		String pathname = "D:/text.txt";
		File file = new File(pathname);

		FileOutputStream out = new FileOutputStream(file);

		FileChannel channel = out.getChannel();
		// 创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);

		String s = "hello world";

		byte[] msg = s.getBytes();
		for (byte m : msg)
		{
			buffer.put(m);
		}
		// 锁定操作范围
		buffer.flip();
		channel.write(buffer);
		buffer.clear();
		channel.close();
	}
}
