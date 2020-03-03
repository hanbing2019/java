package jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import jms.listener.Listener;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息接收，点对点模式
 * 
 * @author Administrator
 * 
 */
public class SimpleJmsReseiveMsg
{
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

	public static void main(String[] args) throws JMSException
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", SimpleJmsReseiveMsg.BROKEURL);// 连接工厂
		Connection conn = factory.createConnection();// 连接
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createQueue("firstQueue");
		MessageConsumer messageConsumer = session.createConsumer(dest); // 消息的消费者
		// while (true)
		// {
		// TextMessage textMessage = (TextMessage) messageConsumer
		// .receive(100000);
		// if (textMessage != null)
		// {
		// System.out.println("收到的消息：" + textMessage.getText());
		// } else
		// {
		// break;
		// }
		// }
		messageConsumer.setMessageListener(new Listener());
	}
}
