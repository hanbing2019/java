package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 发送消息到消息代理
 * 
 * @author Administrator
 * 
 */
public class SimpleJmsSendMessage
{
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

	public static void main(String[] args) throws JMSException
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", SimpleJmsSendMessage.BROKEURL);// 连接工厂
		Connection conn = factory.createConnection();// 连接
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createQueue("firstQueue");
		MessageProducer producer = session.createProducer(dest);
		sendMessage(producer, session);
		conn.close();
	}

	public static void sendMessage(MessageProducer producer, Session session)
			throws JMSException
	{
		for (int i = 10; i < 20; i++)
		{
			TextMessage mgs = session.createTextMessage("发送消息" + i);
			producer.send(mgs);
		}
	}
}
