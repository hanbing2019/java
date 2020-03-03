package spring.unique.impl;

import org.springframework.stereotype.Component;

import spring.unique.Fruit;

@Component
// @Qualifier("apple")
public class Apple implements Fruit
{

	@Override
	public void getName()
	{
		System.out.println("---Apple---");
	}

}
