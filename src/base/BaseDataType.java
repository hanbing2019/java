package base;

/**
 * 基本数据类型
 * 
 * @author Administrator
 * 
 */
public class BaseDataType
{
	byte a;// 8位，范围-128 127 1个字节
	short b;// 16为 范围 -32768 32767 2个字节
	int c;// 32为 -2^31 2^31-1 4个字节
	long d;// 64位 -2^63 2^63-1 8个字节

	float e;// 后缀为f或者F,1位符号位,8位指数，23位有效尾数,小数点后最多有7位数 4个字节
	double f;// 后缀为d或者D,也可以不写，1位符号位，11位指数，52为有效数,小数点后最多有15位数 8个字节

	char g = 'a';// 16位整数类型，用单引号括起来的一个字符 只能是一位字符,本质上是一个数 2个字节
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
	// 基本数据类型和包装类的区别
	// 1.包装类是对象，拥有字段和方法
	// 2.包装类是引用的传递，基本类型是值的传递
	// 3.初始值不同,int的初始值为0，Integer为null

}
