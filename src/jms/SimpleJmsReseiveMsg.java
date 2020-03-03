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
 * ��Ϣ���գ���Ե�ģʽ
 * 
 * @author Administrator
 * 
 */
public class SimpleJmsReseiveMsg
{
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // Ĭ�ϵ����ӵ�ַ

	public static void main(String[] args) throws JMSException
	{
		ConnectionFactory factory = new ActiveMQConnectionFactory("admin",
				"admin", SimpleJmsReseiveMsg.BROKEURL);// ���ӹ���
		Connection conn = factory.createConnection();// ����
		conn.start();
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination dest = session.createQueue("firstQueue");
		MessageConsumer messageConsumer = session.createConsumer(dest); // ��Ϣ��������
		// while (true)
		// {
		// TextMessage textMessage = (TextMessage) messageConsumer
		// .receive(100000);
		// if (textMessage != null)
		// {
		// System.out.println("�յ�����Ϣ��" + textMessage.getText());
		// } else
		// {
		// break;
		// }
		// }
		messageConsumer.setMessageListener(new Listener());
	}
}
