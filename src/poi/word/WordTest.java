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
	 * 创建docx
	 * 
	 * @param path
	 * @param fileName
	 */
	public static void createWord(String path, String fileName)
	{
		// 判断目录是否存在
		File file = new File(path);
		// exists()测试此抽象路径名表示的文件或目录是否存在。
		// mkdir()创建此抽象路径名指定的目录。
		// mkdirs()创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
		if (!file.exists())
			file.mkdirs();
		// 因为HWPFDocument并没有提供公共的构造方法 所以没有办法构造word
		// 这里使用word2007及以上的XWPFDocument来进行构造word
		XWPFDocument document = new XWPFDocument();
		OutputStream stream = null;
		try
		{
			stream = new FileOutputStream(new File(file, fileName));
			XWPFParagraph p = document.createParagraph();
			XWPFRun r = p.createRun();// 创建段落文本
			r.setText("POI创建的Word段落文本");
			r.setBold(true);// 设置为粗体
			r.setColor("FF0000");// 设置颜色
			XWPFRun r1 = p.createRun();// 创建段落文本
			r1.setText("POI创d建的Word段落文本");
			r1.setBold(true);// 设置为粗体
			r1.setColor("FF0000");// 设置颜色

			XWPFTable table = document.createTable(3, 3);// 创建一个表格
			table.getRow(0).getCell(0).setText("表格1");
			table.getRow(1).getCell(1).setText("表格2");
			table.getRow(2).getCell(2).setText("表格3");
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
