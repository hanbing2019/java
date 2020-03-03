package mybatis;

import java.util.List;

public class MaxInfo
{
	private long id;
	private TestInfo tf;
	private List<User> users;
	private String n;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * @return the tf
	 */
	public TestInfo getTf()
	{
		return tf;
	}

	/**
	 * @param tf
	 *            the tf to set
	 */
	public void setTf(TestInfo tf)
	{
		this.tf = tf;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers()
	{
		return users;
	}

	/**
	 * @param users
	 *            the users to set
	 */
	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	/**
	 * @return the n
	 */
	public String getN()
	{
		return n;
	}

	/**
	 * @param n
	 *            the n to set
	 */
	public void setN(String n)
	{
		this.n = n;
	}

}
