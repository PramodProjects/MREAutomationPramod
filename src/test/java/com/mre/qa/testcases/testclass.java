package com.mre.qa.testcases;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.mre.qa.utils.XLUtils;

public class testclass {

	@Test
	public void test() throws Exception  {
		
		
		
		
		
		// XLUtils.setCellData("./src/main/java/com/mre/qa/testdata/USTestdataMP.xlsx", "Sheet1", XLUtils.ROWNAME_TCNAME3, XLUtils.COLNAME_DOB,"testing" );
//		
//		String temp = XLUtils.getCellData("./src/main/java/com/mre/qa/testdata/USTestdataSF.xlsx", "Sheet1", 2, XLUtils.COLNAME_SF_LINK);
//		System.out.println(temp);
//		
		
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();		
//		driver.get(" https://google.com");
//		
		
		
		
//		FileInputStream fis = new FileInputStream("./src/main/java/com/mre/qa/testdata/USTestdataSF.xlsx");
//		XSSFWorkbook workbook = new XSSFWorkbook(fis);
//		XSSFSheet worksheet = workbook.getSheetAt(0);
//		int rowNum = worksheet.getLastRowNum();
//		System.out.println(rowNum);
//		
//		XSSFRow row = worksheet.getRow(1);
//		int cellNUm =row.getLastCellNum();
//		System.out.println(cellNUm);
//		
//		XSSFCell cell = row.getCell(9);
//		System.out.println(cell);
//		
//		
//		workbook.close();
//		fis.close();
//		
		
		
		
		
		
		

	}

}
