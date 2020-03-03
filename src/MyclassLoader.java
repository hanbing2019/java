import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyclassLoader extends ClassLoader
{
	String name;// 加载器名称
	String classpath;// 加载类的路径

	public MyclassLoader(String name)
	{
		super();
		this.name = name;
	}

	public MyclassLoader(ClassLoader parent, String name)
	{
		super(parent);
		this.name = name;
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		byte[] data = loadClassData(name);

		return this.defineClass(name, data, 0, data.length);
	}

	private byte[] loadClassData(String name)
	{
		InputStream is = null;
		ByteArrayOutputStream bos = null;
		int len = 0;
		try
		{
			is = new FileInputStream(new File(this.classpath + "\\" + name
					+ ".class"));
			bos = new ByteArrayOutputStream();
			while (-1 != (len = is.read()))
			{
				bos.write(len);
			}
			return bos.toByteArray();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				is.close();
				bos.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

	public static void loadtest(ClassLoader loader)
			throws ClassNotFoundException, InstantiationException,
			IllegalAccessException
	{
		Class<?> clazz = loader.loadClass("Smaple");

		Object obj = clazz.newInstance();

	}

	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * @return the classpath
	 */
	public String getClasspath()
	{
		return classpath;
	}

	/**
	 * @param classpath
	 *            the classpath to set
	 */
	public void setClasspath(String classpath)
	{
		this.classpath = classpath;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return this.name;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException
	{
		MyclassLoader loader1 = new MyclassLoader("loader1");

		loader1.setClasspath("D:\\app\\server");

		MyclassLoader loader2 = new MyclassLoader(loader1, "loader2");
		loader2.setClasspath("D:\\app\\client");

		// MyclassLoader loader3 = new MyclassLoader(null, "loader3");
		// loader3.setClasspath("D:\\app\\client");
		loadtest(loader2);
		// loadtest(loader3);
	}
}
