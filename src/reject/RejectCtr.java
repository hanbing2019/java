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
			// 获取class对象
			Class clazz = Class.forName(name);
			User user = (User) clazz.newInstance();
			// 获取所有的变量
			Field[] f = clazz.getDeclaredFields();

			for (int i = 0; i < f.length; i++)
			{
				// f[i].getName()变量名称
				System.out.println(f[i].getName());
				// f[i].getType()变量类型
				System.out.println(f[i].getType());
			}

			// getDeclaredMethods()获取所有的方法
			Method m[] = clazz.getDeclaredMethods();
			// 获取所有的公共的方法 方法包含了自定义的方法和父类object类方法
			// Method[] methods = clazz.getMethods();
			System.out.println(m.length);

			for (int i = 0; i < m.length; i++)
			{
				// m[i].getParameterTypes()获取参数类型
				Method method = m[i];

				// method.invoke(obj, args);
				System.out.println(m[i].getParameterTypes());
				System.out.println("method = " + m[i].getName());
				// m[i].getGenericReturnType()获取方法返回的类型
				System.out.println(m[i].getGenericReturnType());
			}
			// clazz.getDeclaredMethod(name,
			// parameterTypes)获取name方法，parameterTypes为参数
			Method method = clazz.getDeclaredMethod("func1", String.class);
			// 调用方法
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
		// 获取指定构造函数
		Class<?> parameterTypes[] =
		{ String.class, Integer.TYPE };

		// Class<?>... parameterTypes这个方法的参数是可变的，参数是构造函数参数的class对象
		// 根据参数的类型和数量来找到对应的构造函数
		Constructor<?> cons = clazz.getConstructor(parameterTypes);
		cons.setAccessible(true);// 设置构造函数权限，如果是私有的设置true后就可以访问了
		// ==================================
		// getConstructors()返回所有的public修饰的构造函数，不会获取父类的
		Constructor<?>[] consArr = clazz.getConstructors();
		for (Constructor<?> constructor : consArr)
		{
			// constructor.getP
		}

	}
}
