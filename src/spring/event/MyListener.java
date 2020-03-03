package spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

/**
 * ÊÂ¼þ¼àÌý
 * 
 * @author Administrator
 * 
 */
public class MyListener implements ApplicationListener<ContextStartedEvent>
{

	@Override
	public void onApplicationEvent(ContextStartedEvent event)
	{
		System.err.println("Æô¶¯¼àÌý");
	}
}
