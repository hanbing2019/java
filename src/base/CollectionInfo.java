package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionInfo
{
	// Collection
	public void func()
	{

		// List�̳�Collection�ӿ�
		//
		List<String> list = new ArrayList<String>();
		List<String> v = new Vector<String>();
		List<String> ln = new LinkedList<String>();
		// ArrayList Vector�����Ա�ʹ��������Ϊ������������
		// ArrayList�Ƿ�ͬ���ģ�vector��ͬ���ģ��ڲ����Ƕ��߳�ʱʹ��ArrayList,Ч�ʽϸ�
		// LinkedList���� ����ѯ��ʱ��Ч�ʱȽϵͣ���ɾ�������Ч�ʸ�
		// ��ͬ������Ƶ��ɾ��ʱʹ��ArrayList,���߳���ʹ��vector,��Ƶ��ɾ�������ʹ��LinkedList

		list.add("a");
		list.add("b");
		list.add("c");

		v.add("a");
		v.add("b");
		v.add("c");
	}

	public static void main(String args[])
	{
		List<String> list = new ArrayList<String>();
		List<String> v = new Vector<String>();
		List<String> ln = new LinkedList<String>();
		// ArrayList Vector�����Ա�ʹ��������Ϊ������������
		list.add("a");
		list.add("b");
		list.add("c");

		v.add("a");
		v.add("b");
		v.add("c");

		System.out.println(list);
		System.out.println(v);

		String[] arr =
		{ "a", "b", "c" };
		System.out.println(arr);
	}
}
