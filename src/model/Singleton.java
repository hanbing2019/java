package model;

import java.util.concurrent.atomic.AtomicReference;

public class Singleton
{
	// ����ԭ��������
	private AtomicReference<Singleton> instance = new AtomicReference<>();

	public Singleton getInstanc()
	{
		// ����ѭ����ֱ����ȡֵ
		for (;;)
		{
			// ��ȡ��ǰ��value
			Singleton s = instance.get();
			if (s != null)
			{
				// ��Ϊ�վ�ֱ�ӷ���
				return s;
			}
			s = new Singleton();
			// ��������s��Ϊ����������ֵnull���бȽ��滻������滻�ɹ�����ô��ǰ�����Ķ�����ǵ������󣬲��ɹ��ͽ�����һ��ѭ���ж�
			if (instance.compareAndSet(null, s))
				return s;
		}

	}
}
