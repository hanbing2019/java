package serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class UserModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3949020618515326601L;
	private String name;
	private String adddress;
	private static int age;
	transient private String car;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAdddress()
	{
		return adddress;
	}

	public void setAdddress(String adddress)
	{
		this.adddress = adddress;
	}

	public static int getAge()
	{
		return age;
	}

	public static void setAge(int age)
	{
		UserModel.age = age;
	}

	public String getCar()
	{
		return car;
	}

	public void setCar(String car)
	{
		this.car = car;
	}

	@Override
	public String toString()
	{
		return "UserModel [name=" + name + ", adddress=" + adddress + ", car="
				+ car + "]";
	}

	public static void main(String args[])
	{
		UserModel um = new UserModel();
		um.setAdddress("cd");
		um.setCar("od");
		um.setName("td");
		// um.setAge(24);
		serializableModel(um);

		reSerializableModel();
		float x = 1.111111111111111111111111111111111f;
		System.out.println(x);

	}

	/**
	 * 对象序列化
	 * 
	 * @param obj
	 */
	public static void serializableModel(Object obj)
	{
		File file = new File("D:\\ser.txt");
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			oos.writeObject(obj);
			oos.close();
			System.out.println("序列化完成");
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 反序列化
	 */
	public static void reSerializableModel()
	{
		File file = new File("D:\\ser.txt");
		try
		{
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
					file));
			System.out.println("-------反序列化-------");
			UserModel um = (UserModel) ois.readObject();
			System.out.println(um.getAdddress());
			System.out.println(um.getCar());
			System.out.println(um.getName());
			System.out.println(um.getAge());
			ois.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
