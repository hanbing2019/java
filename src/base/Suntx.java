package base;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Suntx extends DayEndprocess
{

	@Override
	public void preProcess() throws Exception
	{
		System.out.println("预处理");

	}

	@Override
	public void processing() throws Exception
	{
		System.out.println("执行");
	}

	@Override
	public void processed() throws Exception
	{
		System.out.println("执行后");
	}

	private void test()
	{
		System.out.println("ddd");
	}

	public static void main(String args[]) throws Exception
	{
		Suntx s = new Suntx();
		// load load = new load();
		// s.excute();
		GregorianCalendar calendar = new GregorianCalendar();
		System.out.println(calendar.getFirstDayOfWeek());
		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR));
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR));
	}

}

class other
{
	other()
	{
		System.out.println("f gouz");
	}

	other(String a)
	{
		System.out.println(a);
	}

	private void func(Suntx s)
	{
		// s.test();
	}

	void func2()
	{
		System.out.println("test");
	}
}

class load extends other
{
	public void funcd()
	{
	}

	load(String a)
	{
		System.out.println(a);
	}

	public static void main(String args[]) throws Exception
	{
		load load = new load("w");
		load.func2();
	}
}
