package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

public class QueueList
{
	/**
	 * ���飺��ɾ��һ��Ԫ�ص�ʱ��ɾ��Ԫ��֮���Ԫ�ض�Ҫ��ǰ�ƶ�һλ������Ԫ�ػ�����ƶ�
	 * 
	 * ����LinkedList������ÿ��������ڶ����Ľڵ��ϣ�ÿ���ڵ㶼�������һ���ڵ������;����add��Ӷ���ʱ��ӵ������β�������������򼯺�
	 * 
	 * �����ʺ�������ʺ��޸�Ԫ�أ�����Ƚ��ʺ���Щ����
	 * 
	 * Vactor:ʸ�����飬�������з�������ͬ���ģ��ڶ��߳����ݲ�����ʱ�����ݰ�ȫ�ԱȽϸߣ�����Ч�ʽϵ�
	 * 
	 * ArrayList:����ͬ���ģ��ڲ���Ҫͬ����ʱ��ʹ��arrayList
	 */
	public static void test()
	{
		List<String> list = new LinkedList<String>();
		list.add("st1");
		list.add("st2");
		ListIterator<String> listIt = list.listIterator();
		// ListIterator�ӿ��ṩ������λ�õ�add����
		// LinkedList�ķ���listIterator()���ص���ʵ��ListIterator�ӿڵĵ���������
		// next()���ص���Ԫ��
		String s = listIt.next();// listIt ��һ��Ԫ��
		listIt.set("st6");// set���������滻����next����previous�������ص���һ��Ԫ��
		// System.out.println(s);
		// ��listIt���ȵ�����next()��������ʹ��add����������ݣ����ڵ�һ��Ԫ�غ�ʼ��ӣ�
		// ����add�����������ʱ������ͷλ�ÿ�ʼ���
		listIt.add("st3");
		listIt.add("st4");
		System.out.println(list);

		// [st3, st4, st1, st2, st5]
	}

	/**
	 * HashSetʵ��ɢ�б�ļ�,���򼯺�
	 * 
	 * TreeSet
	 * 
	 */

	public static void hashcodetest()
	{
		Set<String> sets = new HashSet<String>();
		sets.add("st8");
		sets.add("st3");
		sets.add("st5");
		System.out.println(sets.hashCode());
		System.out.println(sets);

		Set<String> treeSet = new TreeSet<String>();
		// TreeSet��ʹ��add������ӵ����ݰ���һ���Ĺ�������(ʹ�����ṹ��������ʹ�õ��Ǻ����)
		treeSet.add("st8");
		treeSet.add("st2");
		treeSet.add("st3");

		System.out.println(treeSet);
	}

	/**
	 * map��ӳ��� java.util.Map�ӿ�
	 * 
	 * HashMap����ֵ��ֵ��˳���������
	 * 
	 * hashMap��treeMapʵ����Map�ӿ�
	 */
	/**
	 * ���������Map
	 * 
	 * 1��ɢ��ӳ���weakHashMap:�ܹ�ɾ�����г��ڲ���ʹ�õļ�/ֵ
	 * 
	 * 2��ɢ��ӳ���LinkedHashMap 3��ɢ��ӳ�伯LinkedHashSet:���ڼ�ס�������ݵ�˳��ӳ������ݵ�˳����ǲ�������ʱ��˳��
	 */
	public static void maptest()
	{
		// HashMapɢ��ӳ�����������Ψһ�ģ��������ʹ��put��ͬһ��������ݣ�ֻ�ܱ���ڶ���
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		System.out.println(map);
		// remove
		map.remove("key");// ɾ��key��ֵ��
		// map.clear();// ���map������ֵ
		map.size();// ����map�ж��ٸ�key/value
		Set<String> keys = map.keySet();// ����map�����м�
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("key4", 4);
		m.put("key5", 5);
		map.containsKey("");// �ж�key�Ƿ���map�У�����true��map���и�key����û��
		map.putAll(m);// putAll����һ��ɢ�б�Ž���һ����
		for (String str : keys)
		{
			// to do with key
		}
		System.out.println(map);

		// TreeMap�Ǻ�����㷨��ʵ�֣����������
		Map<String, Object> treeMap = new TreeMap<String, Object>();

		treeMap.put("a", 1);
		treeMap.put("f", 3);
		treeMap.put("c", 3);
		System.out.println(treeMap);
	}

	/**
	 * ��hashmap�д�Ŵ�������
	 * 
	 * list�е�pdata������ͬ��key,����ͬkey��Ϊmap��key,value�������
	 */

	public void putData2Map(List<Pdata> list)
	{
		Map<String, List<Pdata>> map = new HashMap<String, List<Pdata>>();
		for (Pdata pdata : list)
		{
			String key = pdata.getKey();
			if (map.containsKey(key))
			{
				// ������keyʱ��ȡ��value list,����add������pdata�Ž�list
				map.get(key).add(pdata);
			} else
			{
				// map�в��������keyʱ������
				List<Pdata> data = new ArrayList<Pdata>();
				data.add(pdata);
				map.put(key, data);
			}

		}

	}

	/**
	 * ���ϵ�2�������ӿڣ�Collection��Map
	 * 
	 * Set,Queue,List����ʵ����Collection�Ľӿ�
	 * 
	 * Set���򼯺�,Ԫ�ز����ظ���List���򼯺�,Ԫ�ؿ����ظ���Queue����
	 * 
	 * HashSet��ʵ����set�ӿ�
	 * 
	 * ʵ��list�ӿڵ����ࣺArrayList ��������ʵ��,LinkedList�������� ��vactor ʸ��
	 */
	public void special()
	{
		Set set = new HashSet();
		// set.add(e);
		// public boolean add(E e) {
		// return map.put(e, PRESENT)==null;
		// }
		// hashset�洢���ݵķ�ʽ������ӵ�Ԫ����Ϊmap��������HashMap��
		// hashmap���߳�ͬ���ģ�Ч�ʽϸߣ�ȡֵ�Ͽ죬HashMap�����ֵ��
		// hashsetЧ�ʺ�hashmap��Ƚϵ� ,HashSet�����洢����
		// ���ܱ�֤Ԫ�ص�����˳�򣻲���ͬ���ģ������̰߳�ȫ������ֵ������null��
		LinkedHashSet linkset = new LinkedHashSet();
		// LinkedHashSet�̳�hashset,�������ʱ�����Ԫ�ص�˳�򱻱��棬Ԫ�ص�˳�������ӵ�˳�򣬲��������
		TreeSet treeSet = new TreeSet();
		// Treeset�ɶ���ӵ����ݰ���һ���㷨����

		Queue queue = new PriorityQueue();
		ArrayList list = new ArrayList();
		// private transient Object[] elementData;ArrayList���������
		// ArrayList������ʵ�֣����ݴ洢�ڶ���������У����ұȽϿ죬����ɾ������ӽ���
		// �߳�ͬ������ȫ�Ը�
		Vector vactor = new Vector();
		// ʵ��ԭ����arraylist��ͬ�����ݶ��Ƿ��������е�
		// ����vector���ݲ���ͬ���ģ�Ч�ʽϸ�
		LinkedList linkedList = new LinkedList();
		// ͨ������ʵ�֣���ɾЧ�ʽϸߣ�����Ч�ʽϵ�

	}

	/**
	 * �쳣��throwable��
	 * 
	 * ����ʱ�쳣:���������е�ʱ����������ӹ��׳�������Ҫȥ����
	 * 
	 * ������ʱ�쳣���������쳣����ͨ��try..catch������������벻ͨ��
	 * 
	 */
	public static void exception()
	{
		String filepath = "";
		File file = new File(filepath);
		try
		{
			/**
			 * FileNotFoundException�ļ��������쳣������쳣�����дtry����catch�Ĵ����������쳣
			 */
			FileInputStream in = new FileInputStream(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		// ����ʱ�쳣����������Խ�磬���߿�ָ��
		String arr[] = new String[10];
		// ����arr������10���洢�ռ䣬������ֵָ�볬������ʱjava������ͻ㱨����Խ���쳣
		System.out.println(arr[10]);
	}

	public static void strfunc()
	{
		// String�ַ���
		String str = null;
		// StringBuffer
		StringBuffer sb = new StringBuffer();
		// StringBuilder
		StringBuilder sbuilder = new StringBuilder();

	}

	public static void main(String args[])
	{
		List<Item> items = new ArrayList<Item>();
		Item item1 = new Item();
		item1.setNum(4);
		items.add(item1);
		Item item2 = new Item();
		item2.setNum(2);
		items.add(item2);
		Item item3 = new Item();
		item3.setNum(3);
		items.add(item3);
		System.out.println(items);

		Item item = new Item();
		// ��list��������
		Collections.sort(items, item);
		System.out.println(items);

		// QueueList.maptest();

		TreeSet treeSet = new TreeSet();
		treeSet.add("1");
		treeSet.add("3");
		treeSet.add("2");
		System.out.println(treeSet);

		QueueList.exception();
	}
}

// ����
// ʵ��Comparator�ӿڣ�compare�������򣬵�����0ʱ��ʾ��2����ȣ�
// ��������ʱ��ǰ�ߴ��ں��ߣ����ظ���ʱ�����ߴ���ǰ��
// ͨ��Collections���sort��������

class Item implements Comparator<Item>
{
	int num;

	public int getNum()
	{
		return num;
	}

	public void setNum(int num)
	{
		this.num = num;
	}

	@Override
	public int compare(Item o1, Item o2)
	{
		return o1.getNum() - o2.getNum();
	}

	@Override
	public String toString()
	{
		return "Item [num=" + num + "]";
	}

}

class Pdata
{
	private String key;
	private String value;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	@Override
	public String toString()
	{
		return "Pdata [key=" + key + ", value=" + value + "]";
	}

}
