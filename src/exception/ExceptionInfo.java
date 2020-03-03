package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionInfo
{
	// java中异常是对象，所有异常的基类都是Throwable
	/**
	 * 异常分类：checked异常（检查异常）和runtime异常（运行时异常）
	 * 
	 * @throws FileNotFoundException
	 */
	// 可检查异常：表示java编译器可以检查的异常，例如文件是否存在，IOException,
	// 从语法角度看这类异常必须用代码处理,用try--catch()来不获取异常，或者在方法名后面用throws

	public static boolean checkException() throws FileNotFoundException
	{
		boolean res = false;
		File file = new File("");

		try
		{
			// 获取文件输入流时，java编译器自动检查异常，这里就必须用try--catch()来捕获异常
			// 或者用throws抛出异常 FileNotFoundException
			InputStream is = new FileInputStream(file);
			res = true;
		} catch (FileNotFoundException e)
		{
			// System.out.println("异常");
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw e;
		} finally
		{
			// finally
			System.out.println("执行finally");
		}
		return res;
	}

	public void checkException1() throws FileNotFoundException
	{
		File file = new File("");
		InputStream is = new FileInputStream(file);
	}

	// 运行时异常：java编译器不能自动检查，遇到了会直接java虚拟机会抛出相应的异常
	// 例如数组越界，空指针
	// 运行时异常的特点是Java编译器不会检查它，也就是说，当程序中可能出现这类异常，即使没有用try-catch语句捕获它，也没有用throws子句声明抛出它，也会编译通过
	public void runtimeException()
	{
		int a[] = new int[3];
		// 游标4已经超过了初始化的最大长度，但是编译器不能检查到，
		// 但是执行到这段代码的时候会检查到异常，然后抛出
		System.out.println(a[4]);
	}

	// throws throw try-catch 的区别和用法
	// throws:申明方法抛出异常的类型，使其他地方调用它时知道要捕获这个异常,在函数头上使用

	public void funcThrows() throws FileNotFoundException
	{
		File file = new File("");
		InputStream is = new FileInputStream(file);
	}

	// throw只能在函数体中使用，throw抛出的是异常实例，和try-catch或者throws配套使用
	public void funcThrow() throws Exception
	{
		try
		{

		} catch (Exception e)
		{
			// 抛出RuntimeException实例
			// throw new RuntimeException("");
			throw e;
			// 程序会在throw语句后立即终止，它后面的语句执行不到，
			// 然后在包含它的所有try块中（可能在上层调用函数中）从里向外寻找含有与其匹配的catch子句的try块。
			// 有返回结果的方法也不会又返回值
		}
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println(ExceptionInfo.checkException());
	}
}
