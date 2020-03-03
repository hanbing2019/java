package spring.unique.impl;

import org.springframework.stereotype.Component;

import spring.unique.Fruit;

@Component
// @Qualifier("banana")
public class Banana implements Fruit
{

	@Override
	public void getName()
	{
		System.out.println("---Banana---");
	}

}
