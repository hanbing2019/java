package xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

/**
 * jdom����xml
 * 
 * @author Administrator
 * 
 */
public class JDomXmlUtil
{
	public static Document getDoucment(String filename)
	{
		// ��������
		SAXBuilder sax = new SAXBuilder();
		Document doc = null;
		try
		{
			// build�����Ĳ���������String���ļ�·���� file���ļ����� inputStream(������)
			doc = sax.build(filename);
		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return doc;

	}

	// ��ȡΨһҶ�ӽڵ�
	/**
	 * 
	 * @param path
	 *            :�����ļ��нڵ��·��
	 * @param filename
	 *            :xml�ļ�·��
	 */
	public static void getSingleNode(String path, String filename)
	{
		try
		{
			Element str = (Element) XPath.selectSingleNode(
					getDoucment(filename), path);

			System.out.println(str.getText());
		} catch (JDOMException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * ȡ·����ͬ�Ľڵ�
	 * 
	 * @param filename
	 *            xml�ļ�·��
	 * @param path
	 *            �����ļ��нڵ��·��
	 */
	public static void getNodes(String filename, String path)
	{
		SAXBuilder sax = new SAXBuilder();
		try
		{
			Document doc = sax.build(filename);
			List<Element> list = XPath.selectNodes(doc, path);
			for (Element element : list)
			{
				System.out.println(element.getChildren().size());
			}
		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * �ڵ����
	 * 
	 * @param filename
	 * @param path�ڵ�·��
	 *            ���ýڵ������Ψһ��
	 * @param map
	 *            key��Ϊ�ڵ�����valueΪ�ڵ�����
	 */
	public static void addElement(String filename, String path,
			Map<String, String> map)
	{
		SAXBuilder sax = new SAXBuilder();
		try
		{
			Document doc = sax.build(filename);
			Element e = (Element) XPath.selectSingleNode(doc, path);
			Iterator<String> key = map.keySet().iterator();
			while (key.hasNext())
			{
				System.out.println(map.get(key.next()));
				Element c = new Element("name");
				c.setText("value");
				e.addContent(c);
			}

			OutputStream os = new ByteArrayOutputStream();
			Format format = Format.getPrettyFormat();
			format.setEncoding("UTF-8");

			XMLOutputter out = new XMLOutputter(format);
			out.output(doc, os);
		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * ��xmlд������
	 */
	public void writeXml()
	{
		Document doc = new Document();// ����jdom��document����
		Element root = new Element("root");// �����ڵ�
		Element c1 = new Element("c1");
		c1.setText("hello world");// setText���ڵ㸳���ı�����
		root.addContent(c1);// ���ýڵ�֮��Ĺ�ϵ��ȷ�ϸ��ڵ���ӽڵ�
		doc.setRootElement(root);// ���ø�Ԫ��

		Format format = Format.getCompactFormat();
		format.setEncoding("utf-8"); // ����xml�ļ����ַ�Ϊgb2312
		format.setIndent("    "); // ����xml�ļ�������Ϊ4���ո�
		XMLOutputter XMLOut = new XMLOutputter(format);// Ԫ�غ���һ��Ԫ�����ĸ�
		try
		{
			XMLOut.output(doc, new FileOutputStream("recourse/xml/file3.xml"));
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * ��ȡxml
	 */
	public void readXml()
	{
		SAXBuilder builder = new SAXBuilder();
		try
		{
			// ��ȡxml��document����
			Document doc = builder.build(new File("recourse/xml/file3.xml"));
			System.out.println(doc);
			Element e = doc.getRootElement();// ��ȡrootԪ��
			System.out.println(e);
			List<Element> elist = e.getChildren("c1");// ȡ����Ϊc1����Ԫ��
			System.out.println(elist.get(0).getText());
			for (Element element : elist)
			{
				// ȡ��Ԫ�ص��ı�����
				String text = element.getText();
				System.out.println(text);
				// ȡ������
				Attribute attr = element.getAttribute("name");
				String value = attr.getValue();// ȡ�����Ե�ֵ
				System.out.println(value);
			}

		} catch (JDOMException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void createDoc()
	{
		Document doc = new Document();

	}

	public static void main(String args[]) throws JDOMException, IOException
	{
		// JDomXmlUtil.getSingleNode("config/ficonfig/appname",
		// "recourse/xml/config.xml");

		// JDomXmlUtil.getNodes("recourse/xml/config.xml", "config/ficonfig");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "tom");
		JDomXmlUtil.addElement("create.xml", "root1/c2", map);

		// JDomXmlUtil jdu = new JDomXmlUtil();
		// jdu.writeXml();
		// jdu.readXml();
	}
}
