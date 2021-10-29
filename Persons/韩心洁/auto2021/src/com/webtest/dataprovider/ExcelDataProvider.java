package com.webtest.dataprovider;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*
 * Excel
 */

public class ExcelDataProvider {



	public String getTestDataByExcel(String fileName, String sheetName,int n,int m)
			throws IOException {
		File file = new File(fileName);
		FileInputStream inputstream = new FileInputStream(file);
		Workbook wbook = null;
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
//		System.out.println(fileExtensionName);
		if (fileExtensionName.equals(".xlsx")) {
			wbook = new XSSFWorkbook(inputstream);
		
		} else if (fileExtensionName.equals(".xls")) {
			wbook = new HSSFWorkbook(inputstream);
		}
//		获得工作表
		Sheet sheet = wbook.getSheet(sheetName);
//		获取行数
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
//		创建一个集合
		List<Object[]> records = new ArrayList<Object[]>();

		for (int i = 0; i < rowCount + 1; i++) {
//			获取行
			Row row = sheet.getRow(i);
//			单元格数
			String fields[] = new String[row.getLastCellNum()];
			for (int j = 0; j < row.getLastCellNum(); j++) {
//				获取单元格内容
				fields[j] = row.getCell(j).getStringCellValue();
			}
			records.add(fields);
			
		}
		
//		二维集合
		Object[][] results = new Object[records.size()][];
		for (int i = 0; i < records.size(); i++) {
			results[i] = records.get(i);
		}
		
		return (String) results[n][m];
		
	}
	
	
}
