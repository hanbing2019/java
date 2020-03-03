package poi;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTempUtil
{

	public static void main(String[] args)
	{
		Workbook wb = new XSSFWorkbook();

		wb.createSheet("my sheet");

		try
		{
			OutputStream os = new FileOutputStream("D:/word/test1.xlsx");
			wb.write(os);
			wb.close();
			os.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
