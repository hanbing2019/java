package spring.unique;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.unique.impl.Orange;

@Configuration
public class FruitConfig2
{

	@Bean
	public Fruit getFruit()
	{
		return new Orange();
	}
}
