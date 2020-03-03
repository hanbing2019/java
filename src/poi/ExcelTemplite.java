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
 * @describe:读取excel模板，将向模板中写入数据，生成新的
 * 共分为六部完成根据模板导出excel操作：<br/>
 * 第一步、设置excel模板路径（setSrcPath）<br/>
 * 第二步、设置要生成excel文件路径（setDesPath）<br/>
 * 第三步、设置模板中哪个Sheet列（setSheetName）<br/>
 * 第四步、获取所读取excel模板的对象（getSheet）<br/>
 * 第五步、设置数据（分为6种类型数据：setCellStrValue、setCellDateValue、setCellDoubleValue、
 * setCellBoolValue、setCellCalendarValue、setCellRichTextStrValue）<br/>
 * 第六步、完成导出 （exportToNewFile）<br/>
 * 22. *
 * 
 * @author Administrator 24. * 25.
 */
public class ExcelTemplite
{
	private String srcXlsPath = "";// // excel模板路径
	private String desXlsPath = "";
	private String sheetName = "";
	POIFSFileSystem fs = null;
	Workbook wb = null;
	Sheet sheet = null;

	/**
	 * 第一步、设置excel模板路径
	 * 
	 * @param srcXlsPath
	 */
	public void setSrcPath(String srcXlsPath)
	{
		this.srcXlsPath = srcXlsPath;
	}

	/**
	 * * 第二步、设置要生成excel文件路径
	 * 
	 * @param desXlsPath
	 */
	public void setDesPath(String desXlsPath)
	{
		this.desXlsPath = desXlsPath;
	}

	/**
	 * 第三步、设置模板中哪个Sheet列
	 * 
	 * @param sheetName
	 */
	public void setSheetName(String sheetName)
	{
		this.sheetName = sheetName;
	}

	/**
	 * 第四步、获取所读取excel模板的对象
	 */
	public void getSheet()
	{
		try
		{
			File fi = new File(srcXlsPath);
			if (!fi.exists())
			{
				System.out.println("模板文件:" + srcXlsPath + "不存在!");
				return;
			}
			System.out.println(srcXlsPath);
			if (srcXlsPath.endsWith("xls"))
			{
				fs = new POIFSFileSystem(new FileInputStream(fi));
				System.out.println("2003");
				wb = new HSSFWorkbook(fs);// 读取excel文件
				sheet = wb.getSheet(sheetName);// 读取excel的sheet
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
	 * 第五步、设置字符串类型的数据
	 * 
	 * @param rowIndex
	 *            --行值
	 * @param cellnum
	 *            --列值
	 * @param value
	 *            --字符串类型的数据
	 */
	public void setCellStrValue(int rowIndex, int cellnum, String value)
	{
		System.out.println(rowIndex + "," + cellnum + "," + value);
		System.out.println(sheet);
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);// 设置值
		cell.setCellValue(value);
	}

	/**
	 * 第五步、设置日期/时间类型的数据
	 * 
	 * @param rowIndex
	 *            --行值
	 * @param cellnum
	 *            --列值
	 * @param value
	 *            --日期/时间类型的数据
	 */
	public void setCellDateValue(int rowIndex, int cellnum, Date value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步、设置浮点类型的数据
	 * 
	 * @param rowIndex
	 *            --行值
	 * @param cellnum
	 *            --列值
	 * @param value
	 *            --浮点类型的数据
	 */
	public void setCellDoubleValue(int rowIndex, int cellnum, double value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步、设置Bool类型的数据
	 * 
	 * @param rowIndex
	 *            --行值
	 * @param cellnum
	 *            --列值
	 * @param value
	 *            --Bool类型的数据
	 */
	public void setCellBoolValue(int rowIndex, int cellnum, boolean value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步、设置日历类型的数据
	 * 
	 * @param rowIndex
	 *            --行值
	 * @param cellnum
	 *            --列值
	 * @param value
	 *            --日历类型的数据
	 */
	public void setCellCalendarValue(int rowIndex, int cellnum, Calendar value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第五步、设置富文本字符串类型的数据。可以为同一个单元格内的字符串的不同部分设 置不同的字体、颜色、下划线
	 * 
	 * @param rowIndex
	 *            --行值
	 * @param cellnum
	 *            --列值
	 * @param value
	 *            --富文本字符串类型的数据
	 */
	public void setCellRichTextStrValue(int rowIndex, int cellnum,
			RichTextString value)
	{
		Cell cell = sheet.getRow(rowIndex).getCell(cellnum);
		cell.setCellValue(value);
	}

	/**
	 * 第六步、完成导出
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
		eu.setSheetName("Sheet1");// excel的sheet名称
		eu.getSheet();
		eu.setCellStrValue(6, 4, "dsdsd");
		eu.setDesPath("D:/word/out/Q01.xlsx");
		eu.exportToNewFile();
	}
}
