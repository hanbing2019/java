package base;

/**
 * �ӿڣ��ؼ���interface���ڽӿ��ڿ��Զ�������ͷ���
 * 
 * �ӿڲ�Ϊpublicʱ�����Զ�����ʽ����ת��Ϊ���г��󷽷���Ҳ���ܽ�����ת��Ϊ���е�
 * 
 * �ǹ��нӿڵķ����ͱ���Ҳ�Ƿǹ��еģ�ֻ����ͬһ����߰���ʹ�ã�һ����ָû�йؼ������εĽӿ�
 * 
 */
public interface NewImpl
{
	public abstract void func1();// ֱ�Ӷ��幫�еĳ��󷽷���

	void func2();// ��ʽ���幫�г��󷽷��� ������ʹ�ùؼ��֣�ϵͳ��ת��Ϊ���еĳ��󷽷�--��public abstract void
					// func1();

	// �ӿڶ���ı��������ǹ��У�final���ε������
	// ����ֱ�Ӷ���
	public final static String str = "value";
	// Ҳ������ʽ�Ķ���
	int num = 1;// --->ת��Ϊpublic final static int num=1;
}
