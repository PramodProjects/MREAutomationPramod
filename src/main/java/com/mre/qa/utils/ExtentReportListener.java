package com.mre.qa.utils;

//Listener class used to generate Extent reports

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		String repName = "ExtentReport-" + timeStamp + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);// specify
																											// location
																											// of the
																											// report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "pramod");

		htmlReporter.config().setDocumentTitle("MRE Test Project"); // Tile of report
		htmlReporter.config().setReportName("MRE Test Automation Report"); // name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed
																							// information to the report
																							// with GREEN color
																							// highlighted
	}

	public void onTestFailure(ITestResult tr) {
		TestUtils.takeScreenshotAtEndOfTest(tr.getMethod().getMethodName());
		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information
																							// to the report with GREEN
																							// color highlighted

		String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + tr.getName() + ".jpg";

		File f = new File(screenshotPath);

		if (f.exists()) {
			try {
				// logger.fail("Error" + logger.error(tr.getThrowable()));
				logger.fail(tr.getThrowable());
				logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
				// logger.log(Status.FAIL, tr.getThrowable());
				// logger.log(Status.FAIL, (Markup)
				// logger.addScreenCaptureFromPath(screenshotPath));

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void onTestSkipped(ITestResult tr) {
		TestUtils.takeScreenshotAtEndOfTest(tr.getMethod().getMethodName());
		
		String screenshotPath = System.getProperty("user.dir") + "\\screenshots\\" + tr.getName() + ".jpg";

		File f = new File(screenshotPath);
		
		logger = extent.createTest(tr.getName()); // create new entry in th report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		logger.skip(tr.getThrowable());
		// logger.log(Status.SKIP,logger.addScreenCaptureFromPath(screenshotPath));
		try {
			logger.addScreenCaptureFromPath(screenshotPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
}
