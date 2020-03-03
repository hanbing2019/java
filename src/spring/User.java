package spring;

import java.util.List;
import java.util.Map;

import spring.dao.TestDao;

public class User
{
	private long id;
	private String name;
	private String pwd;
	private List<String> info;
	private Map<String, Object> map;

	private static String test;

	public void func1(String str)
	{
		System.out.println("func " + str);
	}

	public Map<String, Object> getMap()
	{
		return map;
	}

	public void setMap(Map<String, Object> map)
	{
		this.map = map;
	}

	TestDao testDao;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public List<String> getInfo()
	{
		return info;
	}

	public void setInfo(List<String> info)
	{
		this.info = info;
	}

	public TestDao getTestDao()
	{
		return testDao;
	}

	public void setTestDao(TestDao testDao)
	{
		this.testDao = testDao;
	}

	public void func()
	{
		// System.out.println("user func");
		testDao.func();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", info="
				+ info + ", map=" + map + ", testDao=" + testDao + "]";
	}

}
