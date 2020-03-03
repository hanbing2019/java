package spring.unique.impl;

import org.springframework.stereotype.Component;

import spring.unique.Fruit;

@Component
// @Qualifier("orange")
public class Orange implements Fruit
{

	@Override
	public void getName()
	{
		System.out.println("---Orange---");
	}

}
