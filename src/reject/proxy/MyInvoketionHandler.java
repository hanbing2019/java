package reject.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �Զ���jdk�Ķ�̬����
 * 
 * @author Administrator
 * 
 */
public class MyInvoketionHandler implements InvocationHandler
{

	Object target;

	AspectFunc af;

	MyInvoketionHandler(Object target, AspectFunc af)
	{
		this.target = target;
		this.af = af;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		String name = method.getName();
		af.before(name);
		System.out.println("ǰ��" + target.getClass());
		Object value = method.invoke(target, args);
		System.out.println("����");
		return value;
	}

	/**
	 * ��ȡĿ�����Ĵ������
	 * 
	 * @return �������
	 * @throws IOException
	 */
	public Object getProxy() throws IOException
	{
		System.out.println("��ȡ����ʵ�ֵĽӿ�" + target.getClass().getInterfaces());
		return Proxy.newProxyInstance(Thread.currentThread()
				.getContextClassLoader(), target.getClass().getInterfaces(),
				this);
	}
}
