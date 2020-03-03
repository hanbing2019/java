package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirList
{
	public static void main(String[] args)
	{
		File file = new File("D:/lzyh");

		// String[] list = file.list(new DirFile(".txt"));
		String[] list = file.list(filter());
		for (String string : list)
		{
			System.out.println(string);
		}

	}

	public static FilenameFilter filter()
	{
		return new FilenameFilter()
		{
			@Override
			public boolean accept(File dir, String name)
			{
				System.out.println(name + " . "
						+ Pattern.compile(".*").matcher(name).matches());
				if (name.indexOf(".txt") != -1)
				{
					return true;
				}
				return false;
			}
		};
	}

}

class DirFile implements FilenameFilter
{
	String regex;
	Pattern p;

	public DirFile(String regex)
	{
		this.regex = regex;
		this.p = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name)
	{
		if (name.indexOf(".txt") != -1)
		{
			return true;
		}
		return false;
	}

}
