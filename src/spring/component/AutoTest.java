package spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AutoTest
{
	ComTest ct;

	@Autowired(required = false)
	AutoTest(ComTest ct)
	{
		this.ct = ct;
	}

	@Autowired(required = false)
	public void setCt(ComTest ct)
	{
		this.ct = ct;
	}

	@Autowired(required = false)
	public void init(ComTest ct)
	{
		this.ct = ct;
	}

	public void func()
	{
		System.out.println("AutoTest");
		ct.func();
	}

}
