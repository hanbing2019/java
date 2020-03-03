package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import jms.listener.TopicListener1;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicJmsRecieveMsg1
{
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

	public static void main(String[] args) throws JMSException
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", TopicJmsRecieveMsg1.BROKEURL);// 连接工厂
		Connection conn = factory.createConnection();// 连接
		conn.start();
		// createSession第一个参数：
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createTopic("firstTopic");
		MessageConsumer messageConsumer = session.createConsumer(dest); // 消息的消费者
		messageConsumer.setMessageListener(new TopicListener1());

		session.commit();// 表示消息确认
	}
}
