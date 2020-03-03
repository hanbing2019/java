package proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import proxy.Handler;

public class Cglib implements MethodInterceptor
{
	Handler h;

	public Cglib(Handler h)
	{
		this.h = h;
	}

	public Object getInstance(Object obj)
	{
		Enhancer e = new Enhancer();
		e.setSuperclass(obj.getClass());
		e.setCallback(this);
		return e.create();
	}

	@Override
	public Object intercept(Object arg0, Method method, Object[] arg2,
			MethodProxy proxy) throws Throwable
	{
		h.before();

		System.out.println(method.getName());
		proxy.invokeSuper(arg0, arg2);
		h.after();
		return null;
	}

}
