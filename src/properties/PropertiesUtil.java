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
 * propertis�ļ�����
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
			// ����properties�ļ�
			p.load(PropertiesUtil.class.getClassLoader().getResourceAsStream(
					"test.properties"));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡkey��Ӧ��value��û��key����null
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
	 * ��ȡkey��Ӧ��value,û��key�ͷ���defaultValue
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

	// ��ȡproperties�ļ�
	public void readProperties()
	{
		Properties p = new Properties();
		// test.properties
		InputStream is = getClass().getClassLoader().getResourceAsStream(
				"test.properties");
		try
		{
			p.load(is);

			// p.propertyNames();��ȡkeyֵ
			Enumeration e = p.propertyNames();
			while (e.hasMoreElements())
			{
				System.out.println(e.nextElement());
			}

			// getProperty��ȡproperties�ļ���key��Ӧ��value
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
	 * д��properties�ļ�������Ҫ��ȡ֮ǰ�����ݣ�����д���ԭ���ݾͲ�������
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
				p.setProperty(key, value);// �����ļ�Դ����
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
