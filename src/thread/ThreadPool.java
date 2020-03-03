package thread;

public interface ThreadPool<Job extends Runnable>
{
	// ִ������
	void execute(Job job);

	// ��ӹ����߳�
	void addWorker(int num);

	// �������
	void shutdown();

	// ɾ������
	void removeWorker(int num);

	int getJobSize();

}
