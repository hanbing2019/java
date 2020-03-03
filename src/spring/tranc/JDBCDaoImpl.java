package spring.tranc;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCDaoImpl extends JdbcTemplate implements JDBCDao
{
	private JdbcTemplate jdbcTemplate;

	private DataSource dataSource;

	public DataSource getDataSource()
	{
		return dataSource;
	}

	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void update()
	{
		// String sql = "update t_user set name='ttim11111' where id='12'";
		// jdbcTemplate.update(sql);
		String sql1 = "update t_user set name='tm233322' where id='11'";
		// int a = 1 / 0;
		jdbcTemplate.update(sql1);

	}

	@Override
	public void insert()
	{
		String sql = "insert into t_user (name,pwd) values ('dim','123')";
		jdbcTemplate.update(sql);

	}

	@Override
	public void select()
	{
		String sql = "select id,name,pwd from t_user";
		// List<Map<String, Object>> list = jdbcTemplate.queryForList(sql, "");
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		System.out.println(list);

	}

}
