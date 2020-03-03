package mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatiInfo
{
	public static void main(String args[]) throws IOException
	{

		String config = "mybatis-config.xml";
		SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
		InputStream inputStream = Resources.getResourceAsStream(config);
		SqlSessionFactory factory = sfb.build(inputStream);
		SqlSession session = factory.openSession();
		// List<User> users = session.selectList("userMapper.selectPage");
		// for (User user : users)
		// {
		// System.out.println(user);
		// }
		// List<TestInfo> tis = session.selectList("userMapper.selectTestInfo");
		// for (TestInfo ti : tis)
		// {
		// System.out.println(ti);
		// }
		// 第一个参数是查询的起始位置，从0开始
		// 第二个参数是查询的长度
		// RowBounds rb = new RowBounds(0, 1);
		// List<User> us = session.selectList("userMapper.selectPage1", null,
		// rb);
		// System.out.println(us.size());

		List<MaxInfo> mis = session.selectList("userMapper.selectMaxInfo");
		List<User> us = mis.get(0).getUsers();
		for (User user : us)
		{
			System.out.println(user);
		}
	}
}
