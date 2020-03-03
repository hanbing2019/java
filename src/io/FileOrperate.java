package io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

public class FileOrperate
{
	// 操作文件
	public static void readfile(String filepath) throws IOException
	{
		File file = new File(filepath);
		// file的exists方法用于判断文件是否存在，结果返回true表示文件存在 否则不存在
		if (file.exists())
		{
			String name = file.getName();// 文件名tes.txt
			System.out.println(name);
			String path = file.getPath();// 文件路径D:\word\tes.txt
			System.out.println(path);
			System.out.println(file.getAbsolutePath());// 文件绝对路径

			// 判断是否为文件夹 返回true表示文件夹
			if (file.isDirectory())
			{
				// 获取文件夹中的子文件
				File[] fileList = file.listFiles();
			}
			// file.delete();//删除文件
		} else
		{
			// createNewFile 创建文件
			file.createNewFile();
			// file.mkdir();创建单级文件夹
			// file.mkdirs();创建多级文件夹
		}
	}

	/**
	 * 读取文件内容
	 */

	public void readContent()
	{

	}

	/**
	 * java字节流
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void IoByteArrayInputStream() throws IOException
	{
		// ByteArrayInputStream
		// (读取内存中Byte数组)将内存中的Byte数组适配为一个InputStream。从内存中的Byte数组创建该对象
		byte[] buf = "hello".getBytes();

		ByteArrayInputStream bis = new ByteArrayInputStream(buf);// 读取byte[]数据

		byte[] buf1 = new byte[1024];
		bis.read(buf1);
		System.out.println(new String(buf1));

		// StringBufferInputStream 将内存中的字符串适配为一个InputStream。

		// FileInputStream

		// PipedInputStream管道流：管道流可以实现两个线程之间，二进制数据的传输。

		// SequenceInputStream 合并流

		// FilterInputStream

	}

	// ByteArrayOutputStream
	// (在内存中创建一个缓存区，将Byte数据保存到缓存区)在内存中创建一个buffer。所有写入此流中的数据都被放入到此buffer中
	public static void IoByteArray()
	{
		int a = 0;
		int b = 1;
		int c = 2;
		// ByteArrayOutputStream在内存中创建byte数组缓存区，数据写入缓存区
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		bout.write(a);
		bout.write(b);
		bout.write(c);
		byte[] buff = bout.toByteArray();
		for (int i = 0; i < buff.length; i++)
			System.out.println(buff[i]);
		System.out.println("***********************");
		ByteArrayInputStream bin = new ByteArrayInputStream(buff);
		while ((b = bin.read()) != -1)
		{
			System.out.println(b);
		}
		try
		{
			bin.close();
			bout.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	// StringBufferInputStream类已经过时了
	public static void IoStringBuffer() throws IOException
	{
		String str = "hello world";

		InputStream is = new StringBufferInputStream(str);
		byte[] buf1 = new byte[1024];
		is.read(buf1);
		System.out.println(new String(buf1));
		is.close();

	}

	public static void IoFile() throws IOException
	{
		File file = new File("d:/word/test.txt");
		// 读取文件中的内容
		FileInputStream fis = new FileInputStream(file);
		byte[] buf1 = new byte[1024];
		// 将文件内容读到buf1中
		fis.read(buf1);
		System.out.println(new String(buf1));
		File file1 = new File("d:/word/test1.txt");
		// 向文件中写入数据,写入的数据会覆盖之前的
		FileOutputStream fos = new FileOutputStream(file1);

		fos.write(buf1);
		fos.close();
		fis.close();
	}

	/**
	 * java字符流
	 * 
	 * 使用FileReader读取文件中的内容
	 * 
	 * @throws IOException
	 */

	public static void Rwf() throws IOException
	{
		File file = new File("d:/word/test.txt");
		FileReader fr = new FileReader(file);
		char[] ss = new char[256];
		int len = 0;

		while ((len = fr.read(ss)) > 0)
		{
			System.out.println(len);
			System.out.println(new String(ss, 0, len));
		}
		fr.close();
	}

	/**
	 * @throws IOException
	 * 
	 */
	public static void Rwr()
	{
		File file = new File("d:/word/test.txt");
		FileWriter fw;
		try
		{
			fw = new FileWriter(file, true);
			fw.write("\r\n" + "111sss");
			System.out.println("写入数据");
			fw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// FileWriter fw = new FileWriter(file,
		// true);FileWriter的构造函数，true表示写入数据是追加到文件后面

	}

	/**
	 * 使用字符串作为物理节点的字符输入输出流的用法，即StringReader和StringWriter的用法
	 */
	public static void Rws()
	{
		String s = "hello world";
		Reader r = new StringReader(s);
		char[] buffer = new char[256];

		try
		{
			// 将字符读取为一串串流存入到buffer中
			int dataLen = r.read(buffer);
			// 可以将字符流再以字符串的形式打印出来
			System.out.println(new String(buffer, 0, dataLen));

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		StringWriter sw = new StringWriter();
		// 调用方法执行输出
		sw.write("有一个美丽的新世界\n");
		sw.write("有一个美丽的新世界\n");
		sw.write("有一个美丽的新世界\n");
		sw.write("有一个美丽的新世界\n");
		sw.write("有一个美丽的新世界\n");

		System.out.println(sw.toString());

	}

	/**
	 * 利用BufferedReader实现Inputstream转换成String <功能详细描述>
	 * 
	 * 利用bufferreader读取数据inputstream的数据
	 * 
	 * @param in
	 * @return String
	 */

	public static String Inputstr2Str_Reader(InputStream in, String encode)
	{

		String str = "";
		try
		{
			if (encode == null || encode.equals(""))
			{
				// 默认以utf-8形式
				encode = "utf-8";
			}
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					in, encode));
			StringBuffer sb = new StringBuffer();

			while ((str = reader.readLine()) != null)
			{
				sb.append(str).append("\n");
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e1)
		{
			e1.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		return str;
	}

	/**
	 * 复制图片
	 * 
	 * @param path
	 * @throws IOException
	 */

	public static void pictrue(String path) throws IOException
	{
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		byte[] buff = new byte[1024];
		int len = 0;
		String newpath = "d:\\word\\pic.png";
		File newfile = new File(newpath);
		OutputStream os = new FileOutputStream(newfile);
		while ((len = is.read(buff)) > 0)
		{
			os.write(buff, 0, len);
		}
		os.close();
		is.close();

	}

	public static void main(String args[]) throws IOException
	{
		// FileOrperate.readfile("D:\\word\\tes.txt");
		String path = "C:/Users/Administrator/Desktop/wm.jpg";
		FileOrperate.pictrue(path);
	}
}
