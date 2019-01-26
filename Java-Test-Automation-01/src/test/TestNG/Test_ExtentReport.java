package test.TestNG;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class Test_ExtentReport extends Extend_Init {

	
	@Test
	public void test_001() {	
		logger = extReport.startTest("test_001");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "TestCase pass is passed_Test");
	}
	
	@Test
	public void test_002() {
		logger = extReport.startTest("test_002");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "TestCase pass is failed_Test");
	}
	
	@Test
	public void test_003() {
		logger = extReport.startTest("test_003");
		throw new SkipException("SKIPPING ----- This testcase is not ready");
	}

	
}
