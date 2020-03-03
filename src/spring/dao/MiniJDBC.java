package spring.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiniJDBC
{
	private String url;
	private String username;
	private String password;
	private String driverClassName;

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getDriverClassName()
	{
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName)
	{
		this.driverClassName = driverClassName;
	}

	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			Class.forName(this.getDriverClassName());
			conn = DriverManager.getConnection(this.url, this.username,
					this.password);
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}
}
