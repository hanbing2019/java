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
	 * ��ȡ����
	 * 
	 * @return
	 */
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			// �������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			// ��ȡ���Ӷ���
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
		PreparedStatement stat = null;// Ԥ�������
		ResultSet rs = null;
		try
		{
			// PreparedStatement������ִ��SQL��ѯ���,ִ�в�ѯ��Ч�ʱ�Statement��
			// PreparedStatement��sqlԤ���봦��

			stat = conn.prepareStatement(sql);
			// stat.setString(str, x);��sql����String���Ͳ�������һ��Ϊֵ���ڶ���Ϊ������1��ʼ
			// ִ�в�ѯ
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
		// DatabaseMetaData �������й��������ݿ����Ϣ��������������������ݿ��Ʒ�����ƺͰ汾�����ݿ�֧�ֵĲ���
		// ResultSetMetaData�����˲�ѯ������������е���������
		ResultSetMetaData rsmd = null;
		try
		{
			rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();// ��ȡ�е�����
			List<String> columncount = new ArrayList<String>();

			// �����Ǵ�1��ʼ��
			for (int i = 1; i <= count; i++)
			{
				String cname = rsmd.getColumnName(i);// ��ȡ����Ϊi������
				System.out.println("������ " + cname);
				columncount.add(cname);

				String tname = rsmd.getColumnTypeName(i);// ��ȡ����Ϊi���е�����
				System.out.println("���ͣ�" + tname);
				// ��ѯ��������
				// BIGINT BINARY BIT CHAR DATE DECIMAL DOUBLE FLOAT INTEGER
				// LONGVARBINARY LONGVARCHAR NULL NUMERIC OTHER
				// REAL SMALLINT TIME TIMESTAMP TINYINT VARBINARY VARCHAR
				System.out.println("��-- ��" + rsmd.getColumnLabel(i));
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
