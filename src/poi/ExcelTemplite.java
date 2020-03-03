package poi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @describe:��ȡexcelģ�壬����ģ����д�����ݣ������µ�
 * ����Ϊ������ɸ���ģ�嵼��excel������<br/>
 * ��һ��������excelģ��·����setSrcPath��<br/>
 * �ڶ���������Ҫ����excel�ļ�·����setDesPath��<br/>
 * ������������ģ�����ĸ�Sheet�У�setSheetName��<br/>
 * ���Ĳ�����ȡ����ȡexcelģ��Ķ���getSheet��<br/>
 * ���岽���������ݣ���Ϊ6���������ݣ�setCellStrValue��setCellDateValue��setCellDoubleValue��
 * setCellBoolValue��setCellCalendarValue��setCellRichTextStrValue��<br/>
 * ����������ɵ��� ��exportToNewFile��<br/>
 * 22. *
 * 
 * @author Administrator 24. * 25.
 */
public class ExcelTemplite
{
	private String srcXlsPath = "";// // excelģ��·��
	private String desXlsPath = "";
	private String sheetName = "";
	POIFSFileSystem fs = null;
	Workbook wb = null;
	Sheet sheet = null;

	/**
	 * ��һ��������excelģ��·��
	 * 
	 * @param srcXlsPath
	 */
	public void setSrcPath(String srcXlsPath)
	{
		this.srcXlsPath = srcXlsPath;
	}

	/**
	 * * �ڶ���������Ҫ����excel�ļ�·��
	 * 
	 * @param desXlsPath
	 */
	public void setDesPath(String desXlsPath)
	{
		this.desXlsPath = desXlsPath;
	}

	/**
	 * ������������ģ�����ĸ�Sheet��
	 * 
	 * @param sheetName
	 */
	public void setSheetName(String sheetName)
	{
		this.sheetName = sheetName;
	}

	/**
	 * ���Ĳ�����ȡ����ȡexcelģ��Ķ���
	 */
	public void getSheet()
	{
		try
		{
			File fi = new File(srcXlsPath);
			if (!fi.exists())
			{
				System.out.println("ģ���ļ�:" + srcXlsPath + "������!");
				return;
			}
			System.out.println(srcXlsPath);
			if (srcXlsPath.endsWith("xls"))
			{
				fs = new POIFSFileSystem(new FileInputStream(fi));
				System.out.println("2003");
				wb = new HSSFWorkbook(fs);// ��ȡexcel�ļ�
				sheet = wb.getSheet(sheetName);// ��ȡexcel��sheet
			} else if (srcXlsPath.endsWith("xlsx"))
			{
				System.out.println("2007");
				wb = new XSSFWorkbook(new FileInputStream(fi));
				sheet = wb.getSheet(sheetName);
				System.out.println(sheet);
			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * ���岽�������ַ������͵�����
	 * 
	 * @param rowIndex
	 *            --��ֵ
	 * @param cellnum
	 *            --��ֵ
	 * @param value
	 *            --�ַ������͵�����
	 */
	public void setCellStrValue(int rowIndex, int cellnum, String value)
	{
		System.out.println(rowIndex + "," + cellnum + "," + value);
		System.out.println(sheet);
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);// ����ֵ
		cell.setCellValue(value);
	}

	/**
	 * ���岽����������/ʱ�����͵�����
	 * 
	 * @param rowIndex
	 *            --��ֵ
	 * @param cellnum
	 *            --��ֵ
	 * @param value
	 *            --����/ʱ�����͵�����
	 */
	public void setCellDateValue(int rowIndex, int cellnum, Date value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽�����ø������͵�����
	 * 
	 * @param rowIndex
	 *            --��ֵ
	 * @param cellnum
	 *            --��ֵ
	 * @param value
	 *            --�������͵�����
	 */
	public void setCellDoubleValue(int rowIndex, int cellnum, double value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽������Bool���͵�����
	 * 
	 * @param rowIndex
	 *            --��ֵ
	 * @param cellnum
	 *            --��ֵ
	 * @param value
	 *            --Bool���͵�����
	 */
	public void setCellBoolValue(int rowIndex, int cellnum, boolean value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽�������������͵�����
	 * 
	 * @param rowIndex
	 *            --��ֵ
	 * @param cellnum
	 *            --��ֵ
	 * @param value
	 *            --�������͵�����
	 */
	public void setCellCalendarValue(int rowIndex, int cellnum, Calendar value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ���岽�����ø��ı��ַ������͵����ݡ�����Ϊͬһ����Ԫ���ڵ��ַ����Ĳ�ͬ������ �ò�ͬ�����塢��ɫ���»���
	 * 
	 * @param rowIndex
	 *            --��ֵ
	 * @param cellnum
	 *            --��ֵ
	 * @param value
	 *            --���ı��ַ������͵�����
	 */
	public void setCellRichTextStrValue(int rowIndex, int cellnum,
			RichTextString value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * ����������ɵ���
	 */
	public void exportToNewFile()
	{
		FileOutputStream out;
		try
		{
			out = new FileOutputStream(desXlsPath);
			wb.write(out);
			out.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		ExcelTemplite eu = new ExcelTemplite();
		eu.setSrcPath("D:/word/test.xlsx");
		eu.setSheetName("Sheet1");// excel��sheet����
		eu.getSheet();
		eu.setCellStrValue(6, 4, "dsdsd");
		eu.setDesPath("D:/word/out/Q01.xlsx");
		eu.exportToNewFile();
	}
}
