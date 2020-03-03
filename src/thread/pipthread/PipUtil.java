package thread.pipthread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

public class PipUtil
{

	// 字节流
	public void writeByteInfo(PipedOutputStream out) throws IOException
	{
		System.out.println("writeInfo");
		for (int i = 0; i < 20; i++)
		{
			String data = "v" + i;
			out.write(data.getBytes());
		}
		out.close();
	}

	// 字节流
	public String readByteInfo(PipedInputStream in) throws IOException
	{
		System.out.println("readInfo");
		int len = 0;
		byte[] buff = new byte[100];
		StringBuffer sb = new StringBuffer();
		while ((len = in.read(buff)) > 0)
		{
			String str = new String(buff, 0, len);
			sb.append(str);
		}
		in.close();
		System.out.println(sb.toString());
		return sb.toString();
	}

	public void writeStrInfo(PipedWriter write) throws IOException
	{
		System.out.println("writeStrInfo");
		for (char a = 'a'; a < 'z'; a++)
		{
			write.write(String.valueOf(a));
		}
		write.close();
	}

	public String readStrInfo(PipedReader reader) throws IOException
	{
		StringBuffer sb = new StringBuffer();
		char[] buff = new char[200];
		int len = 0;
		while ((len = reader.read(buff)) > 0)
		{
			String str = new String(buff, 0, len);
			sb.append(str);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public static void main(String args[]) throws IOException
	{
		PipUtil util = new PipUtil();
		// PipedOutputStream out = new PipedOutputStream();
		// PipedInputStream in = new PipedInputStream();
		// out.connect(in);
		// ThreadPipOut tpo = new ThreadPipOut(util, out);
		// tpo.start();
		// ThreadPipIn tpi = new ThreadPipIn(util, in);
		// tpi.start();

		PipedReader reader = new PipedReader();
		PipedWriter write = new PipedWriter();
		write.connect(reader);

		ThreadPipWriter tpw = new ThreadPipWriter(util, write);
		tpw.start();
		ThreadPipReader tpr = new ThreadPipReader(util, reader);
		tpr.start();

	}
}

class ThreadPipOut extends Thread
{
	PipUtil util;
	PipedOutputStream out;

	ThreadPipOut(PipUtil util, PipedOutputStream out)
	{
		this.util = util;
		this.out = out;
	}

	@Override
	public void run()
	{
		try
		{
			util.writeByteInfo(out);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadPipIn extends Thread
{
	PipUtil util;
	PipedInputStream in;

	ThreadPipIn(PipUtil util, PipedInputStream in)
	{
		this.util = util;
		this.in = in;
	}

	@Override
	public void run()
	{
		try
		{
			util.readByteInfo(in);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadPipWriter extends Thread
{
	PipUtil util;
	PipedWriter writer;

	ThreadPipWriter(PipUtil util, PipedWriter writer)
	{
		this.util = util;
		this.writer = writer;
	}

	@Override
	public void run()
	{
		try
		{
			util.writeStrInfo(writer);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadPipReader extends Thread
{
	PipUtil util;
	PipedReader reader;

	ThreadPipReader(PipUtil util, PipedReader reader)
	{
		this.util = util;
		this.reader = reader;
	}

	@Override
	public void run()
	{
		try
		{
			util.readStrInfo(reader);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
