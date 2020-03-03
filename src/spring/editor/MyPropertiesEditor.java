package spring.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MyPropertiesEditor extends PropertyEditorSupport
{

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			this.setValue(sdf.parse(text));
		} catch (ParseException e)
		{
			System.out.println("不是日期字符串");
			e.printStackTrace();
		}
	}
}
