package model;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型模式：
 * 
 * 在创建对象的时候，我们不只是希望被创建的对象继承 其基类的基本结构，还希望继承原型对象的数据,
 * 
 * 希望对目标对象的修改不影响既有的原型对象（深度克 隆的时候可以完全互不影响）。
 * 
 * @author Administrator
 * 
 */
public class PrototypeModel
{
	public static void main(String[] args)
	{
		// Person person1 = new Person();
		// person1.setName("lifengxing");
		// person1.setAge(30);
		// person1.setSex("男");
		//
		// // Person person2 = person1;
		// Person person2 = person1.clone();
		//
		// System.out.println(person1.getName());
		// System.out.println(person1.getAge());
		// System.out.println(person1.getSex());
		//
		// System.out.println(person2.getName());
		// System.out.println(person2.getAge());
		// System.out.println(person2.getSex());

		Person person1 = new Person();
		List<String> friends = new ArrayList<String>();
		friends.add("James");
		friends.add("Yao");

		person1.setFriends(friends);

		Person person2 = person1.clone();

		System.out.println("p1" + person1.getFriends());
		System.out.println("p2" + person2.getFriends());

		friends.add("Mike");
		person1.setFriends(friends);
		System.out.println("p1" + person1.getFriends());
		System.out.println("p2" + person2.getFriends());
	}
}

class Person implements Cloneable
{
	// 姓名
	private String name;
	// 年龄
	private int age;
	// 性别
	private String sex;
	// 朋友
	private List<String> friends;

	public List<String> getFriends()
	{
		return friends;
	}

	public void setFriends(List<String> friends)
	{
		this.friends = friends;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public Person clone()
	{
		try
		{
			Person person = (Person) super.clone();
			List<String> newfriends = new ArrayList<String>();
			for (String friend : this.getFriends())
			{
				newfriends.add(friend);
			}
			person.setFriends(newfriends);
			return person;
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
