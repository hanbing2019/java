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
 * ����excel��
 * 
 * ��ȡexcel�е�����
 * 
 * @author Administrator
 * 
 */
public class ExcelUtil
{
	private Workbook wb = null;

	private Sheet sheet = null;

	/**
	 * ����excel
	 * 
	 * @param path
	 *            ����excel�ĵ�·��
	 */
	public void createExcel(String path)
	{
		File file = new File(path);
		// excel 2003
		if (path.endsWith("xls"))
		{
			wb = new HSSFWorkbook(); // --->������һ��excel�ļ�
		}
		// excel 2007
		else if (path.endsWith("xlsx"))
		{
			wb = new XSSFWorkbook();// --->������һ��excel�ļ�
		}

		sheet = wb.createSheet("sheet1");// ����excel��
		// wb.createSheet("shet");

		Row row[] = new Row[3];
		// Row row = sheet.createRow(1);// ������ ������������0��ʼ
		// Cell cell = row.createCell(1);// ������Ԫ�񣬴�����������0��ʼ
		// rowcell.setCellValue("ddd");// ��Ԫ���з�ֵ
		for (int i = 0; i < 3; i++)
		{
			// ����3��
			row[i] = sheet.createRow(i);
		}
		for (int i = 0; i < row.length; i++)
		{
			// ÿ�д���10����Ԫ��
			for (int j = 0; j < 10; j++)
			{
				Cell cell = row[i].createCell(j);
			}
		}
		// �ϲ���Ԫ��
		// CellRangeAddress(��ʼ�кţ���ֹ�кţ� ��ʼ�кţ���ֹ�кţ�.
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
