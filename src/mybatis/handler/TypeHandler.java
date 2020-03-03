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
	 * �������ַ�ʽ��һ��ȱ���Ǿ���ֻ�����ڲ�ѯ���������ڲ�ѯ�Ĺ�����ϵͳ�����������Զ����typeHandler���Ὣ����תΪDate����
	 * �����ڲ����ʱ��ȴ�������������Զ����typeHandler
	 * ����Ҫ�ڲ����ʱ�������Զ����typeHandler����Ҫ������insert�ڵ��м�����һ�£����£�
	 * 
	 * <insert id="insertUser" parameterType="org.sang.bean.User"> INSERT INTO
	 * user4(username,password,regTime) VALUES
	 * (#{username},#{password},#{regTime
	 * ,javaType=Date,jdbcType=VARCHAR,typeHandler
	 * =org.sang.db.MyDateTypeHandler}) </insert>
	 */

	/**
	 * s��ʾ����
	 */
	@Override
	public Date getNullableResult(ResultSet rs, String s) throws SQLException
	{
		// �����ֶ�����ȡֵ
		System.out.println(s);
		rs.getString(s);
		return null;
	}

	/**
	 * i��ʾ������
	 */
	@Override
	public Date getNullableResult(ResultSet arg0, int i) throws SQLException
	{
		return null;
	}

	/**
	 * i��ʾ������
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
