package spring.profiles;

public class ServiceDeal
{
	BaseDao baseDao;

	/**
	 * @param baseDao
	 *            the baseDao to set
	 */
	public void setBaseDao(BaseDao baseDao)
	{
		this.baseDao = baseDao;
	}

	public void test()
	{
		baseDao.func();
	}

}
