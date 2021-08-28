package com.mre.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mre.qa.base.TestBase;
import com.mre.qa.pages.SFMiniCalcPage;
import com.mre.qa.pages.SFPremiumQuotePage;

public class SFPremiumQuotePageTest extends TestBase{
	SFMiniCalcPage sfMiniCalcPage;
	SFPremiumQuotePage sfPremiumQuotePage;
	
	public SFPremiumQuotePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		//initialization();
		sfMiniCalcPage = new SFMiniCalcPage();
		
	}
	
	@Test
	public void validateClickContinueBtn() throws InterruptedException {
		Thread.sleep(30000);
		sfPremiumQuotePage = sfMiniCalcPage.clickGetCovered();
		Thread.sleep(30000);
		sfPremiumQuotePage.clickContinueBtn();
		
		
				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
