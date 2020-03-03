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
		// һ�����ߺ�һ������
		ProductThread pt = new ProductThread(p);
		// pt.start();
		CustomThread ct = new CustomThread(c);
		// ct.start();
		// �������ߺͶ������ߣ����ѵȴ��߳���notifyAll();��notify�п��ܻ��ѵ���ͬ��ĵȴ��߳�
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
		// �����ߣ�û�в�Ʒ��ʱ�����ɣ��в�Ʒ�ȴ�
		synchronized (lock)
		{
			if (!"".equals(ValueObject.getValue()))
			{
				try
				{
					System.out.println(Thread.currentThread().getName()
							+ "�����߽���ȴ�");
					lock.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

			}
			// û�в�Ʒ,��Ӳ�Ʒ
			ValueObject.setValue("product");
			System.out.println("����������");
			// ����������
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
		// �����ߣ�û�в�Ʒ��ʱ��ȴ����в�Ʒ����
		synchronized (lock)
		{
			if ("".equals(ValueObject.getValue()))
			{
				try
				{
					System.out.println(Thread.currentThread().getName()
							+ "�����ߵȴ�");
					lock.wait();
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			ValueObject.setValue("");
			System.out.println("����������");
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
