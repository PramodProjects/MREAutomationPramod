package com.mre.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mre.qa.base.TestBase;

public class SFPremiumQuotePage extends TestBase{
	public SFPremiumQuotePage() {
		PageFactory.initElements(driver, this);		
	}
	public static WebDriverWait wait;
	
	// WebElements
	//@FindBy(name = "$PpyWorkPage$pQuoteList$l1$pApplicationPage$pPolicyHolderDetails$pZipCode")
	@FindBy(xpath = "//input[@name='$PpyWorkPage$pQuoteList$l1$pApplicationPage$pPolicyHolderDetails$pZipCode']")
	WebElement postalCodeEditbox;
	
	// Methods
	@FindBy(xpath = "//button[@title]")
	WebElement continueBtn;
	
	// Methods
	public void clickContinueBtn() throws InterruptedException {
		
		Thread.sleep(30000);
		//driver.switchTo().frame("productQuoteResetFrame");
		
		//driver.switchTo().frame(driver.findElement(By.id("productQuoteResetFrame")));
		driver.switchTo().frame("productQuoteResetFrame");
        driver.switchTo().frame("PegaGadgetIfr");

		//wait = new WebDriverWait(driver,120); 
		//wait.until(ExpectedConditions.elementToBeClickable(postalCodeEditbox));
		
		
		postalCodeEditbox.click();
		postalCodeEditbox.clear();
		postalCodeEditbox.sendKeys("A1A A1A");
		continueBtn.click();
	}


}
