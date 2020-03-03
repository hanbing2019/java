package io;

import java.io.File;
import java.util.ArrayList;

public class FileTreeInfo
{
	public static ArrayList<File> fileList = new ArrayList<File>();// 文件
	public static ArrayList<File> dirList = new ArrayList<File>();// 文件夹

	public static FileTreeInfo fileSearch(String pathname)
	{
		FileTreeInfo fti = new FileTreeInfo();
		File file = new File(pathname);
		if (file.exists())
		{
			System.out.println("--");
			File files[] = file.listFiles();
			file(files);
		}
		return fti;
	}

	public static void file(File files[])
	{
		for (File file : files)
		{
			if (file.isDirectory())
			{
				dirList.add(file);
				file(file.listFiles());
			} else
			{
				fileList.add(file);
			}
		}
	}

	public static void main(String[] args)
	{
		func();
	}

	public static void func()
	{
		func();
	}
}
