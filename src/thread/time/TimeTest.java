package thread.time;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest
{
	private static String str = "tom";

	public static void main(String[] args)
	{
		MyTask task = new MyTask();

		// 任务执行后进程没有消失
		// 要是任务消失那么创建timer的构造函数应该是Timer(true)
		// Timer t = new Timer(true);执行任务后进程消失
		// 在执行时间晚于当前时间：在未来执行的效果
		// 执行时间早于当前时间，立即执行
		// t.schedule(task, new Date());

		Timer t = new Timer();
		// 任务在给定时间之后开始执行，执行频率4000毫秒
		// 如果执行任务的时间超过频率是，任务仍会一个一个的顺序执行
		// t.schedule(task, new Date(), 4000);
		// t.cancel();// 清除所有的任务

		// 当前时间4000毫秒后开始执行一次任务
		// t.schedule(task, 4000);
		// 当前时间4秒后开始每隔4秒执行任务，
		t.schedule(task, 4000, 4000);

	}

	static class MyTask extends TimerTask
	{

		@Override
		public void run()
		{
			System.out.println("begin");
			// this.cancel();// 清除当前任务
		}

	}
}
