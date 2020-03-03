package zookeeper.zkclient;

import com.ql.util.express.ExpressRunner;

public class MasterSelector
{
	public static void main(String[] args) throws Exception
	{
		ExpressRunner runner = new ExpressRunner();
		String obj = runner.execute("2+5", null, null, false, false).toString();
		System.out.println(obj);
	}
}
