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
			System.out.println("�յ�����Ϣ ��" + ((TextMessage) msg).getText());
		} catch (JMSException e)
		{
			e.printStackTrace();
		}

	}

}
