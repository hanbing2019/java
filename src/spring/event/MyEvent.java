package spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.ContextStartedEvent;

/**
 * �Զ����¼�
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
