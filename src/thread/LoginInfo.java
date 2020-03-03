package thread;

public class LoginInfo
{
	private static String name;
	private static String password;

	synchronized public static void login(String name, String password)
	{
		try
		{
			LoginInfo.name = name;
			if ("a".equals(name))
			{
				Thread.sleep(5000);
			}
			LoginInfo.password = password;
			System.out.println("name = " + LoginInfo.name + "password = "
					+ LoginInfo.password);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		// Alogin a = new Alogin();
		// a.start();
		// Blogin b = new Blogin();
		// b.start();

		// InterruptThread it = new InterruptThread();
		// it.start();
		// Thread.sleep(1000);
		// it.interrupt();

		// spThread sp = new spThread();
		// sp.start();
		// Thread.sleep(2000);
		// sp.suspend();
		// System.out.println("getI= " + sp.getI());
		// Thread.sleep(2000);
		// System.out.println("getI= " + sp.getI());
		// sp.resume();
		// Thread.sleep(2000);
		// System.out.println("getI= " + sp.getI());

		// AccountAdd aa = new AccountAdd(1);
		// NumAThread na = new NumAThread(aa);
		// na.setName("a");
		// na.start();
		// AccountAdd bb = new AccountAdd(1);
		// NumBThread nb = new NumBThread(bb);
		// nb.setName("b");
		// nb.start();

		// publicValue pv = new publicValue();
		// ValueThread vt = new ValueThread(pv);
		// vt.start();
		// Thread.sleep(200);
		// pv.getValue();

		// ObjectService os = new ObjectService();
		// ServiceThread st1 = new ServiceThread(os);
		// st1.setName("str1");
		// st1.start();
		// ServiceThread st2 = new ServiceThread(os);
		// st2.setName("str2");
		// st2.start();
		Myservice ms = new Myservice();
		MyObject mo = new MyObject();
		// MyObject mo1 = new MyObject();

		// ServiceThreadA sta = new ServiceThreadA(ms, mo);
		// sta.setName("A");
		// sta.start();
		// ServiceThreadB stb = new ServiceThreadB(ms, mo);
		// stb.setName("B");
		// stb.start();

		// ServiceObject so = new ServiceObject();
		//
		// StrAThread sat = new StrAThread(so);
		// sat.setName("A");
		// sat.start();
		// StrBThread sbt = new StrBThread(so);
		// sbt.setName("B");
		// sbt.start();

		DealThread dt1 = new DealThread();
		dt1.setName("a");
		Thread t1 = new Thread(dt1);
		t1.start();
		Thread.sleep(1000);
		dt1.setName("b");
		Thread t2 = new Thread(dt1);
		t2.start();

	}
}

class Alogin extends Thread
{

	@Override
	public void run()
	{
		LoginInfo.login("a", "aa");
	}
}

class Blogin extends Thread
{

	@Override
	public void run()
	{
		LoginInfo.login("b", "bb");
	}
}

class InterruptThread extends Thread
{
	@Override
	public void run()
	{
		while (true)
		{
			System.out.println("---action---");
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (this.interrupted())
			{
				System.out.println("Í£Ö¹Ïß³Ì");
				// return;
			}

		}

	}
}

class spThread extends Thread
{
	long i = 0;

	public long getI()
	{
		return i;
	}

	public void setI(long i)
	{
		this.i = i;
	}

	public void run()
	{
		while (true)
		{
			i++;
		}

	}
}

class AccountAdd
{
	int a;

	AccountAdd(int n)
	{
		a = n;
	}

	public int getA()
	{
		return a;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	synchronized public void add()
	{
		a++;
		if (Thread.currentThread().getName().equals("a"))
		{
			System.out.println("a thread");
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		} else
		{
			System.out.println("b -thread");
		}

		System.out.println("thread = " + Thread.currentThread().getName() + a);
	}
}

class NumAThread extends Thread
{
	AccountAdd aa;

	NumAThread(AccountAdd aa)
	{
		this.aa = aa;
	}

	@Override
	public void run()
	{
		aa.add();
	}
}

class NumBThread extends Thread
{
	AccountAdd aa;

	NumBThread(AccountAdd aa)
	{
		this.aa = aa;
	}

	@Override
	public void run()
	{
		aa.add();
	}
}

class publicValue
{
	String name = "a";
	String pas = "b";

	synchronized public void setValue(String name, String pas)
	{
		try
		{
			this.name = name;
			Thread.sleep(5000);
			this.pas = pas;
			System.out.println("name = " + name + " pas = " + pas);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	synchronized public void getValue()
	{
		System.out.println("name = " + name + " pas = " + pas);
	}
}

class ValueThread extends Thread
{
	publicValue pv;

	ValueThread(publicValue pv)
	{
		this.pv = pv;
	}

	@Override
	public void run()
	{
		pv.setValue("name", "pwd");
	}
}

class ObjectService
{
	public void func()
	{
		synchronized (this)
		{
			System.out.println("name = " + Thread.currentThread().getName()
					+ System.currentTimeMillis());
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("name = " + Thread.currentThread().getName()
					+ System.currentTimeMillis());

		}
	}
}

class ServiceThread extends Thread
{
	ObjectService os;

	ServiceThread(ObjectService os)
	{
		this.os = os;
	}

	public void run()
	{
		os.func();
	}
}

class MyObject
{
	synchronized public void testMethod()
	{
		System.out.println("myobject func");
	}

	public void testfunc()
	{
		synchronized (this)
		{
			System.out.println("name = " + Thread.currentThread().getName()
					+ " " + System.currentTimeMillis());
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("name = " + Thread.currentThread().getName()
					+ " " + System.currentTimeMillis());
		}
	}

}

class Myservice
{
	public void func(MyObject obj)
	{
		synchronized (obj)
		{
			System.out.println("name = " + Thread.currentThread().getName()
					+ " " + System.currentTimeMillis());
			try
			{
				Thread.sleep(2000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("name = " + Thread.currentThread().getName()
					+ " " + System.currentTimeMillis());
		}

	}
}

class ServiceThreadA extends Thread
{
	Myservice ms;
	MyObject mo;

	ServiceThreadA(Myservice ms, MyObject mo)
	{
		this.ms = ms;
		this.mo = mo;
	}

	@Override
	public void run()
	{
		ms.func(mo);
	}
}

class ServiceThreadB extends Thread
{
	Myservice ms;
	MyObject mo;

	ServiceThreadB(Myservice ms, MyObject mo)
	{
		this.ms = ms;
		this.mo = mo;
	}

	@Override
	public void run()
	{
		// ms.func(mo);
		mo.testfunc();
	}
}

class ServiceObject
{
	public void printInfo(Object obj) throws InterruptedException
	{
		synchronized (obj)
		{
			while (true)
			{
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			}

		}

	}

	public void test(String str) throws InterruptedException
	{
		synchronized (str)
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(1000);
			}
			/*
			 * while (true) {
			 * System.out.println(Thread.currentThread().getName());
			 * Thread.sleep(1000); }
			 */
		}

	}
}

class StrAThread extends Thread
{
	ServiceObject so;

	StrAThread(ServiceObject so)
	{
		this.so = so;
	}

	@Override
	public void run()
	{
		try
		{
			so.printInfo(new Object());
			// so.test("a");
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class StrBThread extends Thread
{
	ServiceObject so;

	StrBThread(ServiceObject so)
	{
		this.so = so;
	}

	@Override
	public void run()
	{
		try
		{
			so.printInfo(new Object());
			// so.test("a");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

class DealThread implements Runnable
{
	Object lock1 = new Object();
	Object lock2 = new Object();

	public String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public void run()
	{
		if ("a".equals(name))
		{
			synchronized (lock1)
			{
				System.out.println("lock1 " + name);
				try
				{
					Thread.sleep(3000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (lock2)
				{
					System.out.println("lock1->lock2");
				}

			}

		}
		if ("b".equals(name))
		{
			synchronized (lock2)
			{
				System.out.println("lock2 " + name);
				try
				{
					Thread.sleep(3000);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				synchronized (lock1)
				{
					System.out.println("lock2->lock1");
				}

			}
		}

	}

}