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
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // Ĭ�ϵ������û���
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // Ĭ�ϵ���������
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // Ĭ�ϵ����ӵ�ַ

	public static void main(String[] args) throws JMSException
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", TopicJmsRecieveMsg1.BROKEURL);// ���ӹ���
		Connection conn = factory.createConnection();// ����
		conn.start();
		// createSession��һ��������
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createTopic("firstTopic");
		MessageConsumer messageConsumer = session.createConsumer(dest); // ��Ϣ��������
		messageConsumer.setMessageListener(new TopicListener1());

		session.commit();// ��ʾ��Ϣȷ��
	}
}
