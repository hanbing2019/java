package thread.time;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTest
{
	private static String str = "tom";

	public static void main(String[] args)
	{
		MyTask task = new MyTask();

		// ����ִ�к����û����ʧ
		// Ҫ��������ʧ��ô����timer�Ĺ��캯��Ӧ����Timer(true)
		// Timer t = new Timer(true);ִ������������ʧ
		// ��ִ��ʱ�����ڵ�ǰʱ�䣺��δ��ִ�е�Ч��
		// ִ��ʱ�����ڵ�ǰʱ�䣬����ִ��
		// t.schedule(task, new Date());

		Timer t = new Timer();
		// �����ڸ���ʱ��֮��ʼִ�У�ִ��Ƶ��4000����
		// ���ִ�������ʱ�䳬��Ƶ���ǣ������Ի�һ��һ����˳��ִ��
		// t.schedule(task, new Date(), 4000);
		// t.cancel();// ������е�����

		// ��ǰʱ��4000�����ʼִ��һ������
		// t.schedule(task, 4000);
		// ��ǰʱ��4���ʼÿ��4��ִ������
		t.schedule(task, 4000, 4000);

	}

	static class MyTask extends TimerTask
	{

		@Override
		public void run()
		{
			System.out.println("begin");
			// this.cancel();// �����ǰ����
		}

	}
}
