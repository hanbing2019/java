package json;

public class MiniInfo
{
	public String mis;

	public MiniInfo()
	{

	}

	public MiniInfo(String mis)
	{
		this.mis = mis;
	}

	/**
	 * @return the mis
	 */
	public String getMis()
	{
		return mis;
	}

	/**
	 * @param mis
	 *            the mis to set
	 */
	public void setMis(String mis)
	{
		this.mis = mis;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "MiniInfo [mis=" + mis + "]";
	}

}