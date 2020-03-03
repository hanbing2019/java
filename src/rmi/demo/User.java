package rmi.demo;

import java.io.Serializable;

public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7330458419530896140L;
	private int age;

	/**
	 * @return the age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

}
