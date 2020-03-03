package thread;

public class ThreadInfo
{
	// 线程状态
	// 1NEW 线程还没有启动过
	// 2RUNNABLE正在执行
	// 3BLOCK等待执行，阻碍状态
	// 4WAITING
	// 5TIME_WAITING
	// 6TERMINATED
	public static void main(String[] args)
	{
		User u = new User("张三", 100);
		MyThread2 t1 = new MyThread2("线程A", u, 20);
		MyThread2 t2 = new MyThread2("线程B", u, -60);
		MyThread2 t3 = new MyThread2("线程C", u, -80);
		MyThread2 t4 = new MyThread2("线程D", u, -30);
		MyThread2 t5 = new MyThread2("线程E", u, 32);
		MyThread2 t6 = new MyThread2("线程F", u, 21);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}
}

class MyThread2 extends Thread
{
	private User u;
	private int y = 0;

	MyThread2(String name, User u, int y)
	{
		super(name);
		this.u = u;
		this.y = y;
	}

	public void run()
	{
		u.oper(y);
	}
}

class User
{
	private String code;
	private int cash;

	User(String code, int cash)
	{
		this.code = code;
		this.cash = cash;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	/**
	 * 业务方法
	 * 
	 * @param x
	 *            添加x万元
	 */
	public synchronized void oper(int x)
	{
		try
		{
			Thread.sleep(10L);
			this.cash += x;
			System.out.println(Thread.currentThread().getName() + "运行结束，增加“"
					+ x + "”，当前用户账户余额为：" + cash);
			Thread.sleep(10L);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public String toString()
	{
		return "User{" + "code='" + code + '\'' + ", cash=" + cash + '}';
	}
}
