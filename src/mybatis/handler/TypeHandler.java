package mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

@MappedJdbcTypes(
{ JdbcType.VARCHAR })
@MappedTypes(
{ Date.class })
public class TypeHandler extends BaseTypeHandler<Date>
{
	/**
	 * 但是这种方式有一个缺点那就是只适用于查询操作，即在查询的过程中系统会启用我们自定义的typeHandler，会将秒数转为Date对象，
	 * 但是在插入的时候却不会启用我们自定义的typeHandler
	 * ，想要在插入的时候启用自定义的typeHandler，需要我们在insert节点中简单配置一下，如下：
	 * 
	 * <insert id="insertUser" parameterType="org.sang.bean.User"> INSERT INTO
	 * user4(username,password,regTime) VALUES
	 * (#{username},#{password},#{regTime
	 * ,javaType=Date,jdbcType=VARCHAR,typeHandler
	 * =org.sang.db.MyDateTypeHandler}) </insert>
	 */

	/**
	 * s表示列名
	 */
	@Override
	public Date getNullableResult(ResultSet rs, String s) throws SQLException
	{
		// 根据字段类型取值
		System.out.println(s);
		rs.getString(s);
		return null;
	}

	/**
	 * i表示多少列
	 */
	@Override
	public Date getNullableResult(ResultSet arg0, int i) throws SQLException
	{
		return null;
	}

	/**
	 * i表示多少列
	 */
	@Override
	public Date getNullableResult(CallableStatement arg0, int i)
			throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement arg0, int arg1,
			Date arg2, JdbcType arg3) throws SQLException
	{
		// TODO Auto-generated method stub

	}

}
