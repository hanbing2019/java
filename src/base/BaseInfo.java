package base;

import java.awt.Point;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

public class BaseInfo
{

	// 类变量或者静态变量：它的值适用于所有的类
	// 定义类变量是在定义变量之前加关键字static
	// 访问类变量：1可以使用实例对象，实例对象名.类变量名；2直接使用类名，类名.类变量名（推荐）
	static String str = "deafult";

	// 实例变量:不用static修饰并且不在方法中定义的变量
	String str1;

	// 创建数组对象的时候，必须制定数组的大小
	String[] arr = new String[10];

	// 创建数组的时候初始化,将数组元素放到花括号中，并用逗号隔开
	String[] arr1 =
	{ "str1", "str4", "str3", "str2" };
	Point[] point =
	{ new Point(1, 2), new Point(3, 4) };
	// final关键字修饰变量,变量的值不能修改，该变量通常被称为常量
	// final修饰变量时通常和static一起使用，方便访问
	final static String value = "dd";

	/**
	 * 构造方法:方法名称为类名，没有返回类型，不能使用return返回值；可以定义多个构造方法，但是方法的参数不能相同
	 * 
	 * 构造方法可以用来初始化实例变量参数，调用基于这些变量的方法
	 * 
	 */

	public BaseInfo()
	{

	}

	public BaseInfo(String str1, String[] arr, String[] arr1, Point[] point)
	{
		super();
		this.str1 = str1;
		this.arr = arr;
		this.arr1 = arr1;
		this.point = point;
	}

	/**
	 * 字符串对象的一些方法
	 * 
	 * @param str
	 */
	public void StringFunc(String str)
	{
		// 字符串的长度length()
		int len = str.length();
		// 字符串给定位置的字符
		// 字符串从0开始，位置为2的字符
		char charstr = str.charAt(2);
		// 字符串截取
		// substring(beginIndex, endIndex),从开始beginIndex到endIndex结束截取字符串
		String substr = str.substring(2, 4);
		// 字符串indeof方法
		// indexof(str)返回字符串第一次出现str的开始位置
		// indexof(str,start)返回字符串从start位置开始第一次出现str的开始位置
		int indstr = str.indexOf("se");
		int indstr1 = str.indexOf("se", 3);
		// 字符串小写字母转大写
		String uppstr = str.toUpperCase();
		// 字符串大写字母转小写
		String lowstr = str.toLowerCase();

	}

	/**
	 * 静态方法：使用关键字static修饰的方法，通常作为工具方法 ,
	 * 
	 * 通过类名直接访问,也可以通过实例对象访问但是一般不使用
	 */
	public static void staticfunc(String obj)
	{
		System.out.println("staticfunc");
	}

	public void funcYy()
	{
		// 对象的引用
		// 引用是一个地址，它指明了对象的变量和方法的存储位置
		Point p1, p2;
		p1 = new Point();
		// 将p1赋值给p2,让p2引用p1，p2使用p1的方法和变量
		// p2引用的对象和p1相同
		p2 = p1;
		p1.x = 100;
		p2.y = 200;

		// p1，p2的x,y值相同
		System.out.println(p1.y);
	}

	/**
	 * 强制转换基本类型;基本类型中的布尔类型不能强制转换；
	 * 
	 * 大范围的类型转换为小范围的类型必须强制转换 ，否则会丢失精度
	 * 
	 * 低精度转高精度自动转换
	 * 
	 * 大范围数据类型转小范围，数据必须在小范围数据包含的数据范围内
	 */
	public void changeBaseType()
	{
		// 数据类型精度和范围排序
		// byte short int long float double
		int a = 10;
		double b = a;// 系统自动转换
		// /////////////////
		double c = 2.01;
		int d = (int) c;// 高精度转低精度，强制转换（int）,小数点后的丢失

	}

	/**
	 * 强制转换对象
	 * 
	 * 转换的条件：转换的目标和源必须是继承关系
	 * 
	 * 父类转子类：需要强制转换
	 * 
	 * 子类转父类： 自动转换
	 * 
	 */
	public void changeobj()
	{
		//
		Bird bird = new Bird();
		Eagle eagle = new Eagle();
		// 父类转子类
		eagle = (Eagle) bird;
		// 子类转父类
		bird = eagle;
	}

	/**
	 * 基本类型的值比较可以使用等于，小于，不等于（= !=）这些方式，
	 * 
	 * 但是比较对象的时候就不能这样使用,
	 * 
	 * 因为它不是去比较对象的值是否相同而是判断2个对象是否指向同一个引用
	 * 
	 */
	public static void compare()
	{
		String a = "test";
		String b = a;
		// 基本类型的值比较
		System.out.println("b= " + b);
		System.out.println(b == a);// 这里结果为true

		String c = new String(b);// c为对象
		System.out.println("///////////////////////////");
		System.out.println("c= " + c);
		System.out.println(c == b);// 结果为false，他们在内存中不是同一个对象
		// 比较String对象和基本类型String的值使用equal()
		System.out.println(c.equals(b));// 结果为true

	}

	/**
	 * 判读对象类型
	 * 
	 */
	public static void typeOper()
	{
		String a = new String("test");
		Integer b = new Integer(2);
		// 1 a.getClass().getName();获取对象所属的类名
		// 2.用instanceof，左边表示对象的引用，右边是类名
		System.out.println(a instanceof String);
	}

	/**
	 * 数组访问
	 * 
	 * 访问数组的元素的时候，当超过数组长度的时候会报数组越界异常
	 */
	public void array()
	{
		// 访问数组元素：数组名[下标]
		// arr.length数组的长度
		String item = arr[arr.length - 1];
	}

	// 复制数组
	public static void arrayFunc()
	{
		int[] a =
		{ 1, 2, 3, 4 };
		int[] b =
		{ 5, 6, 7, 8 };
		// 将数组a的内容复制到b
		// a:数组源
		// b:目标数组
		// 第一个0：开始赋值的起始位置
		// 第二个0：数组b接收数据的起始位置
		// a.length，赋值数组的长度
		System.arraycopy(a, 0, b, 0, a.length);
		for (int i : b)
		{
			System.out.println(i);
		}
	}

	public static void arraysort()
	{
		// 数组排序
		int[] a =
		{ 1, 3, 5, 1, 2, 4 };
		Arrays.sort(a);
		for (int i : a)
		{
			System.out.println(i);
		}
	}

	/**
	 * 语句块：用花括号开始和结束{}
	 * 
	 * @param args
	 */
	public static void testBlock()
	{
		//
		int x = 3;
		System.out.println("x= " + x);
		{
			int y = 3;
			x = 9;
			// 语句块可以使用快外部变量，
			// 语句块内部定义的变量只能内部使用，是局部变量
			System.out.println("x= " + x);
			System.out.println("y= " + y);
		}
		System.out.println(x);

	}

	/**
	 * if 关键字 使用布尔表达式来判断是否执行
	 * 
	 * @param args
	 */
	public void testIf()
	{
		if (true)
		{
			System.out.println("ok");

		}
	}

	/**
	 * switch 关键字
	 * 
	 * @param args
	 */
	public static void switchTest()
	{
		byte s = 1;
		switch (s)
		{
		case 1:// 测试变量不能超过输入变量的范围，否则编制不通过，直接报错
			System.out.println("ss");
			break;
		// break用于停止当前语句，
		// 如果没有，下一个case的语句也会执行，直到出现break,或者执行完
		case 12:
			System.out.println("dd");
			break;
		default:// default关键字是可选关键字，表示和前面变量都不匹配后执行
			System.out.println("null");
			break;
		}
	}

	/**
	 * for循环
	 * 
	 * @param args
	 */
	public void forTest()
	{
		int a = 1;
		int b = 2;
		// for (init; test; increment)
		// init初始化循环参数，只执行一次
		// increment循环最后执行
		// test循环条件判断
		for (int i = 1; i < 10; i++)
		{
		}
		// 跳出循环
		// break直接结束循环
		// continue

	}

	static boolean foo(char c)
	{
		System.out.print(c);
		return true;
	}

	public void testFoo()
	{
		int i = 0;
		for (foo('A'); foo('B') && (i < 2); foo('C'))
		{
			i++;
			foo('D');
		}
		// ABDCBDCB
	}

	/**
	 * 关键字 this 指当前向对象，只能在实例方法中使用，类方法中不能使用
	 * 
	 */
	public void thisTest()
	{
		String ss = this.str;
	}

	/**
	 * 类方法：用关键字static修饰的方法，可以被类使用 也可以被实例使用
	 * 
	 * 实例方法：不用static修饰，只能在对象中运行，不能在类中运行
	 * 
	 * @param args
	 */

	/**
	 * 方法重载：多个方法名称相同但是参数个数或者参数类型不同成为方法重载，
	 * 
	 * 返回类型不是作为方法重载的判断条件：如果2个方法的名称，参数类型或数量相同，返回的类型不同那么会编译出错
	 * 
	 * @param args
	 */
	public void func()
	{
		System.out.println("func");
	}

	public void func(int a)
	{

	}

	public void func(String str)
	{

	}

	/**
	 * 访问权限控制：public proteced private 默认（不使用关键字）
	 * 
	 * 默认：在同一保重的任何类都可以访问
	 * 
	 * private:完全讲方法和变量隐藏，处理自身所在的类其他类不能访问，要访问变量只能通过getXXX()方法
	 * 
	 * public :public修饰的类或者方法能够被任何类使用
	 * 
	 * protected：被子类和同一包的其他类使用
	 * 
	 */
	/**
	 * java数据结构：java.util包中提供了许多数据结构，包括接口iterator,map和类BitSet,vector,stack,
	 * hashtable
	 * 
	 * @param args
	 */
	public static void dataFunc()
	{
		// iterator本身不是数据结构，但是它定义了一种连续检索数据的中元素的方式
		String[] arr =
		{ "a", "b", "c", "d", "e" };
		List<String> list = new ArrayList<String>();

		list = Arrays.asList(arr);
		Iterator<String> iterator = list.iterator();
		// iterator.hasNext()判断是否有下一个元素，返回布尔类型
		while (iterator.hasNext())
		{
			// iterator.next()返回值或者类型（object）
			System.out.println(iterator.next());
		}
		// BitSet位组
		BitSet bs = new BitSet();
		// vector 矢量，可以缩放的数组，实现了List接口；操作类似arraylist
		Vector vector = new Vector();
		// Stack堆栈 继承Vector
		Stack s = new Stack();
		// 接口Map：是一个键值映射数据的框架，键值类似与vector的索引

		// hashtable散列表 实现了接口Map
		Map hashtable = new Hashtable();
	}

	public static void main(String[] args)
	{
		// BaseInfo.arraysort();

		// BaseInfo.switchTest();
		// BaseInfo.typeOper();
		// BaseInfo base = new BaseInfo();
		// base.getClass().getName()返回对象所属类的名称
		// System.out.println(base.getClass().getName());
		//
		// base.funcYy();

		// System.out.println(base.str);
		// System.out.println(BaseInfo.str.charAt(2));
		// String str = "Baseas2Insefo";
		// System.out.println(str.indexOf("se", 9));

		TreeMap<String, String> tm = new TreeMap<String, String>();
		tm.put("a", "tom");
		tm.put("c", "dim");
		tm.put("b", "com");
		System.out.println(tm);

	}
}

class Bird
{
	String cry;
	String name;

	public Bird()
	{
		System.out.println("Bird");
	}

	public Bird(String cry, String name)
	{
		super();
		this.cry = cry;
		this.name = name;
	}

	public void fly(String str)
	{
		System.out.println("Bird fly" + str);
	}

	protected void work()
	{
		System.out.println("bird work");
	}

	void sleep()
	{
		System.out.println("bird sleep");
	}

	private void hold()
	{
		System.out.println("bird hold");
	}

	/**
	 * final修饰的方法不能被子类覆该方法 代码的灵活性降低，但是效率提高了
	 */
	final void testFinal()
	{

	}
}

class Eagle extends Bird
{

	String wings;

	/**
	 * 构造方法覆盖（重写）
	 */
	public Eagle()
	{
		super();// 调用不带参数构造方法
	}

	public Eagle(String wings, String cry, String name)
	{
		super(cry, name);// 调用带参构造方法
	}

	/**
	 * 方法重写（覆盖）：子类中创建一个返回类型，方法名称和参数都相同的方法
	 * 
	 * 方法覆盖可以从新定义，增加新的操作，在子类 中隐藏父类的方法
	 * 
	 * 调用父类的方法用关键字super.方法，super表示父类
	 * 
	 * 当父类方法是public是子类必须是public,父类private方法不能重写
	 */
	public void fly(String str)
	{
		System.out.println("Eagle fly" + str);
	}

	/**
	 * 访问控制和继承
	 * 
	 * 父类方法是private的时候不能被继承
	 * 
	 * 当父类方法访问权限是protected是子类重新方法访问权限可以为public或者protected
	 */
	protected void work()
	{

	}

	/**
	 * 父类是默认权限时
	 * 
	 * 可以是public，protected或者也是默认的
	 */

	protected void sleep()
	{

	}

	public static void main(String args[])
	{
		Eagle e = new Eagle();
		e.fly("ff");
	}
}

// final修饰的类不能被继承，代码的灵活性降低，但是效率提高了
final class finalClass
{
	String name = "dd";
}

class WebReader
{
	/**
	 * 获取address地址页面信息
	 * 
	 * @param address
	 */
	public void getData(String address)
	{
		try
		{
			// URL网路地址对象，加载资源地址 。address 带http的地址
			URL page = new URL(address);
			// HttpURLConnection对象，能够加载url并且连接站点
			HttpURLConnection conn = (HttpURLConnection) page.openConnection();
			// 建立连接
			conn.connect();
			// 读取url数据流
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = br.readLine()) != null)
			{
				sb.append(line);
			}
			System.out.println(sb.toString());
		} catch (MalformedURLException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	public void socketFunc()
	{
		try
		{
			Socket socket = new Socket("", 21);

			BufferedOutputStream os = new BufferedOutputStream(
					socket.getOutputStream());
			DataOutputStream output = new DataOutputStream(os);
			// output.writeChars(s);
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		WebReader web = new WebReader();
		String address = "http://www.baidu.com";
		web.getData(address);
	}
}