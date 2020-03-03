package spring.unique;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.unique.impl.Banana;

@Configuration
public class FruitConfig1
{

	@Bean
	public Fruit getFruit()
	{
		return new Banana();
	}
}
