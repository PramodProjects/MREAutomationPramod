package com.mre.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mre.qa.base.TestBase;

public class SFMiniCalcPage extends TestBase {

	
	public SFMiniCalcPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	// Page Factory - OR
	@FindBy(xpath = "//div [@class = 'header__premium-calculator']//a[text() = 'Get covered']")
	WebElement getCoveredBtn;

	
	// Methods
	public String getPageTitle() {
		return driver.getTitle();
		
	}
	
	public SFPremiumQuotePage clickGetCovered() {
		
		getCoveredBtn.click();
		logger.info("Clicked on Get covered button");
		return new SFPremiumQuotePage();
	}

}
