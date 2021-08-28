package com.mre.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.mre.qa.base.TestBase;

public class TestUtils extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	
	public static void takeScreenshotAtEndOfTest(String methodName)  {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + methodName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getCurrentDatetime() {
		return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	}


	
	

}
