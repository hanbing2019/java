package spring.aopannotation;

import org.springframework.stereotype.Component;

@Component
public class SayDemo
{
	public void say()
	{

		System.out.println("hello world !!");
		// throw new RuntimeException("--“Ï≥£--");
	}

	public void count(int count)
	{
		System.out.println("get num :" + count);
	}
}
