package exception.deside;

import java.util.logging.Logger;

/**
 * 自定义异常
 * 
 * @author Administrator
 * 
 */
public class SimpleException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6520155823943441726L;

	/**
	 * 将输出记录到日志中
	 */
	private static Logger logger = Logger.getLogger("SimpleException");
	public Throwable cause;

	public SimpleException()
	{

	}

	public SimpleException(String msg)
	{
		super(msg);
	}

	public SimpleException(Throwable cause)
	{
		super(cause);
	}

	public SimpleException(String msg, Throwable cause)
	{
		// this.cause = cause;
		super(msg, cause);
	}

	public static void f() throws SimpleException
	{
		// 日志记录消息的级别相关联的方法
		// 输出日志异常方法全路径
		logger.severe("msg");
		throw new SimpleException("异常");
	}

	public static void main(String args[])
	{
		try
		{
			SimpleException.f();
		} catch (SimpleException s)
		{
			for (StackTraceElement ste : s.getStackTrace())
			{
				System.out.println(ste.toString());
			}
			System.out.println(s.getMessage());
			s.printStackTrace();
			// printStackTrace()获取堆栈跟踪数据信息,异常栈
		}
	}
}

class SimpleError extends Error
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8486579075482212327L;

}
