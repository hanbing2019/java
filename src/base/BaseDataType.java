package base;

/**
 * ������������
 * 
 * @author Administrator
 * 
 */
public class BaseDataType
{
	byte a;// 8λ����Χ-128 127 1���ֽ�
	short b;// 16Ϊ ��Χ -32768 32767 2���ֽ�
	int c;// 32Ϊ -2^31 2^31-1 4���ֽ�
	long d;// 64λ -2^63 2^63-1 8���ֽ�

	float e;// ��׺Ϊf����F,1λ����λ,8λָ����23λ��Чβ��,С����������7λ�� 4���ֽ�
	double f;// ��׺Ϊd����D,Ҳ���Բ�д��1λ����λ��11λָ����52Ϊ��Ч��,С����������15λ�� 8���ֽ�

	char g = 'a';// 16λ�������ͣ��õ�������������һ���ַ� ֻ����һλ�ַ�,��������һ���� 2���ֽ�
	boolean h;

	public static void main(String args[])
	{
		// 2.134709870989899
		System.out.println(1347098709898989898989898989898989898f);
		System.out.println("1347098".length());
		Integer a = new Integer(1);
		int b = 1;
		int c;
		System.out.println(a == b);

	}
	// �����������ͺͰ�װ�������
	// 1.��װ���Ƕ���ӵ���ֶκͷ���
	// 2.��װ�������õĴ��ݣ�����������ֵ�Ĵ���
	// 3.��ʼֵ��ͬ,int�ĳ�ʼֵΪ0��IntegerΪnull

}
