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
		 * 发送到指定的目的地
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
		// 已经配置了消息目的，调用参数为MessageCreator的send方法
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
		// jmsTemplate调用receive方法即可接收消息，结果返回message
		ObjectMessage m = (ObjectMessage) jmsTemplate.receive();
		try
		{
			String msg = (String) m.getObject();// 获取消息内容
		} catch (JMSException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void receiveConverter()
	{
		// 调用receiveAndConvert方法，该方法内置消息转换器，将消息转换为返回对象
		Object o = jmsTemplate.receiveAndConvert();
	}
}
