package base.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class BaseCollection
{
	/**
	 * 集合类java.util.Collections
	 * 
	 * 提供集合操作的各种方法
	 * 
	 * 排序方法，1，基本类型排序 2，自定义类型排序
	 * 
	 * 查询list某个元素的下标
	 */
	public static void collections()
	{
		// Collections.
		// Collections c = new Collections();不能通过new 创建对象 构造器是是私有的
		// List a;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(8);
		list.add(2);
		list.add(6);
		list.add(4);
		// 基本类型排序，sort的参数只有list
		Collections.sort(list);
		System.out.println(list);
		Information i1 = new Information(1, "l1");
		Information i2 = new Information(3, "l2");
		Information i3 = new Information(8, "l3");
		Information i4 = new Information(3, "l4");
		List<Information> l2 = new ArrayList<Information>();
		l2.add(i4);
		l2.add(i3);
		l2.add(i2);
		l2.add(i1);
		// 自定义类型排序，根据类的某个变量排序，定义一个实现接口Comparetor的类在compare方法中设置排序规则
		// Collections.sort(l2, new ComparatorImpl());
		System.out.println(l2);

		// 二分法查找list中某个元素的下标
		int a = Collections.binarySearch(l2, i3);
		System.out.println(a);

	}

	/**
	 * 接口集合
	 */

	public static void collection()
	{
		// java.util.Collection c=
		// java.util.Map
		// 双向链表
		// 支持序列化，支持克隆，能对他进行队列操作
		LinkedList<Integer> link = new LinkedList<Integer>();
		List<String> arr = new ArrayList<String>();
		// HashMap

	}

	public static void main(String args[])
	{
		// 获取系统/应用类加载器
		ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("系统/应用类加载器：" + appClassLoader);
		// 获取系统/应用类加载器的父类加载器，得到扩展类加载器
		ClassLoader extcClassLoader = appClassLoader.getParent();
		System.out.println("扩展类加载器" + extcClassLoader);
		System.out
				.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
		// 获取扩展类加载器的父加载器，但因根类加载器并不是用Java实现的所以不能获取
		System.out.println("扩展类的父类加载器：" + extcClassLoader.getParent());

		HashMap<String, String> h = new HashMap<String, String>();

		String v = h.put("k1", "v1");

		System.out.println(Integer.highestOneBit((32 - 1) << 1));

	}

	public static void arrtest()
	{
		int[] a = new int[]
		{ 1, 23, 45, 6, 7, 4 };
		a = Arrays.copyOf(a, 10);
		System.out.println(a.length);
	}

	public static void inserArr()
	{
		int[] a =
		{ 3, 4, 54, 13, 45 };
		// 数组扩容
		a = Arrays.copyOf(a, a.length + 1);
		// 第3为插入
		// 012
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
		for (int i = a.length - 1; i >= 3; i--)
		{
			System.out.println(i);
			a[i] = a[i - 1];
		}
		a[2] = 66;
		for (int i = 0; i < a.length; i++)
		{
			System.out.println(a[i]);
		}
	}
}
