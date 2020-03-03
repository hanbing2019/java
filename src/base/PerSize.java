package base;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class PerSize implements MethodInterceptor
{
	public static void main(String args[])
	{
		while (true)
		{
			Enhancer s = new Enhancer();
			s.setSuperclass(OOMObject.class);
			s.setUseCache(false);
			s.setCallback(new PerSize());
			s.create();
		}

	}

	static class OOMObject
	{

	}

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable
	{
		System.out.println("---------------");
		return arg3.invoke(arg0, arg2);
	}
}
