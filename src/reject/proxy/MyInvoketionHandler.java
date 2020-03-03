package reject.proxy;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 自定义jdk的动态代理
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
		System.out.println("前置" + target.getClass());
		Object value = method.invoke(target, args);
		System.out.println("后置");
		return value;
	}

	/**
	 * 获取目标对象的代理对象
	 * 
	 * @return 代理对象
	 * @throws IOException
	 */
	public Object getProxy() throws IOException
	{
		System.out.println("获取对象实现的接口" + target.getClass().getInterfaces());
		return Proxy.newProxyInstance(Thread.currentThread()
				.getContextClassLoader(), target.getClass().getInterfaces(),
				this);
	}
}
