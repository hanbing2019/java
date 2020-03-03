package model.demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class PrototypeModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6474900710788771288L;

	String name;

	String vlaue;

	public PrototypeModel(String name, String vlaue)
	{
		this.name = name;
		this.vlaue = vlaue;
	}

	public PrototypeModel clone()
	{
		try
		{
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(this);

			ByteArrayInputStream bai = new ByteArrayInputStream(
					bos.toByteArray());

			ObjectInputStream ois = new ObjectInputStream(bai);
			return (PrototypeModel) ois.readObject();
		} catch (Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public String toString()
	{
		return "PrototypeModel [name=" + name + ", vlaue=" + vlaue + "]";
	}

	public static void main(String[] args) throws CloneNotSupportedException
	{
		PrototypeModel pm = new PrototypeModel("tom", "value");
		PrototypeModel pm1 = pm.clone();
		System.out.println(pm1);
		System.out.println(pm == pm1);

	}
}
