package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class DealXml
{
	// dom4j创建xml
	public static void createXml(String filename)
	{
		Document doc = DocumentHelper.createDocument();
		// 创建一级目录
		Element root1 = doc.addElement("root1");

		// 设置属性
		root1.addAttribute("id", "root1id");

		// 创建一级目录的子节点
		Element e1 = root1.addElement("c1");
		e1.setText("dsd");
		Element e2 = root1.addElement("c2");
		e2.setText("asd");

		try
		{
			File file = new File(filename);
			Writer writer = new FileWriter(file);
			XMLWriter xw = new XMLWriter(writer);

			xw.write(doc);
			xw.close();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	// dom4j解析xml
	public static void paraser(String filename)
	{
		// 创建saxreader解读器，
		SAXReader sax = new SAXReader();
		try
		{
			File file = new File(filename);
			Document doc = sax.read(file);
			// 获取跟节点
			Element root = doc.getRootElement();
			// 获取下级节点
			List<Element> list = root.elements();
			for (Element element : list)
			{
				System.out.println("节点名称 " + element.getName());
				// System.out.println("节点内容" + element.getText());
			}
		} catch (DocumentException e)
		{
			e.printStackTrace();
		}
	}

	public static Document getDocment(String filename)
	{
		SAXReader sax = new SAXReader();
		Document doc = null;
		try
		{
			doc = sax.read(new File(filename));
		} catch (DocumentException e)
		{
			e.printStackTrace();
		}
		return doc;
	}

	// dom4j修改xml
	public static void modifyXml(String filename)
	{
		Document doc = getDocment(filename);
		if (doc != null)
		{
			Element root = doc.getRootElement();

			List<Element> list = root.elements();
			for (Element element : list)
			{
				if ("c2".equals(element.getName()))
				{
					element.setText("new context");
				}
				if ("c1".equals(element.getName()))
				{
					// 删除节点
					root.remove(element);
				}
			}
			Element c3 = root.addElement("c3");
			c3.setText("c3 Text");

			// 重新写入xml
			try
			{
				File file = new File(filename);
				Writer w = new FileWriter(file);

				XMLWriter xml = new XMLWriter(w);
				xml.write(doc);
				xml.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * 将xml转换为string
	 * 
	 * @param filename
	 */
	public static void xml2string(String filename)
	{
		SAXReader sax = new SAXReader();
		try
		{
			Document doc = sax.read(new File(filename));
			String conetnt = doc.asXML();
			System.out.println(conetnt);
		} catch (DocumentException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param msg
	 * @param filename
	 */
	public static void string2xml(String msg, String filename)
	{
		try
		{
			Document doc = DocumentHelper.parseText(msg);

			XMLWriter xml = new XMLWriter(new FileWriter(new File(filename)));

			xml.write(doc);
			xml.close();
		} catch (DocumentException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		// DealXml.createXml("create.xml");
		// DealXml.paraser("recourse/xml/config.xml");
		// DealXml.modifyXml("create.xml");
		DealXml.xml2string("create.xml");

		String msg = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root1 id=\"root1id\"><c2/><c3>c3 Text</c3></root1>";

		DealXml.string2xml(msg, "create1.xml");

	}
}
