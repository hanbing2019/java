package spring.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class JmsDemo
{

	public static void main(String[] args)
	{
		// 不使用spring的JMS
		// 创建连接消息代理的工厂
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:616161");
		Connection conn = null;
		Session session = null;
		try
		{
			// 建立连接
			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// 创建目的地
			Destination d = new ActiveMQQueue("myqueue");
			// 创建消息生产者
			MessageProducer producer = session.createProducer(d);

			// 创建消息存放容器
			TextMessage msg = session.createTextMessage();
			msg.setText("hello world!!");// 存放消息
			producer.send(msg);// 发送消息

		} catch (JMSException e)
		{
			e.printStackTrace();
		} finally
		{
			if (session != null)
			{
				try
				{
					session.close();
				} catch (JMSException e)
				{
					e.printStackTrace();
				}
			}
			if (conn != null)
			{
				try
				{
					conn.close();
				} catch (JMSException e)
				{
					e.printStackTrace();
				}
			}

		}
	}
}
