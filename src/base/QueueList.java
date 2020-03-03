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
	 * 数组：当删除一个元素的时候，删除元素之后的元素都要向前移动一位，插入元素会向后移动
	 * 
	 * 链表（LinkedList）：将每个对象放在独立的节点上，每个节点都存放着下一个节点的引用;链表add添加对象时添加到链表的尾部，链表是有序集合
	 * 
	 * 链表不适合随机访问和修改元素，数组比较适合这些操作
	 * 
	 * Vactor:矢量数组，他的所有方法都是同步的，在多线程数据操作的时候，数据安全性比较高，但是效率较低
	 * 
	 * ArrayList:不是同步的，在不需要同步的时候使用arrayList
	 */
	public static void test()
	{
		List<String> list = new LinkedList<String>();
		list.add("st1");
		list.add("st2");
		ListIterator<String> listIt = list.listIterator();
		// ListIterator接口提供了依赖位置的add方法
		// LinkedList的方法listIterator()返回的是实现ListIterator接口的迭代器对象
		// next()返回的是元素
		String s = listIt.next();// listIt 第一个元素
		listIt.set("st6");// set方法用来替换调用next或者previous方法返回的上一个元素
		// System.out.println(s);
		// 当listIt首先调用了next()方法后，在使用add方法添加数据，从在第一个元素后开始添加，
		// 调用add方法添加数据时从链表头位置开始添加
		listIt.add("st3");
		listIt.add("st4");
		System.out.println(list);

		// [st3, st4, st1, st2, st5]
	}

	/**
	 * HashSet实现散列表的集,无序集合
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
		// TreeSet，使用add方法添加的数据按照一定的规则排序(使用树结构排序，现在使用的是红黑树)
		treeSet.add("st8");
		treeSet.add("st2");
		treeSet.add("st3");

		System.out.println(treeSet);
	}

	/**
	 * map：映射表 java.util.Map接口
	 * 
	 * HashMap放入值后，值的顺序是随机的
	 * 
	 * hashMap和treeMap实现了Map接口
	 */
	/**
	 * 几个特殊的Map
	 * 
	 * 1弱散列映射表weakHashMap:能够删除表中长期不能使用的键/值
	 * 
	 * 2链散列映射表LinkedHashMap 3链散列映射集LinkedHashSet:用于记住插入数据的顺序，映射表数据的顺序就是插入数据时的顺序
	 */
	public static void maptest()
	{
		// HashMap散列映射表，键必须是唯一的，如果连续使用put向同一键存放数据，只能保存第二个
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key1", 1);
		map.put("key2", 2);
		map.put("key3", 3);
		System.out.println(map);
		// remove
		map.remove("key");// 删除key的值，
		// map.clear();// 清除map的所有值
		map.size();// 返回map有多少个key/value
		Set<String> keys = map.keySet();// 返回map的所有键
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("key4", 4);
		m.put("key5", 5);
		map.containsKey("");// 判断key是否在map中，返回true，map中有改key否则没有
		map.putAll(m);// putAll：将一个散列表放进另一个中
		for (String str : keys)
		{
			// to do with key
		}
		System.out.println(map);

		// TreeMap是红黑树算法的实现，键是有序的
		Map<String, Object> treeMap = new TreeMap<String, Object>();

		treeMap.put("a", 1);
		treeMap.put("f", 3);
		treeMap.put("c", 3);
		System.out.println(treeMap);
	}

	/**
	 * 向hashmap中存放大量数据
	 * 
	 * list中的pdata存在相同的key,用相同key作为map的key,value存放数据
	 */

	public void putData2Map(List<Pdata> list)
	{
		Map<String, List<Pdata>> map = new HashMap<String, List<Pdata>>();
		for (Pdata pdata : list)
		{
			String key = pdata.getKey();
			if (map.containsKey(key))
			{
				// 但存在key时，取出value list,调用add方法将pdata放进list
				map.get(key).add(pdata);
			} else
			{
				// map中不存在这个key时，创建
				List<Pdata> data = new ArrayList<Pdata>();
				data.add(pdata);
				map.put(key, data);
			}

		}

	}

	/**
	 * 集合的2个基本接口：Collection和Map
	 * 
	 * Set,Queue,List都是实现了Collection的接口
	 * 
	 * Set无序集合,元素不能重复，List有序集合,元素可以重复，Queue队列
	 * 
	 * HashSet：实现了set接口
	 * 
	 * 实现list接口的子类：ArrayList 集合数组实现,LinkedList集合链表 ，vactor 矢量
	 */
	public void special()
	{
		Set set = new HashSet();
		// set.add(e);
		// public boolean add(E e) {
		// return map.put(e, PRESENT)==null;
		// }
		// hashset存储数据的方式，将添加的元素作为map键保存在HashMap中
		// hashmap是线程同步的，效率较高，取值较快，HashMap储存键值对
		// hashset效率和hashmap相比较低 ,HashSet仅仅存储对象
		// 不能保证元素的排列顺序；不是同步的，不是线程安全；集合值可以是null。
		LinkedHashSet linkset = new LinkedHashSet();
		// LinkedHashSet继承hashset,添加数据时，添加元素的顺序被保存，元素的顺序就是添加的顺序，不是随机的
		TreeSet treeSet = new TreeSet();
		// Treeset可对添加的数据按照一定算法排序

		Queue queue = new PriorityQueue();
		ArrayList list = new ArrayList();
		// private transient Object[] elementData;ArrayList定义的数组
		// ArrayList有数组实现，数据存储在定义的数组中，查找比较快，但是删除和添加较慢
		// 线程同步，安全性高
		Vector vactor = new Vector();
		// 实现原来和arraylist相同，数据都是放在数组中的
		// 但是vector数据不是同步的，效率较高
		LinkedList linkedList = new LinkedList();
		// 通过链表实现，增删效率较高，遍历效率较低

	}

	/**
	 * 异常（throwable）
	 * 
	 * 运行时异常:代码在运行的时候由虚拟机接管抛出，不需要去处理
	 * 
	 * 非运行时异常：对这种异常必须通过try..catch来处理，否则编译不通过
	 * 
	 */
	public static void exception()
	{
		String filepath = "";
		File file = new File(filepath);
		try
		{
			/**
			 * FileNotFoundException文件不存在异常，检测异常必须编写try。。catch的代码来处理异常
			 */
			FileInputStream in = new FileInputStream(file);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}

		// 运行时异常，比如数组越界，或者空指针
		String arr[] = new String[10];
		// 数组arr分配了10个存储空间，当访问值指针超过引用时java虚拟机就汇报数组越界异常
		System.out.println(arr[10]);
	}

	public static void strfunc()
	{
		// String字符串
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
		// 对list进行排序
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

// 排序，
// 实现Comparator接口，compare方法排序，当返回0时表示，2个相等，
// 返回正数时，前者大于后者，返回负数时，后者大于前者
// 通过Collections类的sort方法排序

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
