package thread;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool
{
	private LinkedList<Connection> pool = new LinkedList<Connection>();

	public ConnectionPool(int initial)
	{
		// 初始化连接池
		for (int i = 0; i < initial; i++)
		{
			pool.add(ConnectionUtil.getConnection());
		}
	}

	// 获取连接对象

	public Connection getConnection(long millis) throws InterruptedException
	{
		synchronized (pool)
		{
			// 等待
			// 时间<=0表示等待直到获取为止
			if (millis <= 0)
			{
				while (pool.isEmpty())
				{
					// 锁对象调用wait()方法后会放弃当前持有的锁,进入等待状态
					pool.wait();
				}
				// 从连接池头开始返回
				return pool.removeFirst();
			} else
			{

				long future = System.currentTimeMillis() + millis;
				long remaining = millis;
				// 等待remaining时长
				while (remaining > 0)
				{
					pool.wait(millis);
					remaining = future - System.currentTimeMillis();
				}

				Connection result = null;
				if (!pool.isEmpty())
				{
					result = pool.removeFirst();
				}

				return result;

			}
		}
	}

	// 释放连接池对象
	// 也就是将连接对象添加到Connection中

	public void releaseConnection(Connection conn)
	{
		if (conn == null)
			return;
		synchronized (pool)
		{
			pool.addLast(conn);
			pool.notifyAll();
		}

	}

}
