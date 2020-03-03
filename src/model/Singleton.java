package model;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton
{
	// 创建原子引用类
	private AtomicReference<Singleton> instance = new AtomicReference<>();

	public Singleton getInstanc()
	{
		// 无限循环，直到获取值
		for (;;)
		{
			// 获取当前的value
			Singleton s = instance.get();
			if (s != null)
			{
				// 不为空就直接返回
				return s;
			}
			s = new Singleton();
			// 创建对象s作为新增和期望值null进行比较替换，如果替换成功，那么当前创建的对象就是单例对象，不成功就进行下一次循环判断
			if (instance.compareAndSet(null, s))
				return s;
		}

	}
}
