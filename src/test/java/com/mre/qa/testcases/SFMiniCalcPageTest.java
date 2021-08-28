package com.mre.qa.testcases;

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

//@Listeners(TestResultListener.class)
public class SFMiniCalcPageTest extends TestBase{
	
	SFMiniCalcPage sfMiniCalcPage;
	
//	public SFMiniCalcPageTest() {
//		super();
//	}
	
	
	
	
	@Test
	public void validateGetCovered() {
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
	public void validatePageTitle() {
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
