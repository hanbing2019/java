package base;

public abstract class DayEndprocess
{
	/**
	 * 处理前
	 * 
	 * @throws Exception
	 */
	public abstract void preProcess() throws Exception;

	/**
	 * 处理中
	 * 
	 * @throws Exception
	 */
	public abstract void processing() throws Exception;

	/**
	 * 处理结束后
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
