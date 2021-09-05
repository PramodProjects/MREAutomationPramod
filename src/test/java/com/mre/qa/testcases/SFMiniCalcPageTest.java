package com.mre.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.mre.qa.base.TestBase;
import com.mre.qa.pages.SFMiniCalcPage;
//import com.mre.qa.utils.TestResultListener;
import com.mre.qa.utils.ReadConfig;
import com.mre.qa.utils.StaticValues;
import com.mre.qa.utils.TestUtils;
import com.mre.qa.utils.XLUtils;


//@Listeners(TestResultListener.class)
public class SFMiniCalcPageTest extends TestBase{
	ReadConfig readConfig = new ReadConfig();
	SFMiniCalcPage sfMiniCalcPage;
	
//	public SFMiniCalcPageTest() {
//		super();
//	}
	
	

	
	@Test	
	public void validateGetCovered() throws InterruptedException, IOException {
		
		driver.get(XLUtils.getCellData("./src/main/java/com/mre/qa/testdata/USTestdataSF.xlsx", "Sheet1", 2, XLUtils.COLNAME_SF_LINK));
		logger.info("URL Opened");
		
		//String temp = XLUtils.getCellData("./src/main/java/com/mre/qa/testdata/USTestdataSF.xlsx", "Sheet1", 2, XLUtils.COLNAME_DOB);
		//System.out.println(temp);
		
		
		Thread.sleep(20000);
		
		sfMiniCalcPage = new SFMiniCalcPage();
		sfMiniCalcPage.clickGetCovered();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert.assertEquals(true, false);
	}
	
	
	@Test
	public void validatePageTitle() throws InterruptedException, IOException {
		driver.get(XLUtils.getCellData("./src/main/java/com/mre/qa/testdata/USTestdataSF.xlsx", "Sheet1", 1, 1));
		logger.info("URL Opened");
		Thread.sleep(20000);
		
		sfMiniCalcPage = new SFMiniCalcPage();
		String title = sfMiniCalcPage.getPageTitle();
		logger.info("Captured page title");
		Assert.assertEquals(title, "Parachute Insurance - Home1");
	}
	
//	@Test
//	public void test1() {
//		
//		Assert.assertEquals(true, false);
//	}
//
//	@Test
//	public void test2() {
//		
//		Assert.assertEquals(true, false);
//	}
//	

}
