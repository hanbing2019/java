package exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ExceptionInfo
{
	// java���쳣�Ƕ��������쳣�Ļ��඼��Throwable
	/**
	 * �쳣���ࣺchecked�쳣������쳣����runtime�쳣������ʱ�쳣��
	 * 
	 * @throws FileNotFoundException
	 */
	// �ɼ���쳣����ʾjava���������Լ����쳣�������ļ��Ƿ���ڣ�IOException,
	// ���﷨�Ƕȿ������쳣�����ô��봦��,��try--catch()������ȡ�쳣�������ڷ�����������throws

	public static boolean checkException() throws FileNotFoundException
	{
		boolean res = false;
		File file = new File("");

		try
		{
			// ��ȡ�ļ�������ʱ��java�������Զ�����쳣������ͱ�����try--catch()�������쳣
			// ������throws�׳��쳣 FileNotFoundException
			InputStream is = new FileInputStream(file);
			res = true;
		} catch (FileNotFoundException e)
		{
			// System.out.println("�쳣");
			// TODO Auto-generated catch block
			// e.printStackTrace();
			throw e;
		} finally
		{
			// finally
			System.out.println("ִ��finally");
		}
		return res;
	}

	public void checkException1() throws FileNotFoundException
	{
		File file = new File("");
		InputStream is = new FileInputStream(file);
	}

	// ����ʱ�쳣��java�����������Զ���飬�����˻�ֱ��java��������׳���Ӧ���쳣
	// ��������Խ�磬��ָ��
	// ����ʱ�쳣���ص���Java����������������Ҳ����˵���������п��ܳ��������쳣����ʹû����try-catch��䲶������Ҳû����throws�Ӿ������׳�����Ҳ�����ͨ��
	public void runtimeException()
	{
		int a[] = new int[3];
		// �α�4�Ѿ������˳�ʼ������󳤶ȣ����Ǳ��������ܼ�鵽��
		// ����ִ�е���δ����ʱ����鵽�쳣��Ȼ���׳�
		System.out.println(a[4]);
	}

	// throws throw try-catch ��������÷�
	// throws:���������׳��쳣�����ͣ�ʹ�����ط�������ʱ֪��Ҫ��������쳣,�ں���ͷ��ʹ��

	public void funcThrows() throws FileNotFoundException
	{
		File file = new File("");
		InputStream is = new FileInputStream(file);
	}

	// throwֻ���ں�������ʹ�ã�throw�׳������쳣ʵ������try-catch����throws����ʹ��
	public void funcThrow() throws Exception
	{
		try
		{

		} catch (Exception e)
		{
			// �׳�RuntimeExceptionʵ��
			// throw new RuntimeException("");
			throw e;
			// �������throw����������ֹ������������ִ�в�����
			// Ȼ���ڰ�����������try���У��������ϲ���ú����У���������Ѱ�Һ�������ƥ���catch�Ӿ��try�顣
			// �з��ؽ���ķ���Ҳ�����ַ���ֵ
		}
	}

	public static void main(String args[]) throws FileNotFoundException
	{
		System.out.println(ExceptionInfo.checkException());
	}
}
