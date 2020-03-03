package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest
{
	public static void main(String args[]) throws Exception
	{
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:aop-config.xml");
		JavaMath df = (JavaMath) context.getBean("javaMath");
		User u = new User();
		u.setName("mmmm");
		df.sub("sd", u);

		// context.getBean("advices");
		// context.publishEvent(new ContextStartedEvent(context));
		// context.publishEvent(new ContextClosedEvent(context));
		// context.getMessage("", args, Locale.US);
		// ContextStartedEvent cse = new ContextStartedEvent(context);
		// context.publishEvent(cse);
		// JavaMath javaMath = (JavaMath) context.getBean("javaMath");
		// javaMath.add("dd");

		// ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		// rbms.setBasename("message");

		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "transcation2-config.xml");
		// JDBCDao jdao = (JDBCDao) context.getBean("jDBCDao2");
		// jdao.update();

		// java.lang.ClassCastException: com.sun.proxy.$Proxy* cannot be cast
		// to***问题解决方案
		// spring aop的代理机制有2中，1 jdk动态代理，2cglib;
		// 当JDBCDaoImpl实现了JDBCDao接口时，默认使用jdk动态代理模式,如果没有实现接口就会使用cglib模式
		// 实现了接口，那么强制转换必须使用接口类型

		// 手动装配 autowire值为no <property name="book" ref="book"/>
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "spring-redis.xml");
		// Toltal toltal = (Toltal) context.getBean("toltal");
		// toltal.infoShow();
		// bean-config-component.xml
		// comTest
		// ApplicationContext context = new ClassPathXmlApplicationContext(
		// "bean-config-aop.xml");
		// Dealfunc df = (Dealfunc) context.getBean("df");
		// df.func2(4, "tom");
		// df.func2(6, "tony");

		// Integer a = 100, b = 100;
		// Integer c = 128, d = 128;
		// Integer e = -129, f = -129;
		//
		// System.out.println(a == b);
		// System.out.println(c == d);
		// System.out.println(e == f);

		// str();
		// flo();
		// str1();
		// str2();//

		// cc.getBean("");

		// ServiceDemo serviceDemo = (ServiceDemo)
		// context.getBean("serviceDemo");
		// serviceDemo.doSomething();
		// BeanFactory n;
		// ApplicationContext d;
	}

	public static void str()
	{
		System.out.println("------------------------------------------");
		String str1 = new StringBuilder("qw").append("ds").toString();
		System.out.println(str1.intern() == str1);// true

		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);// false
	}

	public static void str1()
	{
		System.out.println("+==================================");
		String str1 = new String("seu") + new String("Calvin");
		System.out.println(str1.intern() == str1);
		System.out.println("seuCalvin" == str1);
	}

	public static void str2()
	{
		System.out.println("+==================================");
		String str2 = "seuCalvin";
		String str3 = "seuCalvin";
		String str1 = new String("seu") + new String("Calvin");
		System.out.println(str1.intern() == str1);
		System.out.println("seuCalvin" == str1);
		System.out.println(str2 == str3);
	}

	public static void flo()
	{
		System.out.println("------------------------------------------");
		Float xx = 2.0f;
		Float yy = 1.8f;
		Float tt = xx - yy;

		System.out.println(tt);
	}
}
