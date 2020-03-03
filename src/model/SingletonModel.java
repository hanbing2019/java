package model;

/**
 * ����ģʽ
 * 
 * �ŵ�:��ֹ����������Լ���ʵ������ȷ������Ψһ����Լ��ϵͳ��Դ
 * 
 * ʹ�ó�����1�����࣬2����ͳһ��Դ���߲���ͬһ����Դ��spring
 * 
 * �ô�����֤һ��class��Ӧһ��ʵ�������⹲����Դ�Ķ���ռ�ã���Լ��Դ
 * 
 * �����÷�������������ģʽ��ʵ��������������һ���µĶ���
 * 
 * @author Administrator
 * 
 */
public class SingletonModel
{
	// ʵ�ּ�ģʽ�ķ�ʽ
	// ���õ���ģʽ����Ĺ��췽��˽�л�����private���Σ���ô�����������оͲ��ܴ�������
	private SingletonModel()
	{

	}

	// 1.����ģʽ����������ص�ʱ�򴴽�ʵ���������ڶ���̴߳������ʵ�����������Դ���˷�
	// �����ڲ����������ʵ�������󣬲���װ��private static����
	private static SingletonModel singletonModel1 = new SingletonModel();

	// ����һ����̬�������ظ�ʵ��
	public static SingletonModel getInstance1()
	{
		return singletonModel1;
	}

	// 2.����ģʽ������Ҫʵ����ʱ��ȥ����,�ٴλ�ȡ��ʱ��Ͳ������´����������ڶ��̲߳����лᴴ�����ʵ��
	// �����Ҫ����������߳�ͬ������,������ʵ�����ӳټ��أ�Ч�ʽ�����
	private static SingletonModel singletonModel2 = null;

	public static synchronized SingletonModel getInstance2()
	{
		if (singletonModel2 == null)
		{
			singletonModel2 = new SingletonModel();
		}
		return singletonModel2;
	}

	// 3.˫��У����:��ͬ�������ִ��֮ǰ��һ������Ƿ�Ϊ�յ��жϣ���û�ж����ʱ����ִ��ͬ������飬��������
	// volatile:��ֹ����ָ���������Ż�����֤���󱻸�ֵ��ʱ���Ѿ��ǳ�ʼ������
	private static volatile SingletonModel singletonModel3 = null;

	public static SingletonModel getInstance3()
	{
		// ��ͬ�������ǰ���һ�����ǿ��ж�
		if (singletonModel3 == null)
		{
			synchronized (SingletonModel.class)
			{
				if (singletonModel3 == null)
				{
					singletonModel3 = new SingletonModel();
				}
			}
		}
		return singletonModel3;
	}

	// 4.��̬�ڲ���ʵ�ֵ���:��������ػ���������ʵ�������ڲ����д���ʵ����ֻҪ��ʹ���ڲ��࣬
	// jvm�Ͳ���������ʵ��,ͬʱ��֤���̰߳�ȫ���ӳټ���
	private static class SingletonModelHandler
	{
		public static SingletonModel singletonModel4 = new SingletonModel();

		public static SingletonModel newInstance()
		{
			return SingletonModelHandler.singletonModel4;
		}
	}

	public static void main(String args[])
	{
		SingletonModel s = SingletonModel.SingletonModelHandler.newInstance();
		// ArrayList
	}
}
