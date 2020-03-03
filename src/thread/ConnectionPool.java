package thread;

import java.sql.Connection;
import java.util.LinkedList;

public class ConnectionPool
{
	private LinkedList<Connection> pool = new LinkedList<Connection>();

	public ConnectionPool(int initial)
	{
		// ��ʼ�����ӳ�
		for (int i = 0; i < initial; i++)
		{
			pool.add(ConnectionUtil.getConnection());
		}
	}

	// ��ȡ���Ӷ���

	public Connection getConnection(long millis) throws InterruptedException
	{
		synchronized (pool)
		{
			// �ȴ�
			// ʱ��<=0��ʾ�ȴ�ֱ����ȡΪֹ
			if (millis <= 0)
			{
				while (pool.isEmpty())
				{
					// ���������wait()������������ǰ���е���,����ȴ�״̬
					pool.wait();
				}
				// �����ӳ�ͷ��ʼ����
				return pool.removeFirst();
			} else
			{

				long future = System.currentTimeMillis() + millis;
				long remaining = millis;
				// �ȴ�remainingʱ��
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

	// �ͷ����ӳض���
	// Ҳ���ǽ����Ӷ�����ӵ�Connection��

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
