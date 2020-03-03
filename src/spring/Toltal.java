package spring;

import javax.annotation.Resource;

public class Toltal
{
	public Toltal()
	{
		System.out.println("load.................");
	}

	@Resource
	private AutoByName autoByName;

	private Book book;

	public Book getBook()
	{
		return book;
	}

	public void setBook(Book book)
	{
		this.book = book;
	}

	public void infoShow()
	{
		// book.test();
		autoByName.test();
	}

}
