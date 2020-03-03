package spring.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceDemo implements BeanNameAware, BeanFactoryAware,
		ApplicationContextAware, BeanPostProcessor, InitializingBean,
		DisposableBean
{
	public void doSomething()
	{
		System.out.println("doSomething");
	}

	@Override
	public void setBeanName(String name)
	{
		System.out.println("setBeanName " + name);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException
	{

	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException
	{

	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy() throws Exception
	{
		System.out.println("destroy");

	}

}
