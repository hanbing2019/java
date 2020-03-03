package io;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.StringBufferInputStream;

public class InPutStreamInfo
{
	public static void byteArray() throws IOException
	{
		// ByteArrayInputStream
		byte[] buf = "hello byteArray".getBytes();
		ByteArrayInputStream bis = new ByteArrayInputStream(buf);
		byte[] b = new byte[1024];
		int len = 0;
		while ((len = bis.read(b)) > 0)
		{
			String s = new String(b, 0, len);
			System.out.println(" - " + s);
		}
		bis.close();
	}

	public static void fileIn() throws IOException
	{
		File file = new File("");

		InputStream is = new FileInputStream(file);

		byte[] b = new byte[1024];
		int len = 0;
		while ((len = is.read(b)) > 0)
		{
			System.out.println(new String(b, 0, len));
		}

	}

	public static void stringIn()
	{
		InputStream is = new StringBufferInputStream("");
	}

	public static void pipeStream() throws IOException
	{
		PipedInputStream pis = new PipedInputStream();
		PipedOutputStream pos = new PipedOutputStream();

		// 建立连接
		pis.connect(pos);

		// 写入管道
		pos.write("hello piped".getBytes());

		// 从管道中读取

		byte[] b = new byte[1024];
		int len = 0;
		while ((len = pis.read(b)) > 0)
		{
			System.out.println(len);
			System.out.println(new String(b, 0, len));
			System.out.println("---");

		}
		System.out.println("end");
		pos.close();
		pis.close();

	}

	public static void main(String args[]) throws IOException
	{
		pipeStream();
	}
}
