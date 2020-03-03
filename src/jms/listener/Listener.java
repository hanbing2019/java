package jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class Listener implements MessageListener
{

	@Override
	public void onMessage(Message msg)
	{
		try
		{
			System.out.println("收到的消息 ：" + ((TextMessage) msg).getText());
		} catch (JMSException e)
		{
			e.printStackTrace();
		}

	}

}
