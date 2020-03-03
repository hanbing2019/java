package jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TopicListener1 implements MessageListener
{

	@Override
	public void onMessage(Message msg)
	{
		TextMessage text = (TextMessage) msg;
		try
		{
			System.out.println(" 1 �յ���Ϣ ��" + text.getText());
		} catch (JMSException e)
		{
			e.printStackTrace();
		}

	}
}
