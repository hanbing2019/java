package thread;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil
{
	static
	{
		try
		{
			// ¼ÓÔØÇý¶¯
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static Connection getConnection()
	{
		String user = "";
		String password = "";
		String url = "";

		try
		{
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e)
		{
		}
		return null;
	}
}
