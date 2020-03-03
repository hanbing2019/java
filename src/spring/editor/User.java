package spring.editor;

import java.util.Date;

public class User
{
	Date date;

	/**
	 * @return the date
	 */
	public Date getDate()
	{
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date)
	{
		this.date = date;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "User [date=" + date + "]";
	}

}
