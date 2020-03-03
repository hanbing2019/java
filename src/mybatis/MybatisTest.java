package mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTest
{
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static
	{
		try
		{
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession()
	{
		return sqlSessionFactory;
	}

	public static void main(String[] args)
	{
		SqlSession session = sqlSessionFactory.openSession();
		try
		{
			List<User> user = session.selectList("userMapper.selectPage");
			System.out.println(user);
		} finally
		{
			session.close();
		}
	}
}
