package base;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test
{
	public int a;

	public String func()
	{
		return "name";
	}

	public static void main(String[] args)
	{
		// /ClassLoader

	}

	public byte[] loadclassData(String name)
	{
		name = name.replace(".", "/");

		byte[] data = null;
		InputStream is = null;
		ByteArrayOutputStream bao = null;
		File file = new File("º”‘ÿ¬∑æ∂" + name + ".class");
		try
		{
			is = new FileInputStream(file);
			bao = new ByteArrayOutputStream();

			int len = 0;
			while ((len = is.read()) != -1)
			{
				bao.write(len);
			}
			bao.toByteArray();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				is.close();
				bao.close();
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		return bao.toByteArray();
	}
}
