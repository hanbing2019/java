package json;

public class ModelInfo extends ExJson
{
	private String st1;
	private String st2;
	public MiniInfo mini;

	public ModelInfo()
	{

	}

	public ModelInfo(String st1, String st2, MiniInfo mini)
	{
		this.st1 = st1;
		this.st2 = st2;
		this.mini = mini;
	}

	/**
	 * @return the st1
	 */
	public String getSt1()
	{
		return st1;
	}

	/**
	 * @param st1
	 *            the st1 to set
	 */
	public void setSt1(String st1)
	{
		this.st1 = st1;
	}

	/**
	 * @return the st2
	 */
	public String getSt2()
	{
		return st2;
	}

	/**
	 * @param st2
	 *            the st2 to set
	 */
	public void setSt2(String st2)
	{
		this.st2 = st2;
	}

	/**
	 * @return the mini
	 */
	public MiniInfo getMini()
	{
		return mini;
	}

	/**
	 * @param mini
	 *            the mini to set
	 */
	public void setMini(MiniInfo mini)
	{
		this.mini = mini;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "ModelInfo [st1=" + st1 + ", st2=" + st2 + ", mini=" + mini
				+ "]";
	}

}
