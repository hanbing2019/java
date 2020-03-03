package thread.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 
 * �Զ�����:��ռ��
 * 
 */
public class MyLock
{

	private Sync sync = new Sync();

	private final static int num = 1;

	// 1.��ȡ��
	public void lock()
	{
		sync.acquire(num);
	}

	// 2.�ͷ���
	public void unlock()
	{
		sync.release(num);
	}

	private static class Sync extends AbstractQueuedSynchronizer
	{

		private static final long serialVersionUID = -6775343868729816577L;

		// ����true����ʾ��ȡ������
		public boolean tryAcquire(int num)
		{
			// ״̬��ʼֵΪ0
			int state = getState();

			if (compareAndSetState(state, state + num))
			{
				// �ɹ��滻����ô�ͻ�ȡ������
				return true;
			}

			return false;
		}

		public boolean tryRelease(int num)
		{
			int state = getState();

			if (compareAndSetState(state, state - num) && getState() == 0)
			{
				return true;
			}

			return false;
		}
	}

}
