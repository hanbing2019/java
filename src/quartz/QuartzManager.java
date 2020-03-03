package quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Title:Quartz管理类
 * 
 * @Description:实现任务的添加，暂停，修改，删除
 * 
 */
public class QuartzManager
{
	// 创建任务工厂
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	public static String JOB_NAME = "动态任务调度";
	public static String TRIGGER_NAME = "动态任务触发器";
	public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";
	public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";

	/**
	 * @Description: 添加一个定时任务
	 * 
	 * @param jobName
	 *            任务名
	 * @param jobGroupName
	 *            任务组名
	 * @param triggerName
	 *            触发器名
	 * @param triggerGroupName
	 *            触发器组名
	 * @param jobClass
	 *            任务
	 * @param cron
	 *            时间设置，参考quartz说明文档
	 */
	@SuppressWarnings(
	{ "unchecked", "rawtypes" })
	public static void addJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, Class jobClass,
			String cron)
	{
		try
		{
			Scheduler sched = schedulerFactory.getScheduler();
			// 任务名，任务组，任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, jobGroupName).build();
			JobDataMap jdm = jobDetail.getJobDataMap();

			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
					.newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// 调度容器设置JobDetail和Trigger
			sched.scheduleJob(jobDetail, trigger);

			// 启动
			if (!sched.isShutdown())
			{
				sched.start();
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 修改一个任务的触发时间
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 *            触发器名
	 * @param triggerGroupName
	 *            触发器组名
	 * @param cron
	 *            时间设置，参考quartz说明文档
	 */
	public static void modifyJobTime(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, String cron)
	{
		try
		{
			Scheduler sched = schedulerFactory.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,
					triggerGroupName);
			CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerKey);
			if (trigger == null)
			{
				return;
			}

			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron))
			{
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
						.newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder
						.cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				sched.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */

				/** 方式二：先删除，然后在创建一个新的Job */
				// JobDetail jobDetail =
				// sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
				// Class<? extends Job> jobClass = jobDetail.getJobClass();
				// removeJob(jobName, jobGroupName, triggerName,
				// triggerGroupName);
				// addJob(jobName, jobGroupName, triggerName, triggerGroupName,
				// jobClass, cron);
				/** 方式二 ：先删除，然后在创建一个新的Job */
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: 移除一个任务
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 * @param triggerGroupName
	 */
	public static void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName)
	{
		try
		{
			Scheduler sched = schedulerFactory.getScheduler();

			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,
					triggerGroupName);

			sched.pauseTrigger(triggerKey);// 停止触发器
			sched.unscheduleJob(triggerKey);// 移除触发器
			sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:启动所有定时任务
	 */
	public static void startJobs()
	{
		try
		{
			Scheduler sched = schedulerFactory.getScheduler();
			sched.start();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:关闭所有定时任务
	 */
	public static void shutdownJobs()
	{
		try
		{
			Scheduler sched = schedulerFactory.getScheduler();
			if (!sched.isShutdown())
			{
				sched.shutdown();
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args)
	{
		try
		{
			System.out.println("【系统启动】开始(每1秒输出一次)...");
			QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME,
					TRIGGER_GROUP_NAME, TestJob.class, "0/1 * * * * ?");

			Thread.sleep(5000);
			System.out.println("【修改时间】开始(每5秒输出一次)...");
			QuartzManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME,
					TRIGGER_GROUP_NAME, "0/5 * * * * ?");

			Thread.sleep(6000);
			System.out.println("【移除定时】开始...");
			QuartzManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME,
					TRIGGER_GROUP_NAME);
			System.out.println("【移除定时】成功");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}