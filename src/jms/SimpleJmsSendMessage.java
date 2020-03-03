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
 * ������Ϣ����Ϣ����
 * 
 * @author Administrator
 * 
 */
public class SimpleJmsSendMessage
{
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // Ĭ�ϵ����ӵ�ַ

	public static void main(String[] args) throws JMSException
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", SimpleJmsSendMessage.BROKEURL);// ���ӹ���
		Connection conn = factory.createConnection();// ����
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
			TextMessage mgs = session.createTextMessage("������Ϣ" + i);
			producer.send(mgs);
		}
	}
}
