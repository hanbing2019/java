package mybatis;

public class TestInfo
{
	long id;
	String dateStr;
	String describ;

	/**
	 * @return the id
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * @return the dateStr
	 */
	public String getDateStr()
	{
		return dateStr;
	}

	/**
	 * @param dateStr
	 *            the dateStr to set
	 */
	public void setDateStr(String dateStr)
	{
		this.dateStr = dateStr;
	}

	/**
	 * @return the describ
	 */
	public String getDescrib()
	{
		return describ;
	}

	/**
	 * @param describ
	 *            the describ to set
	 */
	public void setDescrib(String describ)
	{
		this.describ = describ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "TestInfo [dateStr=" + dateStr + ", describ=" + describ + "]";
	}

}
