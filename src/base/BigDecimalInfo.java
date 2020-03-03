package base;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalInfo
{
	// bigdecimal:可以进行大数的操作；需要精度计算结果的必须使用BigDecimal(进行精度计算)
	// 浮点数类型（主要是为了科学计算和工程计算）：计算时不能提供完全精确的结果，在商业计算时往往要求精确结果，

	public static void add(String a, String b)
	{
		BigDecimal str1 = new BigDecimal(a);
		BigDecimal str2 = new BigDecimal(b);
		BigDecimal res = str1.add(str2);
		System.out.println(res + "  " + res.setScale(1, RoundingMode.HALF_UP));
		// 调用setScale方法是需要添加精度控制的参数(RoundingMode.HALF_UP)否则会出现
		// java.lang.ArithmeticException: Rounding
		// necessary这个异常
	}

	public static void main(String args[])
	{
		BigDecimalInfo.add("10.123", "20.43");
		// 浮点数在进行计算的时候会出现千万或者亿万的小数误差，
		// 浮点数不能用二进制进行精确表示，导数失去了一些精度
		System.out.println(1.0 - 0.8);
		System.out.println("19999999999999996".length());
		System.out.println(Float.MAX_VALUE);
		System.out.println(new BigDecimal("10.036").setScale(2,
				RoundingMode.HALF_UP));
	}
}
