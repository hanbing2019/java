package spring.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class SpringJmsDemo
{

	@Autowired
	JmsTemplate jmsTemplate;

	@Autowired
	Destination queue;

	public void sendMsg()
	{
		/**
		 * ���͵�ָ����Ŀ�ĵ�
		 */
		jmsTemplate.send(queue, new MessageCreator()
		{

			@Override
			public Message createMessage(Session session) throws JMSException
			{
				TextMessage text = session.createTextMessage();
				text.setText("hello world");
				return text;
			}
		});
	}

	public void sendMsg(String msg)
	{
		jmsTemplate.convertAndSend(msg);
		// �Ѿ���������ϢĿ�ģ����ò���ΪMessageCreator��send����
		jmsTemplate.send(new MessageCreator()
		{

			@Override
			public Message createMessage(Session session) throws JMSException
			{
				return null;
			}
		});
	}

	public void convertSend()
	{
		// MappingJackson2MessageConverter converter = new
		// MappingJackson2MessageConverter();
	}

	public void receive()
	{
		// jmsTemplate����receive�������ɽ�����Ϣ���������message
		ObjectMessage m = (ObjectMessage) jmsTemplate.receive();
		try
		{
			String msg = (String) m.getObject();// ��ȡ��Ϣ����
		} catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void receiveConverter()
	{
		// ����receiveAndConvert�������÷���������Ϣת����������Ϣת��Ϊ���ض���
		Object o = jmsTemplate.receiveAndConvert();
	}
}
