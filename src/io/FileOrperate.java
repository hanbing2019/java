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
	// �����ļ�
	public static void readfile(String filepath) throws IOException
	{
		File file = new File(filepath);
		// file��exists���������ж��ļ��Ƿ���ڣ��������true��ʾ�ļ����� ���򲻴���
		if (file.exists())
		{
			String name = file.getName();// �ļ���tes.txt
			System.out.println(name);
			String path = file.getPath();// �ļ�·��D:\word\tes.txt
			System.out.println(path);
			System.out.println(file.getAbsolutePath());// �ļ�����·��

			// �ж��Ƿ�Ϊ�ļ��� ����true��ʾ�ļ���
			if (file.isDirectory())
			{
				// ��ȡ�ļ����е����ļ�
				File[] fileList = file.listFiles();
			}
			// file.delete();//ɾ���ļ�
		} else
		{
			// createNewFile �����ļ�
			file.createNewFile();
			// file.mkdir();���������ļ���
			// file.mkdirs();�����༶�ļ���
		}
	}

	/**
	 * ��ȡ�ļ�����
	 */

	public void readContent()
	{

	}

	/**
	 * java�ֽ���
	 * 
	 * @param args
	 * @throws IOException
	 */

	public static void IoByteArrayInputStream() throws IOException
	{
		// ByteArrayInputStream
		// (��ȡ�ڴ���Byte����)���ڴ��е�Byte��������Ϊһ��InputStream�����ڴ��е�Byte���鴴���ö���
		byte[] buf = "hello".getBytes();

		ByteArrayInputStream bis = new ByteArrayInputStream(buf);// ��ȡbyte[]����

		byte[] buf1 = new byte[1024];
		bis.read(buf1);
		System.out.println(new String(buf1));

		// StringBufferInputStream ���ڴ��е��ַ�������Ϊһ��InputStream��

		// FileInputStream

		// PipedInputStream�ܵ������ܵ�������ʵ�������߳�֮�䣬���������ݵĴ��䡣

		// SequenceInputStream �ϲ���

		// FilterInputStream

	}

	// ByteArrayOutputStream
	// (���ڴ��д���һ������������Byte���ݱ��浽������)���ڴ��д���һ��buffer������д������е����ݶ������뵽��buffer��
	public static void IoByteArray()
	{
		int a = 0;
		int b = 1;
		int c = 2;
		// ByteArrayOutputStream���ڴ��д���byte���黺����������д�뻺����
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

	// StringBufferInputStream���Ѿ���ʱ��
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
		// ��ȡ�ļ��е�����
		FileInputStream fis = new FileInputStream(file);
		byte[] buf1 = new byte[1024];
		// ���ļ����ݶ���buf1��
		fis.read(buf1);
		System.out.println(new String(buf1));
		File file1 = new File("d:/word/test1.txt");
		// ���ļ���д������,д������ݻḲ��֮ǰ��
		FileOutputStream fos = new FileOutputStream(file1);

		fos.write(buf1);
		fos.close();
		fis.close();
	}

	/**
	 * java�ַ���
	 * 
	 * ʹ��FileReader��ȡ�ļ��е�����
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
			System.out.println("д������");
			fw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// FileWriter fw = new FileWriter(file,
		// true);FileWriter�Ĺ��캯����true��ʾд��������׷�ӵ��ļ�����

	}

	/**
	 * ʹ���ַ�����Ϊ����ڵ���ַ�������������÷�����StringReader��StringWriter���÷�
	 */
	public static void Rws()
	{
		String s = "hello world";
		Reader r = new StringReader(s);
		char[] buffer = new char[256];

		try
		{
			// ���ַ���ȡΪһ���������뵽buffer��
			int dataLen = r.read(buffer);
			// ���Խ��ַ��������ַ�������ʽ��ӡ����
			System.out.println(new String(buffer, 0, dataLen));

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		StringWriter sw = new StringWriter();
		// ���÷���ִ�����
		sw.write("��һ��������������\n");
		sw.write("��һ��������������\n");
		sw.write("��һ��������������\n");
		sw.write("��һ��������������\n");
		sw.write("��һ��������������\n");

		System.out.println(sw.toString());

	}

	/**
	 * ����BufferedReaderʵ��Inputstreamת����String <������ϸ����>
	 * 
	 * ����bufferreader��ȡ����inputstream������
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
				// Ĭ����utf-8��ʽ
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
	 * ����ͼƬ
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
