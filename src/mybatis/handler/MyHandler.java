package mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

@MappedJdbcTypes(JdbcType.DATE)
public class MyHandler extends BaseTypeHandler<String>
{

	@Override
	public String getNullableResult(ResultSet rs, String colum)
			throws SQLException
	{
		System.out.println("-getNullableResult - " + colum);

		Date date = rs.getDate(colum);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("-------------" + date);
		return sdf.format(date);

	}

	@Override
	public String getNullableResult(ResultSet arg0, int arg1)
			throws SQLException
	{
		// TODO Auto-generated method stub
		System.out.println("-getNullableResult");
		return null;
	}

	@Override
	public String getNullableResult(CallableStatement arg0, int arg1)
			throws SQLException
	{
		// TODO Auto-generated method stub
		System.out.println("--getNullableResult");
		return null;
	}

	@Override
	public void setNonNullParameter(PreparedStatement arg0, int arg1,
			String arg2, JdbcType arg3) throws SQLException
	{
		// TODO Auto-generated method stub
		System.out.println("--setNonNullParameter");

	}

}
