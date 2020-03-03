package spring.component;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@ComponentScan(basePackages = "spring.component")
@ComponentScan(basePackageClasses =
{ ComTest.class })
public class Cdplayer
{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext c;
	}
}
