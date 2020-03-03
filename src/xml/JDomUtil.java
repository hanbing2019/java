package xml;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.jdom.Attribute;
import org.jdom.Content;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

public class JDomUtil implements Serializable
{
	private static final long serialVersionUID = -5062472810095190753L;
	protected Document xmlDoc = null;

	public JDomUtil()
	{
	}

	public JDomUtil(Document xmlDoc)
	{
		this.xmlDoc = xmlDoc;
	}

	public Document getXmlDoc()
	{
		return this.xmlDoc;
	}

	public void setXmlDoc(Document xmlDoc)
	{
		this.xmlDoc = xmlDoc;
	}

	/**
	 * 获取document对象，
	 * 
	 * @param xmlString
	 *            xml文件路径
	 * @return
	 */
	public static Document getDocument(String xmlString)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document anotherDocument = builder
					.build(new StringReader(xmlString));

			// builder = null;

			return anotherDocument;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param file
	 *            xml文件对象
	 * @return
	 */
	public static Document getDocument(File file)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document anotherDocument = builder.build(file);

			// builder = null;

			return anotherDocument;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param ins
	 *            xml文件输入流
	 * @return
	 */
	public static Document getDocument(InputStream ins)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document anotherDocument = builder.build(ins);

			// builder = null;

			return anotherDocument;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Document getDocumentByURL(String urlStr)
	{
		try
		{
			URL url = new URL(urlStr);
			InputStream ins = url.openStream();
			SAXBuilder builder = new SAXBuilder();
			Document anotherDocument = builder.build(ins);
			return anotherDocument;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public static Document getDocumentByFile(String fileName)
	{
		try
		{
			SAXBuilder builder = new SAXBuilder();
			Document anotherDocument = builder.build(new File(fileName));

			// builder = null;

			return anotherDocument;
		} catch (Exception e)
		{
			System.out.println("parse file error:" + fileName);
			e.printStackTrace();
		}
		return null;
	}

	public static Element toRecord(Map paramMap)
	{
		Element ret = new Element("Record");
		Iterator keys = paramMap.keySet().iterator();
		while (keys.hasNext())
		{
			String key = (String) keys.next();
			String value = (String) paramMap.get(key);
			ret.addContent(new Element(key).setText(value));
		}
		return ret;
	}

	public static String toXML(Element xmlDoc)
	{
		return toXML(xmlDoc, "gb2312", false);
	}

	public static String toXML(Element xmlDoc, String encoding, boolean newline)
	{
		ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
		Format format = Format.getPrettyFormat();
		format.setEncoding(encoding);
		XMLOutputter docWriter = new XMLOutputter(format);
		try
		{
			docWriter.output(xmlDoc, byteRep);
		} catch (Exception e)
		{
		}
		return byteRep.toString();
	}

	public static String toXML(Document xmlDoc)
	{
		return toXML(xmlDoc, "gb2312", false);
	}

	public static String toXML(Document xmlDoc, String encoding, boolean newline)
	{
		ByteArrayOutputStream byteRep = new ByteArrayOutputStream();
		Format format = Format.getPrettyFormat();
		format.setEncoding(encoding);
		XMLOutputter docWriter = new XMLOutputter(format);
		try
		{
			docWriter.output(xmlDoc, byteRep);
		} catch (Exception e)
		{
		}
		return byteRep.toString();
	}

	public static String[] getListText(List list)
	{
		String[] result = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			result[i] = ((Element) list.get(i)).getText().trim();
		}
		return result;
	}

	public static Element createPath(Document doc, String path)
			throws JDOMException
	{
		Element ret = null;
		if (doc == null)
			return null;
		if ((path == null) || (path.trim().equals(""))
				|| (!path.startsWith("/")))
			return null;
		if ((ret = (Element) XPath.selectSingleNode(doc, path)) != null)
			return ret;
		String[] paths = path.split("/");
		StringBuffer xpath = new StringBuffer();
		for (int i = 1; i < paths.length - 1; i++)
		{
			if (paths[i].trim().equals(""))
				continue;
			xpath.append("/").append(paths[i].trim());
		}
		StringTokenizer token = new StringTokenizer(paths[(paths.length - 1)],
				"[");

		String name = token.nextToken();
		ret = new Element(name);

		if (xpath.length() > 0)
			createPath(doc, xpath.toString()).addContent(ret);
		else
			doc.addContent(ret);
		return ret;
	}

	public static String getNodeString(Object node)
	{
		String outstr = null;
		if (node != null)
		{
			if ((node instanceof Element))
				outstr = ((Element) node).getText();
			else if ((node instanceof Attribute))
				outstr = ((Attribute) node).getValue();
			else
				outstr = node.toString();
		}
		return outstr;
	}

	public static Element setAttr(Document doc, String path, String attName,
			String text) throws JDOMException
	{
		Element de = createPath(doc, path);
		if (de == null)
			return null;
		if (text != null)
			de.setAttribute(attName, text);
		return de;
	}

	public static Element setText(Document doc, String path, String text)
			throws JDOMException
	{
		Element de = createPath(doc, path);
		if (de == null)
			return null;
		try
		{
			de.setText(text);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return de;
	}

	public Element setText(String path, String text) throws JDOMException
	{
		return setText(this.xmlDoc, path, text);
	}

	public Element setAttr(String path, String attName, String text)
			throws JDOMException
	{
		return setAttr(this.xmlDoc, path, attName, text);
	}

	public List getNodes(String path) throws JDOMException
	{
		return XPath.selectNodes(this.xmlDoc, path);
	}

	public void removeNodes(String path) throws JDOMException
	{
		List nodes = getNodes(path);
		for (int i = 0; (nodes != null) && (nodes.size() > i); i++)
		{
			Object node = nodes.get(i);
			this.xmlDoc.removeContent((Content) node);
		}
	}

	public Object getSingleNode(String path) throws JDOMException
	{
		return XPath.selectSingleNode(this.xmlDoc, path);
	}

	public String getSingleNodeString(String path, String def)
			throws JDOMException
	{
		String output = null;

		output = getNodeString(getSingleNode(path));
		if (output == null)
			output = def;
		return output;
	}

	public String getSingleNodeString(String path) throws JDOMException
	{
		return getSingleNodeString(path, "");
	}

	public static Map toMap(Element ele)
	{
		Map ret = new HashMap();
		if (ele == null)
			return ret;
		List childs = ele.getChildren();
		for (Iterator iter = childs.iterator(); iter.hasNext();)
		{
			Element child = (Element) iter.next();
			String name = child.getName();
			Object value = child.getText();
			if (child.getChildren().size() > 0)
			{
				value = toMap(child);
			}
			if (ret.get(name) != null)
			{
				Object existsValue = ret.get(name);
				ArrayList valarrary = new ArrayList();
				if ((existsValue instanceof ArrayList))
					valarrary = (ArrayList) existsValue;
				else
					valarrary.add(existsValue);
				valarrary.add(value);
				ret.put(name, valarrary);
			} else
			{
				ret.put(name, value);
			}
		}
		return ret;
	}

	public Map getMap()
	{
		if (this.xmlDoc == null)
			return new HashMap();
		return toMap(this.xmlDoc.getRootElement());
	}

	public String toString()
	{
		return toString("GBK", true);
	}

	private String toString(String encoding, boolean newline)
	{
		if (this.xmlDoc == null)
			return null;
		return toXML(this.xmlDoc, encoding, newline);
	}

	public void getValue() throws JDOMException, IOException
	{
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(new File("recourse/xml/file3.xml"));
		System.out.println(XPath.selectNodes(doc, "root/c1"));

	}

	public static void main(String args[]) throws JDOMException, IOException
	{
		// jdom+sax解析xml 获取xml值
		// 1创建saxbuild对象，通过build方法创建document对象
		// 2使用jdom中的XPath类的selectSingleNode方法获取xml中配置的内容，selectSingleNode需要的参数：document对象，配置路径
		/*
		 * SAXBuilder builder = new SAXBuilder(); Document doc =
		 * builder.build(new File("recourse/xml/config.xml")); Object node =
		 * XPath.selectSingleNode(doc, "/config/ficonfig/appname"); JDomUtil jdu
		 * = new JDomUtil(doc);
		 * 
		 * String outstr = jdu.getSingleNodeString("/config/ficonfig/appname");
		 * System.out.println(outstr);
		 */
		System.out.println(System.getProperty("dir"));
	}
}