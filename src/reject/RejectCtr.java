package reject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import spring.User;

public class RejectCtr
{
	static String name = "spring.User";

	public static void func()
	{
		try
		{
			// ��ȡclass����
			Class clazz = Class.forName(name);
			User user = (User) clazz.newInstance();
			// ��ȡ���еı���
			Field[] f = clazz.getDeclaredFields();

			for (int i = 0; i < f.length; i++)
			{
				// f[i].getName()��������
				System.out.println(f[i].getName());
				// f[i].getType()��������
				System.out.println(f[i].getType());
			}

			// getDeclaredMethods()��ȡ���еķ���
			Method m[] = clazz.getDeclaredMethods();
			// ��ȡ���еĹ����ķ��� �����������Զ���ķ����͸���object�෽��
			// Method[] methods = clazz.getMethods();
			System.out.println(m.length);

			for (int i = 0; i < m.length; i++)
			{
				// m[i].getParameterTypes()��ȡ��������
				Method method = m[i];

				// method.invoke(obj, args);
				System.out.println(m[i].getParameterTypes());
				System.out.println("method = " + m[i].getName());
				// m[i].getGenericReturnType()��ȡ�������ص�����
				System.out.println(m[i].getGenericReturnType());
			}
			// clazz.getDeclaredMethod(name,
			// parameterTypes)��ȡname������parameterTypesΪ����
			Method method = clazz.getDeclaredMethod("func1", String.class);
			// ���÷���
			method.invoke(clazz.newInstance(), "ss");

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (NoSuchMethodException e)
		{
			e.printStackTrace();
		} catch (IllegalArgumentException e)
		{
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			e.printStackTrace();
		} catch (InvocationTargetException e)
		{
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		RejectCtr.func();
	}

	public static void constructor(Class<?> clazz) throws Exception
	{
		// ��ȡָ�����캯��
		Class<?> parameterTypes[] =
		{ String.class, Integer.TYPE };

		// Class<?>... parameterTypes��������Ĳ����ǿɱ�ģ������ǹ��캯��������class����
		// ���ݲ��������ͺ��������ҵ���Ӧ�Ĺ��캯��
		Constructor<?> cons = clazz.getConstructor(parameterTypes);
		cons.setAccessible(true);// ���ù��캯��Ȩ�ޣ������˽�е�����true��Ϳ��Է�����
		// ==================================
		// getConstructors()�������е�public���εĹ��캯���������ȡ�����
		Constructor<?>[] consArr = clazz.getConstructors();
		for (Constructor<?> constructor : consArr)
		{
			// constructor.getP
		}

	}
}
