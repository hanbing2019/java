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

	// ��������߾�̬����������ֵ���������е���
	// ������������ڶ������֮ǰ�ӹؼ���static
	// �����������1����ʹ��ʵ������ʵ��������.���������2ֱ��ʹ������������.����������Ƽ���
	static String str = "deafult";

	// ʵ������:����static���β��Ҳ��ڷ����ж���ı���
	String str1;

	// ������������ʱ�򣬱����ƶ�����Ĵ�С
	String[] arr = new String[10];

	// ���������ʱ���ʼ��,������Ԫ�طŵ��������У����ö��Ÿ���
	String[] arr1 =
	{ "str1", "str4", "str3", "str2" };
	Point[] point =
	{ new Point(1, 2), new Point(3, 4) };
	// final�ؼ������α���,������ֵ�����޸ģ��ñ���ͨ������Ϊ����
	// final���α���ʱͨ����staticһ��ʹ�ã��������
	final static String value = "dd";

	/**
	 * ���췽��:��������Ϊ������û�з������ͣ�����ʹ��return����ֵ�����Զ��������췽�������Ƿ����Ĳ���������ͬ
	 * 
	 * ���췽������������ʼ��ʵ���������������û�����Щ�����ķ���
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
	 * �ַ��������һЩ����
	 * 
	 * @param str
	 */
	public void StringFunc(String str)
	{
		// �ַ����ĳ���length()
		int len = str.length();
		// �ַ�������λ�õ��ַ�
		// �ַ�����0��ʼ��λ��Ϊ2���ַ�
		char charstr = str.charAt(2);
		// �ַ�����ȡ
		// substring(beginIndex, endIndex),�ӿ�ʼbeginIndex��endIndex������ȡ�ַ���
		String substr = str.substring(2, 4);
		// �ַ���indeof����
		// indexof(str)�����ַ�����һ�γ���str�Ŀ�ʼλ��
		// indexof(str,start)�����ַ�����startλ�ÿ�ʼ��һ�γ���str�Ŀ�ʼλ��
		int indstr = str.indexOf("se");
		int indstr1 = str.indexOf("se", 3);
		// �ַ���Сд��ĸת��д
		String uppstr = str.toUpperCase();
		// �ַ�����д��ĸתСд
		String lowstr = str.toLowerCase();

	}

	/**
	 * ��̬������ʹ�ùؼ���static���εķ�����ͨ����Ϊ���߷��� ,
	 * 
	 * ͨ������ֱ�ӷ���,Ҳ����ͨ��ʵ��������ʵ���һ�㲻ʹ��
	 */
	public static void staticfunc(String obj)
	{
		System.out.println("staticfunc");
	}

	public void funcYy()
	{
		// ���������
		// ������һ����ַ����ָ���˶���ı����ͷ����Ĵ洢λ��
		Point p1, p2;
		p1 = new Point();
		// ��p1��ֵ��p2,��p2����p1��p2ʹ��p1�ķ����ͱ���
		// p2���õĶ����p1��ͬ
		p2 = p1;
		p1.x = 100;
		p2.y = 200;

		// p1��p2��x,yֵ��ͬ
		System.out.println(p1.y);
	}

	/**
	 * ǿ��ת����������;���������еĲ������Ͳ���ǿ��ת����
	 * 
	 * ��Χ������ת��ΪС��Χ�����ͱ���ǿ��ת�� ������ᶪʧ����
	 * 
	 * �;���ת�߾����Զ�ת��
	 * 
	 * ��Χ��������תС��Χ�����ݱ�����С��Χ���ݰ��������ݷ�Χ��
	 */
	public void changeBaseType()
	{
		// �������;��Ⱥͷ�Χ����
		// byte short int long float double
		int a = 10;
		double b = a;// ϵͳ�Զ�ת��
		// /////////////////
		double c = 2.01;
		int d = (int) c;// �߾���ת�;��ȣ�ǿ��ת����int��,С�����Ķ�ʧ

	}

	/**
	 * ǿ��ת������
	 * 
	 * ת����������ת����Ŀ���Դ�����Ǽ̳й�ϵ
	 * 
	 * ����ת���ࣺ��Ҫǿ��ת��
	 * 
	 * ����ת���ࣺ �Զ�ת��
	 * 
	 */
	public void changeobj()
	{
		//
		Bird bird = new Bird();
		Eagle eagle = new Eagle();
		// ����ת����
		eagle = (Eagle) bird;
		// ����ת����
		bird = eagle;
	}

	/**
	 * �������͵�ֵ�ȽϿ���ʹ�õ��ڣ�С�ڣ������ڣ�= !=����Щ��ʽ��
	 * 
	 * ���ǱȽ϶����ʱ��Ͳ�������ʹ��,
	 * 
	 * ��Ϊ������ȥ�Ƚ϶����ֵ�Ƿ���ͬ�����ж�2�������Ƿ�ָ��ͬһ������
	 * 
	 */
	public static void compare()
	{
		String a = "test";
		String b = a;
		// �������͵�ֵ�Ƚ�
		System.out.println("b= " + b);
		System.out.println(b == a);// ������Ϊtrue

		String c = new String(b);// cΪ����
		System.out.println("///////////////////////////");
		System.out.println("c= " + c);
		System.out.println(c == b);// ���Ϊfalse���������ڴ��в���ͬһ������
		// �Ƚ�String����ͻ�������String��ֵʹ��equal()
		System.out.println(c.equals(b));// ���Ϊtrue

	}

	/**
	 * �ж���������
	 * 
	 */
	public static void typeOper()
	{
		String a = new String("test");
		Integer b = new Integer(2);
		// 1 a.getClass().getName();��ȡ��������������
		// 2.��instanceof����߱�ʾ��������ã��ұ�������
		System.out.println(a instanceof String);
	}

	/**
	 * �������
	 * 
	 * ���������Ԫ�ص�ʱ�򣬵��������鳤�ȵ�ʱ��ᱨ����Խ���쳣
	 */
	public void array()
	{
		// ��������Ԫ�أ�������[�±�]
		// arr.length����ĳ���
		String item = arr[arr.length - 1];
	}

	// ��������
	public static void arrayFunc()
	{
		int[] a =
		{ 1, 2, 3, 4 };
		int[] b =
		{ 5, 6, 7, 8 };
		// ������a�����ݸ��Ƶ�b
		// a:����Դ
		// b:Ŀ������
		// ��һ��0����ʼ��ֵ����ʼλ��
		// �ڶ���0������b�������ݵ���ʼλ��
		// a.length����ֵ����ĳ���
		System.arraycopy(a, 0, b, 0, a.length);
		for (int i : b)
		{
			System.out.println(i);
		}
	}

	public static void arraysort()
	{
		// ��������
		int[] a =
		{ 1, 3, 5, 1, 2, 4 };
		Arrays.sort(a);
		for (int i : a)
		{
			System.out.println(i);
		}
	}

	/**
	 * ���飺�û����ſ�ʼ�ͽ���{}
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
			// �������ʹ�ÿ��ⲿ������
			// �����ڲ�����ı���ֻ���ڲ�ʹ�ã��Ǿֲ�����
			System.out.println("x= " + x);
			System.out.println("y= " + y);
		}
		System.out.println(x);

	}

	/**
	 * if �ؼ��� ʹ�ò������ʽ���ж��Ƿ�ִ��
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
	 * switch �ؼ���
	 * 
	 * @param args
	 */
	public static void switchTest()
	{
		byte s = 1;
		switch (s)
		{
		case 1:// ���Ա������ܳ�����������ķ�Χ��������Ʋ�ͨ����ֱ�ӱ���
			System.out.println("ss");
			break;
		// break����ֹͣ��ǰ��䣬
		// ���û�У���һ��case�����Ҳ��ִ�У�ֱ������break,����ִ����
		case 12:
			System.out.println("dd");
			break;
		default:// default�ؼ����ǿ�ѡ�ؼ��֣���ʾ��ǰ���������ƥ���ִ��
			System.out.println("null");
			break;
		}
	}

	/**
	 * forѭ��
	 * 
	 * @param args
	 */
	public void forTest()
	{
		int a = 1;
		int b = 2;
		// for (init; test; increment)
		// init��ʼ��ѭ��������ִֻ��һ��
		// incrementѭ�����ִ��
		// testѭ�������ж�
		for (int i = 1; i < 10; i++)
		{
		}
		// ����ѭ��
		// breakֱ�ӽ���ѭ��
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
	 * �ؼ��� this ָ��ǰ�����ֻ����ʵ��������ʹ�ã��෽���в���ʹ��
	 * 
	 */
	public void thisTest()
	{
		String ss = this.str;
	}

	/**
	 * �෽�����ùؼ���static���εķ��������Ա���ʹ�� Ҳ���Ա�ʵ��ʹ��
	 * 
	 * ʵ������������static���Σ�ֻ���ڶ��������У���������������
	 * 
	 * @param args
	 */

	/**
	 * �������أ��������������ͬ���ǲ����������߲������Ͳ�ͬ��Ϊ�������أ�
	 * 
	 * �������Ͳ�����Ϊ�������ص��ж����������2�����������ƣ��������ͻ�������ͬ�����ص����Ͳ�ͬ��ô��������
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
	 * ����Ȩ�޿��ƣ�public proteced private Ĭ�ϣ���ʹ�ùؼ��֣�
	 * 
	 * Ĭ�ϣ���ͬһ���ص��κ��඼���Է���
	 * 
	 * private:��ȫ�������ͱ������أ������������ڵ��������಻�ܷ��ʣ�Ҫ���ʱ���ֻ��ͨ��getXXX()����
	 * 
	 * public :public���ε�����߷����ܹ����κ���ʹ��
	 * 
	 * protected���������ͬһ����������ʹ��
	 * 
	 */
	/**
	 * java���ݽṹ��java.util�����ṩ��������ݽṹ�������ӿ�iterator,map����BitSet,vector,stack,
	 * hashtable
	 * 
	 * @param args
	 */
	public static void dataFunc()
	{
		// iterator���������ݽṹ��������������һ�������������ݵ���Ԫ�صķ�ʽ
		String[] arr =
		{ "a", "b", "c", "d", "e" };
		List<String> list = new ArrayList<String>();

		list = Arrays.asList(arr);
		Iterator<String> iterator = list.iterator();
		// iterator.hasNext()�ж��Ƿ�����һ��Ԫ�أ����ز�������
		while (iterator.hasNext())
		{
			// iterator.next()����ֵ�������ͣ�object��
			System.out.println(iterator.next());
		}
		// BitSetλ��
		BitSet bs = new BitSet();
		// vector ʸ�����������ŵ����飬ʵ����List�ӿڣ���������arraylist
		Vector vector = new Vector();
		// Stack��ջ �̳�Vector
		Stack s = new Stack();
		// �ӿ�Map����һ����ֵӳ�����ݵĿ�ܣ���ֵ������vector������

		// hashtableɢ�б� ʵ���˽ӿ�Map
		Map hashtable = new Hashtable();
	}

	public static void main(String[] args)
	{
		// BaseInfo.arraysort();

		// BaseInfo.switchTest();
		// BaseInfo.typeOper();
		// BaseInfo base = new BaseInfo();
		// base.getClass().getName()���ض��������������
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
	 * final���εķ������ܱ����า�÷��� ���������Խ��ͣ�����Ч�������
	 */
	final void testFinal()
	{

	}
}

class Eagle extends Bird
{

	String wings;

	/**
	 * ���췽�����ǣ���д��
	 */
	public Eagle()
	{
		super();// ���ò����������췽��
	}

	public Eagle(String wings, String cry, String name)
	{
		super(cry, name);// ���ô��ι��췽��
	}

	/**
	 * ������д�����ǣ��������д���һ���������ͣ��������ƺͲ�������ͬ�ķ���
	 * 
	 * �������ǿ��Դ��¶��壬�����µĲ����������� �����ظ���ķ���
	 * 
	 * ���ø���ķ����ùؼ���super.������super��ʾ����
	 * 
	 * �����෽����public�����������public,����private����������д
	 */
	public void fly(String str)
	{
		System.out.println("Eagle fly" + str);
	}

	/**
	 * ���ʿ��ƺͼ̳�
	 * 
	 * ���෽����private��ʱ���ܱ��̳�
	 * 
	 * �����෽������Ȩ����protected���������·�������Ȩ�޿���Ϊpublic����protected
	 */
	protected void work()
	{

	}

	/**
	 * ������Ĭ��Ȩ��ʱ
	 * 
	 * ������public��protected����Ҳ��Ĭ�ϵ�
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

// final���ε��಻�ܱ��̳У����������Խ��ͣ�����Ч�������
final class finalClass
{
	String name = "dd";
}

class WebReader
{
	/**
	 * ��ȡaddress��ַҳ����Ϣ
	 * 
	 * @param address
	 */
	public void getData(String address)
	{
		try
		{
			// URL��·��ַ���󣬼�����Դ��ַ ��address ��http�ĵ�ַ
			URL page = new URL(address);
			// HttpURLConnection�����ܹ�����url��������վ��
			HttpURLConnection conn = (HttpURLConnection) page.openConnection();
			// ��������
			conn.connect();
			// ��ȡurl������
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