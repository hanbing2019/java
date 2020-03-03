package thread.waitandnotify;

public class ValueObject
{
	private static String value = "";

	public static String getValue()
	{
		return value;
	}

	public static void setValue(String value)
	{
		ValueObject.value = value;
	}

	public static void main(String args[])
	{
		Object lock = new Object();
		Product p = new Product(lock);
		Custom c = new Custom(lock);
		// 一生产者和一消费者
		ProductThread pt = new ProductThread(p);
		// pt.start();
		CustomThread ct = new CustomThread(c);
		// ct.start();
		// 多生产者和多消费者，唤醒等待线程用notifyAll();用notify有可能唤醒的是同类的等待线程
		Thread[] pr = new Thread[2];
		Thread[] cm = new Thread[2];
		for (int i = 0; i < 2; i++)
		{
			System.out.println(i);
			pr[i] = new Thread(pt);
			pr[i].setName("product" + i);
			cm[i] = new Thread(ct);
			cm[i].setName("Custom" + i);
			pr[i].start();
			cm[i].start();
		}

	}
}

class Product
{
	Object lock;

	Product(Object lock)
	{
		this.lock = lock;
	}

	public void setValue()
	{
		// 生产者，没有产品的时候生成，有产品等待
		synchronized (lock)
		{
			if (!"".equals(ValueObject.getValue()))
			{
				try
				{
					System.out.println(Thread.currentThread().getName()
							+ "生产者进入等待");
					lock.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			}
			// 没有产品,添加产品
			ValueObject.setValue("product");
			System.out.println("唤醒消费者");
			// 唤醒消费者
			lock.notifyAll();
		}
	}
}

class ProductThread extends Thread
{
	Product p;

	ProductThread(Product p)
	{
		this.p = p;
	}

	@Override
	public void run()
	{
		while (true)
		{
			p.setValue();
		}
	}
}

class Custom
{
	Object lock;

	Custom(Object lock)
	{
		this.lock = lock;
	}

	public void setValue()
	{
		// 消费者，没有产品的时候等待，有产品消费
		synchronized (lock)
		{
			if ("".equals(ValueObject.getValue()))
			{
				try
				{
					System.out.println(Thread.currentThread().getName()
							+ "消费者等待");
					lock.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			ValueObject.setValue("");
			System.out.println("唤醒生产者");
			lock.notifyAll();
		}
	}
}

class CustomThread extends Thread
{
	Custom c;

	CustomThread(Custom c)
	{
		this.c = c;
	}

	@Override
	public void run()
	{
		while (true)
		{
			c.setValue();
		}
	}
}
