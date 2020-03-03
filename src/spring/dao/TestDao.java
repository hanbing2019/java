package spring.dao;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TestDao extends JdbcTemplate
{
	// Connection conn = this.getConnection();

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

	public void func()
	{
		System.out.println("testDao");
		// jdbcTemplate.update("", "");
		String[] arrs =
		{ "a", "b", "c" };
		Arrays.asList(arrs);
	}

}
