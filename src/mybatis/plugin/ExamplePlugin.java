package mybatis.plugin;

import java.util.Properties;

import mybatis.User;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;

@Intercepts(
{ @Signature(type = User.class, method = "func", args =
{ String.class }) })
public class ExamplePlugin implements Interceptor
{

	private String someProperty;

	public String getSomeProperty()
	{
		return someProperty;
	}

	public void setSomeProperty(String someProperty)
	{
		this.someProperty = someProperty;
	}

	@Override
	public Object intercept(Invocation invocation) throws Throwable
	{
		System.out.println("intercept");
		System.out.println(someProperty);
		System.out.println(invocation.proceed());
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object obj)
	{
		System.out.println(obj);
		System.out.println("plugin1");
		return Plugin.wrap(obj, this);
	}

	/**
	 * 获取plugin配置属性和值
	 * 
	 * <property name="someProperty" value="100"/>
	 */
	@Override
	public void setProperties(Properties properties)
	{
		System.out.println(properties.entrySet());
		System.out.println("setProperties");
	}

}
