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

		// List继承Collection接口
		//
		List<String> list = new ArrayList<String>();
		List<String> v = new Vector<String>();
		List<String> ln = new LinkedList<String>();
		// ArrayList Vector是线性表，使用数组作为容器来存数据
		// ArrayList是非同步的，vector是同步的，在不考虑多线程时使用ArrayList,效率较高
		// LinkedList链表 做查询的时候效率比较低，做删除添加是效率高
		// 非同步，非频繁删除时使用ArrayList,多线程中使用vector,做频繁删除添加是使用LinkedList

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
		// ArrayList Vector是线性表，使用数组作为容器来存数据
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
