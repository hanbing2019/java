package poi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 生成excel，
 * 
 * 获取excel中的数据
 * 
 * @author Administrator
 * 
 */
public class ExcelUtil
{
	private Workbook wb = null;

	private Sheet sheet = null;

	/**
	 * 生成excel
	 * 
	 * @param path
	 *            生成excel文档路径
	 */
	public void createExcel(String path)
	{
		File file = new File(path);
		// excel 2003
		if (path.endsWith("xls"))
		{
			wb = new HSSFWorkbook(); // --->创建了一个excel文件
		}
		// excel 2007
		else if (path.endsWith("xlsx"))
		{
			wb = new XSSFWorkbook();// --->创建了一个excel文件
		}

		sheet = wb.createSheet("sheet1");// 创建excel表单
		// wb.createSheet("shet");

		Row row[] = new Row[3];
		// Row row = sheet.createRow(1);// 创建行 创建的索引冲0开始
		// Cell cell = row.createCell(1);// 创建单元格，创建的索引从0开始
		// rowcell.setCellValue("ddd");// 向单元格中放值
		for (int i = 0; i < 3; i++)
		{
			// 创建3行
			row[i] = sheet.createRow(i);
		}
		for (int i = 0; i < row.length; i++)
		{
			// 每行创建10个单元格
			for (int j = 0; j < 10; j++)
			{
				Cell cell = row[i].createCell(j);
			}
		}
		// 合并单元格
		// CellRangeAddress(起始行号，终止行号， 起始列号，终止列号）.
		CellRangeAddress cra1 = new CellRangeAddress(0, 1, 0, 0);
		sheet.addMergedRegion(cra1);
		try
		{
			wb.write(new FileOutputStream(file));
			wb.close();
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
		ExcelUtil eu = new ExcelUtil();

		eu.createExcel("D:/word/test1.xlsx");
	}
}
