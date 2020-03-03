package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcUtil
{
	/**
	 * 获取连接
	 * 
	 * @return
	 */
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接对象
			conn = DriverManager.getConnection("jdbc:mysql:///test", "root",
					"12345");

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		return conn;
	}

	public void search()
	{
		Connection conn = getConnection();
		String sql = "select * from t_user";
		PreparedStatement stat = null;// 预处理对象
		ResultSet rs = null;
		try
		{
			// PreparedStatement是用来执行SQL查询语句,执行查询的效率比Statement高
			// PreparedStatement对sql预编译处理

			stat = conn.prepareStatement(sql);
			// stat.setString(str, x);向sql设置String类型参数，第一个为值，第二个为索引从1开始
			// 执行查询
			rs = stat.executeQuery();
			metaData(rs);
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public void metaData(ResultSet rs)
	{
		// DatabaseMetaData 包含了有关整个数据库的信息：表名、表的索引、数据库产品的名称和版本、数据库支持的操作
		// ResultSetMetaData包含了查询结果的列名，列的数据类型
		ResultSetMetaData rsmd = null;
		try
		{
			rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();// 获取列的数量
			List<String> columncount = new ArrayList<String>();

			// 序列是从1开始的
			for (int i = 1; i <= count; i++)
			{
				String cname = rsmd.getColumnName(i);// 获取序列为i的列名
				System.out.println("列名： " + cname);
				columncount.add(cname);

				String tname = rsmd.getColumnTypeName(i);// 获取序列为i的列的类型
				System.out.println("类型：" + tname);
				// 查询到的类型
				// BIGINT BINARY BIT CHAR DATE DECIMAL DOUBLE FLOAT INTEGER
				// LONGVARBINARY LONGVARCHAR NULL NUMERIC OTHER
				// REAL SMALLINT TIME TIMESTAMP TINYINT VARBINARY VARCHAR
				System.out.println("按-- ：" + rsmd.getColumnLabel(i));
			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}

	}

	public void delete()
	{
		Connection conn = getConnection();
		Statement state = null;
		String sql = "delete from t_user where id=12";
		try
		{
			state = conn.createStatement();
			state.execute(sql);
		} catch (SQLException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				state.close();
				conn.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[])
	{
		JdbcUtil ju = new JdbcUtil();
		ju.search();
	}
}
