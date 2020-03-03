package spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextStartedEvent;

/**
 * 自定义事件
 * 
 * @author Administrator
 * 
 */
public class MyEvent extends ContextStartedEvent
{

	public MyEvent(ApplicationContext source)
	{
		super(source);
	}
}
