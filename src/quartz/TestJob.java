package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJob implements Job
{
	static ApplicationContext context;
	static
	{
		context = new ClassPathXmlApplicationContext("transcation2-config.xml");
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		// System.out.println(context);
		// JDBCDao jdao = (JDBCDao) context.getBean("jDBCDao2");
		// jdao.update();
		// arg0.getJobDetail().getJobDataMap();
		// �ڴ�������ʱ ͨ��jobDetail��ȡJobDataMap,JobDataMap�ܹ��������
		// JobExecutionContext�����ȡjobDetail.�õ�JobDataMap()��ȡ��֮ǰ������
		System.out.println("dddddddddddddddddd");
	}

	public static void main(String args[])
	{
		String code = "01,02,";
		System.out.println(code.split(",").length);
		int a = code.split(",").length;
		String ss[] = code.split(",");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < a; i++)
		{
			sb.append("'" + ss[i] + "'").append(",");
		}
		String inc = sb.toString();
		String ccon = inc.substring(0, inc.length() - 1);

	}
}
