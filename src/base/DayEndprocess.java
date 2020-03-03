package base;

public abstract class DayEndprocess
{
	/**
	 * ����ǰ
	 * 
	 * @throws Exception
	 */
	public abstract void preProcess() throws Exception;

	/**
	 * ������
	 * 
	 * @throws Exception
	 */
	public abstract void processing() throws Exception;

	/**
	 * ���������
	 * 
	 * @throws Exception
	 */
	public abstract void processed() throws Exception;

	public void excute() throws Exception
	{
		preProcess();

		processing();

		processed();

	}
}
