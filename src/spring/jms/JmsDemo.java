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
		// ��ʹ��spring��JMS
		// ����������Ϣ����Ĺ���
		ConnectionFactory factory = new ActiveMQConnectionFactory(
				"tcp://localhost:616161");
		Connection conn = null;
		Session session = null;
		try
		{
			// ��������
			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// ����Ŀ�ĵ�
			Destination d = new ActiveMQQueue("myqueue");
			// ������Ϣ������
			MessageProducer producer = session.createProducer(d);

			// ������Ϣ�������
			TextMessage msg = session.createTextMessage();
			msg.setText("hello world!!");// �����Ϣ
			producer.send(msg);// ������Ϣ

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
