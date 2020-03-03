package properties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * propertis文件操作
 * 
 * @author Administrator
 * 
 */
public class PropertiesUtil
{
	private static Properties p;
	static
	{
		try
		{
			p = new Properties();
			// 加载properties文件
			p.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(
					"test.properties"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 获取key对应的value，没有key返回null
	 * 
	 * @param key
	 * @return
	 */
	public static String getValue(String key)
	{
		String value = p.getProperty(key);
		if (StringUtils.isBlank(value))
		{
			return null;
		}
		return value.trim();
	}

	/**
	 * 获取key对应的value,没有key就返回defaultValue
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public static String getValue(String key, String defaultValue)
	{
		String value = p.getProperty(key);
		if (StringUtils.isBlank(value))
		{
			return defaultValue;
		}
		return value.trim();
	}

	// 读取properties文件
	public void readProperties()
	{
		Properties p = new Properties();
		// test.properties
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"test.properties");
		try
		{
			p.load(is);

			// p.propertyNames();获取key值
			Enumeration e = p.propertyNames();
			while (e.hasMoreElements())
			{
				System.out.println(e.nextElement());
			}

			// getProperty读取properties文件中key对应的value
			//
			String value = p.getProperty("name");
			String type = p.getProperty("type");
			System.out.println(value);
			System.out.println(type);
			is.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 写入properties文件，首先要读取之前的内容，否则写入后原内容就不存在了
	 */
	public void writeProperties()
	{
		Properties p = new Properties();
		// test.properties
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"test.properties");
		// E:\\Workspaces\\MyEclipse Professional
		// 2014\\java\\recourse\\test.properties
		try
		{
			p.load(is);

			Enumeration<?> en = p.propertyNames();
			while (en.hasMoreElements())
			{
				String key = (String) en.nextElement();
				String value = p.getProperty(key);
				p.setProperty(key, value);// 保存文件源数据
			}
			p.setProperty("newKey", "newVlaue");

			OutputStream out = new FileOutputStream(
					new File(
							"E:\\Workspaces\\MyEclipse Professional 2014\\java\\recourse\\test.properties"));
			p.store(out, "update");

			out.close();
			is.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		// newkey2
		System.out.println(PropertiesUtil.getValue("newkey2"));
	}
}
