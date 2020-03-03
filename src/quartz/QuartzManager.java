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
 * @Title:Quartz������
 * 
 * @Description:ʵ���������ӣ���ͣ���޸ģ�ɾ��
 * 
 */
public class QuartzManager
{
	// �������񹤳�
	private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
	public static String JOB_NAME = "��̬�������";
	public static String TRIGGER_NAME = "��̬���񴥷���";
	public static String JOB_GROUP_NAME = "XLXXCC_JOB_GROUP";
	public static String TRIGGER_GROUP_NAME = "XLXXCC_JOB_GROUP";

	/**
	 * @Description: ���һ����ʱ����
	 * 
	 * @param jobName
	 *            ������
	 * @param jobGroupName
	 *            ��������
	 * @param triggerName
	 *            ��������
	 * @param triggerGroupName
	 *            ����������
	 * @param jobClass
	 *            ����
	 * @param cron
	 *            ʱ�����ã��ο�quartz˵���ĵ�
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
			// �������������飬����ִ����
			JobDetail jobDetail = JobBuilder.newJob(jobClass)
					.withIdentity(jobName, jobGroupName).build();
			JobDataMap jdm = jobDetail.getJobDataMap();

			// ������
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
					.newTrigger();
			// ��������,��������
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// ������ʱ���趨
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// ����Trigger����
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();

			// ������������JobDetail��Trigger
			sched.scheduleJob(jobDetail, trigger);

			// ����
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
	 * @Description: �޸�һ������Ĵ���ʱ��
	 * 
	 * @param jobName
	 * @param jobGroupName
	 * @param triggerName
	 *            ��������
	 * @param triggerGroupName
	 *            ����������
	 * @param cron
	 *            ʱ�����ã��ο�quartz˵���ĵ�
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
				/** ��ʽһ ������ rescheduleJob ��ʼ */
				// ������
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder
						.newTrigger();
				// ��������,��������
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// ������ʱ���趨
				triggerBuilder.withSchedule(CronScheduleBuilder
						.cronSchedule(cron));
				// ����Trigger����
				trigger = (CronTrigger) triggerBuilder.build();
				// ��ʽһ ���޸�һ������Ĵ���ʱ��
				sched.rescheduleJob(triggerKey, trigger);
				/** ��ʽһ ������ rescheduleJob ���� */

				/** ��ʽ������ɾ����Ȼ���ڴ���һ���µ�Job */
				// JobDetail jobDetail =
				// sched.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
				// Class<? extends Job> jobClass = jobDetail.getJobClass();
				// removeJob(jobName, jobGroupName, triggerName,
				// triggerGroupName);
				// addJob(jobName, jobGroupName, triggerName, triggerGroupName,
				// jobClass, cron);
				/** ��ʽ�� ����ɾ����Ȼ���ڴ���һ���µ�Job */
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description: �Ƴ�һ������
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

			sched.pauseTrigger(triggerKey);// ֹͣ������
			sched.unscheduleJob(triggerKey);// �Ƴ�������
			sched.deleteJob(JobKey.jobKey(jobName, jobGroupName));// ɾ������
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Description:�������ж�ʱ����
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
	 * @Description:�ر����ж�ʱ����
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
			System.out.println("��ϵͳ��������ʼ(ÿ1�����һ��)...");
			QuartzManager.addJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME,
					TRIGGER_GROUP_NAME, TestJob.class, "0/1 * * * * ?");

			Thread.sleep(5000);
			System.out.println("���޸�ʱ�䡿��ʼ(ÿ5�����һ��)...");
			QuartzManager.modifyJobTime(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME,
					TRIGGER_GROUP_NAME, "0/5 * * * * ?");

			Thread.sleep(6000);
			System.out.println("���Ƴ���ʱ����ʼ...");
			QuartzManager.removeJob(JOB_NAME, JOB_GROUP_NAME, TRIGGER_NAME,
					TRIGGER_GROUP_NAME);
			System.out.println("���Ƴ���ʱ���ɹ�");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}