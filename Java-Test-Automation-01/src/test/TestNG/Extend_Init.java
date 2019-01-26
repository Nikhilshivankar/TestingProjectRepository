package test.TestNG;

import java.io.File;

import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extend_Init {
	
	ExtentReports extReport;
	ExtentTest logger;
	
	@BeforeSuite
	public void startTest() {
					
		extReport = new ExtentReports("test-output\\extentReports\\EXTENTreport.html", true);
		extReport.loadConfig(new File("Java-Test-Automation-01\\extent_Config.xml"));
	}

	@AfterSuite
	public void endReport() {
		extReport.flush();
		extReport.close();
	}

	@BeforeMethod
	public void setUp(ITestResult result) {
		
		System.out.println("My test name = " + result.getMethod().getMethodName()); //+ test.getTestName());
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, "TestCase failed is" + result.getName());
		}else if(result.getStatus() == ITestResult.SKIP) { 
			logger.log(LogStatus.SKIP, "TestCase skipped is" + result.getName());
		}
		extReport.endTest(logger);
	}
	
}
