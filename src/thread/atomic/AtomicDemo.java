package thread.atomic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AtomicInteger ai;
		AtomicBoolean ab;
		Thread s = new Thread();
		CyclicBarrier cb = new CyclicBarrier(1);
		Runnable barrierAction = new Runnable()
		{

			@Override
			public void run()
			{

			}
		};
		cb = new CyclicBarrier(1, barrierAction);

	}

}
