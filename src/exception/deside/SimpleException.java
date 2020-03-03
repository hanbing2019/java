package exception.deside;

import java.util.logging.Logger;

/**
 * �Զ����쳣
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
	 * �������¼����־��
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
		// ��־��¼��Ϣ�ļ���������ķ���
		// �����־�쳣����ȫ·��
		logger.severe("msg");
		throw new SimpleException("�쳣");
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
			// printStackTrace()��ȡ��ջ����������Ϣ,�쳣ջ
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
