package mybatis.plugin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import mybatis.Common;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

@Intercepts(
{ @Signature(type = Executor.class, method = "query", args =
{ MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class PageInterceptor implements Interceptor
{

	private String dataType = "mysql";
	private static final String SELECT_ID = "selectpage";

	// 插件运行的代码，它将代替原有的方法
	@Override
	public Object intercept(Invocation invocation) throws Throwable
	{
		// invocation.getArgs()
		System.out.println("PageInterceptor -- intercept");

		if (invocation.getTarget() instanceof StatementHandler)
		{
			StatementHandler statementHandler = (StatementHandler) invocation
					.getTarget();
			MetaObject metaStatementHandler = SystemMetaObject
					.forObject(statementHandler);
			System.out.println(metaStatementHandler.toString());
			MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
					.getValue("delegate.mappedStatement");
			String selectId = mappedStatement.getId();

			if (SELECT_ID.equals(selectId.substring(
					selectId.lastIndexOf(".") + 1).toLowerCase()))
			{
				BoundSql boundSql = (BoundSql) metaStatementHandler
						.getValue("delegate.boundSql");
				System.out.println(boundSql);
				// 分页参数作为参数对象parameterObject的一个属性
				String sql = boundSql.getSql();// 获取sql语句

				// 取出查询条件映射文件中 属性parameterType和parameterMap配置的值
				Common co = (Common) (boundSql.getParameterObject());

				if (co == null)
				{
					co = new Common();
					co.setPagebegin(0);
					co.setPagesize(3);
				}
				// 重写sql
				String countSql = concatCountSql(sql);
				String pageSql = concatPageSql(sql, co);

				System.out.println("重写的 count  sql		:" + countSql);
				System.out.println("重写的 select sql		:" + pageSql);

				Connection connection = (Connection) invocation.getArgs()[0];

				PreparedStatement countStmt = null;
				ResultSet rs = null;
				int totalCount = 0;
				try
				{
					countStmt = connection.prepareStatement(countSql);
					rs = countStmt.executeQuery();
					if (rs.next())
					{
						totalCount = rs.getInt(1);
					}

				} catch (SQLException e)
				{
					System.out.println("Ignore this exception" + e);
				} finally
				{
					try
					{
						rs.close();
						countStmt.close();
					} catch (SQLException e)
					{
						System.out.println("Ignore this exception" + e);
					}
				}

				metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);

				// 绑定count
				co.setCount(totalCount);
			}
		}

		return invocation.proceed();
	}

	/**
	 * 拦截类型StatementHandler
	 */
	@Override
	public Object plugin(Object target)
	{
		System.out.println("target== " + target);
		if (target instanceof StatementHandler)
		{
			return Plugin.wrap(target, this);
		} else
		{
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties)
	{
		dataType = (String) properties.get("dataType");
	}

	public String concatCountSql(String sql)
	{
		StringBuffer sb = new StringBuffer("select count(0) from ");
		sql = sql.toLowerCase();

		sb.append("( ").append(sql).append(" ) t_temp");

		System.out.println(sb.toString());

		return sb.toString();
	}

	/**
	 * mysql分页查询语句和oracle不同，将数据库类型配置好，判断生成那种分页查询语句
	 * 
	 * @param sql
	 * @param co
	 * @return
	 */
	public String concatPageSql(String sql, Common co)
	{
		StringBuffer sb = new StringBuffer();
		if ("mysql".equals(dataType))
		{
			sb.append(sql);
			sb.append(" limit ").append(co.getPagebegin()).append(" , ")
					.append(co.getPagesize());
		} else if ("oracle".equals(dataType))
		{
			// oracle分页查询sql
			sb.append("select * from (select tmp_tb.*,ROWNUM as row_id from (");
			sb.append(sql);
			// pageSql.append(") as tmp_tb where ROWNUM<=");
			sb.append(") tmp_tb where ROWNUM<=");
			sb.append(co.getPagesize());
			sb.append(") where row_id>=");
			sb.append(co.getPagebegin());
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	public void setPageCount()
	{

	}

}