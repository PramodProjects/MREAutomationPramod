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
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.mre.qa.utils.XLUtils;

@Ignore
public class testclass {

	@Test(priority = 1)
	public void test1() {

		System.out.println("test1");
	}

	@Test(priority = 2)
	public void test2() {

		System.out.println("test2");

	}
	@Test(priority = 0)
	public void test3() {

		System.out.println("test3");

	}

	@Test()
	public void test4() {

		System.out.println("test4");

	}

	@Test(priority = -1)
	public void test5() {

		System.out.println("test5");

	}


}
