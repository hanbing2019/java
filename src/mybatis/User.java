package mybatis;

public class User extends Common
{
	private long id;
	private String name;
	private String pwd;

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

	public void func(String str)
	{
		System.out.println("---func---");
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + "]";
	}

}
