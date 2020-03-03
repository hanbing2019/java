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

public class TopicJmsSendMsg
{
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

	public static void main(String[] args) throws JMSException
	{
		System.out.println(BROKEURL);
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", TopicJmsSendMsg.BROKEURL);// 连接工厂
		Connection conn = factory.createConnection();// 连接
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createTopic("firstTopic");
		// session.createQueue("firstQueue");
		MessageProducer producer = session.createProducer(dest);
		sendMessage(producer, session);
		conn.close();
	}

	public static void sendMessage(MessageProducer producer, Session session)
			throws JMSException
	{
		for (int i = 10; i < 20; i++)
		{
			TextMessage mgs = session.createTextMessage("发送消息 " + i);
			producer.send(mgs);
		}

	}
}
