package thread;

public interface ThreadPool<Job extends Runnable>
{
	// 执行任务
	void execute(Job job);

	// 添加工作线程
	void addWorker(int num);

	// 添加任务
	void shutdown();

	// 删除工作
	void removeWorker(int num);

	int getJobSize();

}
