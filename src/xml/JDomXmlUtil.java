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
 * jdom解析xml
 * 
 * @author Administrator
 * 
 */
public class JDomXmlUtil
{
	public static Document getDoucment(String filename)
	{
		// 创建解析
		SAXBuilder sax = new SAXBuilder();
		Document doc = null;
		try
		{
			// build方法的参数可以是String（文件路径） file（文件对象） inputStream(输入流)
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

	// 获取唯一叶子节点
	/**
	 * 
	 * @param path
	 *            :配置文件中节点的路径
	 * @param filename
	 *            :xml文件路径
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
	 * 取路径相同的节点
	 * 
	 * @param filename
	 *            xml文件路径
	 * @param path
	 *            配置文件中节点的路径
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
	 * 节点添加
	 * 
	 * @param filename
	 * @param path节点路径
	 *            ，该节点必须是唯一的
	 * @param map
	 *            key作为节点名，value为节点内容
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
	 * 向xml写入数据
	 */
	public void writeXml()
	{
		Document doc = new Document();// 创建jdom的document对象
		Element root = new Element("root");// 创建节点
		Element c1 = new Element("c1");
		c1.setText("hello world");// setText给节点赋予文本内容
		root.addContent(c1);// 设置节点之间的关系，确认父节点和子节点
		doc.setRootElement(root);// 设置根元素

		Format format = Format.getCompactFormat();
		format.setEncoding("utf-8"); // 设置xml文件的字符为gb2312
		format.setIndent("    "); // 设置xml文件的缩进为4个空格
		XMLOutputter XMLOut = new XMLOutputter(format);// 元素后换行一层元素缩四格
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
	 * 读取xml
	 */
	public void readXml()
	{
		SAXBuilder builder = new SAXBuilder();
		try
		{
			// 获取xml的document对象
			Document doc = builder.build(new File("recourse/xml/file3.xml"));
			System.out.println(doc);
			Element e = doc.getRootElement();// 获取root元素
			System.out.println(e);
			List<Element> elist = e.getChildren("c1");// 取出名为c1的子元素
			System.out.println(elist.get(0).getText());
			for (Element element : elist)
			{
				// 取出元素的文本内容
				String text = element.getText();
				System.out.println(text);
				// 取出属性
				Attribute attr = element.getAttribute("name");
				String value = attr.getValue();// 取出属性的值
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
