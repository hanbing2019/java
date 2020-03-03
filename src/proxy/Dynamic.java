package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Dynamic implements InvocationHandler
{
	Object obj;
	Handler handler;

	Dynamic(Handler handler, Object obj)
	{
		this.handler = handler;
		this.obj = obj;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable
	{
		handler.before();
		method.invoke(obj, args);
		handler.after();
		return null;
	}

	public Object get()
	{
		Class clazz = obj.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(),
				clazz.getInterfaces(), this);
	}
}
