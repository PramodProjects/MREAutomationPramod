package com.mre.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.mre.qa.utils.XLUtils;

public class testclass {

	@Test
	public void test() throws Exception  {
		
		
		int temp = XLUtils.getCellCount("./src/main/java/com/mre/qa/testdata/USTestdataSF.xlsx", "Sheet1", 0);
		System.out.println(temp);
		
		
//		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();		
//		driver.get(" https://google.com");
//		

	}

}
