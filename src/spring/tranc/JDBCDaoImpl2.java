package spring.tranc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class JDBCDaoImpl2 extends JdbcTemplate implements JDBCDao
{
	private TransactionTemplate transactionTemplate;

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

	public TransactionTemplate getTransactionTemplate()
	{
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate)
	{
		this.transactionTemplate = transactionTemplate;
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
		System.out.println("-----update-----");
		PlatformTransactionManager ptm = transactionTemplate
				.getTransactionManager();
		DefaultTransactionDefinition definition = new DefaultTransactionDefinition();

		definition
				.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		// 初始化事务,参数定义事务的传播类型;
		TransactionStatus status = ptm.getTransaction(definition);

		try
		{
			// 开启事务
			ptm.getTransaction(definition);
			String sql = "update t_user set name='ttim11111' where id='12'";
			jdbcTemplate.update(sql);
			String sql1 = "update t_user set name='ttim2222' where id='11'";
			// int a = 1 / 0;
			jdbcTemplate.update(sql1);
			ptm.commit(status);// 提交事务
		} catch (Exception e)
		{
			ptm.rollback(status);// 事务回滚
			e.printStackTrace();
		}

	}

	@Override
	public void insert()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void select()
	{
		// TODO Auto-generated method stub

	}
}
