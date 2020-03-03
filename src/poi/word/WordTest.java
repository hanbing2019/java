package poi.word;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class WordTest
{
	public static void main(String args[]) throws IOException
	{
		String path = "e:\\poi\\";
		String fileName = "poi.docx";
		// createWord(path, fileName);
		readWord(path + fileName);
	}

	/**
	 * ����docx
	 * 
	 * @param path
	 * @param fileName
	 */
	public static void createWord(String path, String fileName)
	{
		// �ж�Ŀ¼�Ƿ����
		File file = new File(path);
		// exists()���Դ˳���·������ʾ���ļ���Ŀ¼�Ƿ���ڡ�
		// mkdir()�����˳���·����ָ����Ŀ¼��
		// mkdirs()�����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
		if (!file.exists())
			file.mkdirs();
		// ��ΪHWPFDocument��û���ṩ�����Ĺ��췽�� ����û�а취����word
		// ����ʹ��word2007�����ϵ�XWPFDocument�����й���word
		XWPFDocument document = new XWPFDocument();
		OutputStream stream = null;
		try
		{
			stream = new FileOutputStream(new File(file, fileName));
			XWPFParagraph p = document.createParagraph();
			XWPFRun r = p.createRun();// ���������ı�
			r.setText("POI������Word�����ı�");
			r.setBold(true);// ����Ϊ����
			r.setColor("FF0000");// ������ɫ
			XWPFRun r1 = p.createRun();// ���������ı�
			r1.setText("POI��d����Word�����ı�");
			r1.setBold(true);// ����Ϊ����
			r1.setColor("FF0000");// ������ɫ

			XWPFTable table = document.createTable(3, 3);// ����һ�����
			table.getRow(0).getCell(0).setText("���1");
			table.getRow(1).getCell(1).setText("���2");
			table.getRow(2).getCell(2).setText("���3");
			document.write(stream);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (stream != null)
				;
			try
			{
				stream.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void readWord(String filename) throws IOException
	{
		FileInputStream file = new FileInputStream(new File(filename));

		XWPFDocument doc = new XWPFDocument(file);
		// createParagraph
		List<XWPFParagraph> list = doc.getParagraphs();
		for (XWPFParagraph xwpfParagraph : list)
		{
			String wordInfo = xwpfParagraph.getText();
			System.out.println(wordInfo);
		}
		List<XWPFTable> tables = doc.getTables();
		for (XWPFTable table : tables)
		{
			for (XWPFTableRow row : table.getRows())
			{
				for (XWPFTableCell cell : row.getTableCells())
				{
					System.out.println(cell.getText());
				}
			}
		}

	}
}
