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
	 * ������java.util.Collections
	 * 
	 * �ṩ���ϲ����ĸ��ַ���
	 * 
	 * ���򷽷���1�������������� 2���Զ�����������
	 * 
	 * ��ѯlistĳ��Ԫ�ص��±�
	 */
	public static void collections()
	{
		// Collections.
		// Collections c = new Collections();����ͨ��new �������� ����������˽�е�
		// List a;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(8);
		list.add(2);
		list.add(6);
		list.add(4);
		// ������������sort�Ĳ���ֻ��list
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
		// �Զ����������򣬸������ĳ���������򣬶���һ��ʵ�ֽӿ�Comparetor������compare�����������������
		// Collections.sort(l2, new ComparatorImpl());
		System.out.println(l2);

		// ���ַ�����list��ĳ��Ԫ�ص��±�
		int a = Collections.binarySearch(l2, i3);
		System.out.println(a);

	}

	/**
	 * �ӿڼ���
	 */

	public static void collection()
	{
		// java.util.Collection c=
		// java.util.Map
		// ˫������
		// ֧�����л���֧�ֿ�¡���ܶ������ж��в���
		LinkedList<Integer> link = new LinkedList<Integer>();
		List<String> arr = new ArrayList<String>();
		// HashMap

	}

	public static void main(String args[])
	{
		// ��ȡϵͳ/Ӧ���������
		ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
		System.out.println("ϵͳ/Ӧ�����������" + appClassLoader);
		// ��ȡϵͳ/Ӧ����������ĸ�����������õ���չ�������
		ClassLoader extcClassLoader = appClassLoader.getParent();
		System.out.println("��չ�������" + extcClassLoader);
		System.out
				.println("��չ��������ļ���·����" + System.getProperty("java.ext.dirs"));
		// ��ȡ��չ��������ĸ�����������������������������Javaʵ�ֵ����Բ��ܻ�ȡ
		System.out.println("��չ��ĸ����������" + extcClassLoader.getParent());

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
		// ��������
		a = Arrays.copyOf(a, a.length + 1);
		// ��3Ϊ����
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
