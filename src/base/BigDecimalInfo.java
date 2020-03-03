package base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalInfo
{
	// bigdecimal:���Խ��д����Ĳ�������Ҫ���ȼ������ı���ʹ��BigDecimal(���о��ȼ���)
	// ���������ͣ���Ҫ��Ϊ�˿�ѧ����͹��̼��㣩������ʱ�����ṩ��ȫ��ȷ�Ľ��������ҵ����ʱ����Ҫ��ȷ�����

	public static void add(String a, String b)
	{
		BigDecimal str1 = new BigDecimal(a);
		BigDecimal str2 = new BigDecimal(b);
		BigDecimal res = str1.add(str2);
		System.out.println(res + "  " + res.setScale(1, RoundingMode.HALF_UP));
		// ����setScale��������Ҫ��Ӿ��ȿ��ƵĲ���(RoundingMode.HALF_UP)��������
		// java.lang.ArithmeticException: Rounding
		// necessary����쳣
	}

	public static void main(String args[])
	{
		BigDecimalInfo.add("10.123", "20.43");
		// �������ڽ��м����ʱ������ǧ����������С����
		// �����������ö����ƽ��о�ȷ��ʾ������ʧȥ��һЩ����
		System.out.println(1.0 - 0.8);
		System.out.println("19999999999999996".length());
		System.out.println(Float.MAX_VALUE);
		System.out.println(new BigDecimal("10.036").setScale(2,
				RoundingMode.HALF_UP));
	}
}
