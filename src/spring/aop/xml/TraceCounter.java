package spring.aop.xml;

public class TraceCounter
{

	public void countTrace(int traceNumber, String str)
	{
		System.out.println("调用方法的参数 " + traceNumber);
		System.out.println("调用方法的参数 " + str);
	}

}
