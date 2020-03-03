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
 * Dom4j ����XML�ĵ������XML�ĵ�
 */
public class Dom4JXmlUtil
{

	/**
	 * ����xml
	 * 
	 * @param fileName
	 */
	public void createXml(String fileName)
	{
		// ��ȡdocument����
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
	 * ����dom4j����xml�ĵ���д�����
	 */
	public void createXml(File file)
	{
		// XML ���� <?xml version="1.0" encoding="UTF-8"?> �Զ���ӵ� XML�ĵ���
		// ʹ��DocumentHelper�ഴ���ĵ�ʵ��(���� XML�ĵ��ڵ�� dom4j API������)
		Document document = DocumentHelper.createDocument();
		// ʹ��addElement()����������Ԫ�� employees(������ XML �ĵ�������Ԫ��)
		Element root = document.addElement("employees");
		// �ڸ�Ԫ����ʹ�� addComment()�������ע��"An XML Note"
		root.addComment("An XML Note");
		// �ڸ�Ԫ����ʹ�� addProcessingInstruction()��������һ������ָ��
		root.addProcessingInstruction("target", "text");
		// �ڸ�Ԫ����ʹ�� addElement()��������employeeԪ�ء�
		Element empElem = root.addElement("employee");
		// ʹ�� addAttribute()������employeeԪ�����id��name����
		empElem.addAttribute("id", "0001");
		empElem.addAttribute("name", "wanglp");
		// ��employeeԪ�������sexԪ��
		Element sexElem = empElem.addElement("sex");
		// ʹ��setText()��������sexԪ�ص��ı�
		sexElem.setText("m");
		// ��employeeԪ��������ageԪ�� �����ø�Ԫ�ص��ı���
		Element ageElem = empElem.addElement("age");
		ageElem.setText("25");
		// �ڸ�Ԫ����ʹ�� addElement()��������employeeԪ�ء�
		Element emp2Elem = root.addElement("employee");
		// ʹ�� addAttribute()������employeeԪ�����id��name����
		emp2Elem.addAttribute("id", "0002");
		emp2Elem.addAttribute("name", "fox");
		// ��employeeԪ�������sexԪ��
		Element sex2Elem = emp2Elem.addElement("sex");
		// ʹ��setText()��������sexԪ�ص��ı�
		sex2Elem.setText("f");
		// ��employeeԪ��������ageԪ�� �����ø�Ԫ�ص��ı���
		Element age2Elem = emp2Elem.addElement("age");
		age2Elem.setText("24");
		// ����ʹ�� addDocType()��������ĵ�����˵����
		// document.addDocType("employees", null, "file://E:/Dtds/dom4j.dtd");
		// �������� XML �ĵ��������ĵ�����˵����
		// <!DOCTYPE employees SYSTEM "file://E:/Dtds/dom4j.dtd">
		// ����ĵ�Ҫʹ���ĵ����Ͷ��壨DTD���ĵ���֤������� Doctype��
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
	 * ����xml
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
