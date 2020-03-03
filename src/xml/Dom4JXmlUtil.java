package xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 
 * Dom4j 生成XML文档与解析XML文档
 */
public class Dom4JXmlUtil
{

	/**
	 * 生成xml
	 * 
	 * @param fileName
	 */
	public void createXml(String fileName)
	{
		// 获取document对象
		Document document = DocumentHelper.createDocument();
		Element employees = document.addElement("employees");
		employees.addProcessingInstruction("target", "text");
		Element employee = employees.addElement("employee");
		Element name = employee.addElement("name");
		name.addAttribute("id", "nu");
		name.setText("ddvip");
		Element sex = employee.addElement("sex");
		sex.setText("m");
		Element age = employee.addElement("age");
		age.setText("29");
		try
		{
			Writer fileWriter = new FileWriter(fileName);
			XMLWriter xmlWriter = new XMLWriter(fileWriter);
			xmlWriter.write(document);
			xmlWriter.close();
		} catch (IOException e)
		{

			System.out.println(e.getMessage());
		}

	}

	/**
	 * 利用dom4j进行xml文档的写入操作
	 */
	public void createXml(File file)
	{
		// XML 声明 <?xml version="1.0" encoding="UTF-8"?> 自动添加到 XML文档中
		// 使用DocumentHelper类创建文档实例(生成 XML文档节点的 dom4j API工厂类)
		Document document = DocumentHelper.createDocument();
		// 使用addElement()方法创建根元素 employees(用于向 XML 文档中增加元素)
		Element root = document.addElement("employees");
		// 在根元素中使用 addComment()方法添加注释"An XML Note"
		root.addComment("An XML Note");
		// 在根元素中使用 addProcessingInstruction()方法增加一个处理指令
		root.addProcessingInstruction("target", "text");
		// 在根元素中使用 addElement()方法增加employee元素。
		Element empElem = root.addElement("employee");
		// 使用 addAttribute()方法向employee元素添加id和name属性
		empElem.addAttribute("id", "0001");
		empElem.addAttribute("name", "wanglp");
		// 向employee元素中添加sex元素
		Element sexElem = empElem.addElement("sex");
		// 使用setText()方法设置sex元素的文本
		sexElem.setText("m");
		// 在employee元素中增加age元素 并设置该元素的文本。
		Element ageElem = empElem.addElement("age");
		ageElem.setText("25");
		// 在根元素中使用 addElement()方法增加employee元素。
		Element emp2Elem = root.addElement("employee");
		// 使用 addAttribute()方法向employee元素添加id和name属性
		emp2Elem.addAttribute("id", "0002");
		emp2Elem.addAttribute("name", "fox");
		// 向employee元素中添加sex元素
		Element sex2Elem = emp2Elem.addElement("sex");
		// 使用setText()方法设置sex元素的文本
		sex2Elem.setText("f");
		// 在employee元素中增加age元素 并设置该元素的文本。
		Element age2Elem = emp2Elem.addElement("age");
		age2Elem.setText("24");
		// 可以使用 addDocType()方法添加文档类型说明。
		// document.addDocType("employees", null, "file://E:/Dtds/dom4j.dtd");
		// 这样就向 XML 文档中增加文档类型说明：
		// <!DOCTYPE employees SYSTEM "file://E:/Dtds/dom4j.dtd">
		// 如果文档要使用文档类型定义（DTD）文档验证则必须有 Doctype。
		try
		{
			XMLWriter output = new XMLWriter(new FileWriter(file));
			output.write(document);
			output.close();
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 解析xml
	 * 
	 */
	public void parserXml(String fileName)
	{
		File inputXml = new File(fileName);
		SAXReader saxReader = new SAXReader();
		try
		{
			Document document = saxReader.read(inputXml);
			Element employees = document.getRootElement();
			for (Iterator i = employees.elementIterator(); i.hasNext();)
			{
				Element employee = (Element) i.next();
				// employee.getParent().remove(employee);
				for (Iterator j = employee.elementIterator(); j.hasNext();)
				{
					Element node = (Element) j.next();
					System.out.println(node.getName() + ":" + node.getText());
				}

			}
		} catch (DocumentException e)
		{
			System.out.println(e.getMessage());
		}
		System.out.println("dom4j parserXml");
	}

	public static void main(String args[]) throws DocumentException
	{
		Dom4JXmlUtil dxu = new Dom4JXmlUtil();
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(new File("dom4j.xml"));
		Element root = doc.getRootElement();
		System.out.println(root.getName());
		// dxu.createXml("dom4j.xml");
		// File file = new File("dom4j.xml");
		// dxu.createXml(file);
		// dxu.parserXml("dom4j.xml");
	}
}
