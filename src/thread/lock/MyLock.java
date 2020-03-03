package thread.lock;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 
 * 自定义锁:独占锁
 * 
 */
public class MyLock
{

	private Sync sync = new Sync();

	private final static int num = 1;

	// 1.获取锁
	public void lock()
	{
		sync.acquire(num);
	}

	// 2.释放锁
	public void unlock()
	{
		sync.release(num);
	}

	private static class Sync extends AbstractQueuedSynchronizer
	{

		private static final long serialVersionUID = -6775343868729816577L;

		// 返回true，表示获取到了锁
		public boolean tryAcquire(int num)
		{
			// 状态初始值为0
			int state = getState();

			if (compareAndSetState(state, state + num))
			{
				// 成功替换，那么就获取到了锁
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
