package spring.unique;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.unique.impl.Apple;
import spring.unique.impl.Banana;
import spring.unique.impl.Orange;

@Configuration
public class FruitConfig
{

	@Bean
	public Service getService()
	{
		return new Service();
	}

	@Bean
	@Qualifier("apple")
	public Fruit getFruit()
	{
		return new Apple();
	}

	@Bean
	@Qualifier("banana")
	public Fruit getFruit1()
	{
		return new Banana();
	}

	@Bean
	@Qualifier("orange")
	public Fruit getFruit2()
	{
		return new Orange();
	}
}
