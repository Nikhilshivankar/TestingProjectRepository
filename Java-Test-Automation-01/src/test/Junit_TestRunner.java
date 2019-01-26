package test;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import libraries.ApplicationFactory;
import libraries.ApplicationFactory.Safmarine;
import libraries.Util_Excel;

public class Junit_TestRunner {

	HashMap<String,String> testData;
	
	@Before
	public void getPrerequisits() throws Exception {
	
		Util_Excel.openExcel_TestData();
		testData = Util_Excel.getMapTestData("TC_005");
	}
	
	public void test_001() throws Exception {

		ApplicationFactory apps = new ApplicationFactory();

		Safmarine safPages = apps.getNewInstance_Safmarine("https://my.safmarine.com");

		safPages.getHomePage().checkLoadCondition();
		safPages.getHomePage().checkExitCondition();
		safPages.getHomePage().navigateToScheduleType(testData);
		safPages.getPortCallPage().updatePC_Schedule(testData);
		safPages.getPortCallPage().readPopulated_Schedule();
		//safPages.getPortCallPage().validateVessel();
		
	}
	
	public void test_002() {
		
		ApplicationFactory apps = new ApplicationFactory();
		Safmarine safPages = apps.getNewInstance_Safmarine("https://my.safmarine.com");

		safPages.getHomePage().checkLoadCondition();
		safPages.getHomePage().checkExitCondition();
		safPages.getHomePage().navigateToScheduleType(testData);
		safPages.getPortCallPage().updatePC_Schedule(testData);
		safPages.getPortCallPage().downloadCSV();
		safPages.getPortCallPage().readPopulated_Schedule();
		safPages.getPortCallPage().verify_CSVResult_and_PageResult();
	}
	
	/*
	 * @Test(dataProvider= "portCall") public void test_DataProvider(String
	 * countryName, String portName) {
	 * 
	 * ApplicationFactory apps = new ApplicationFactory(); Safmarine safPages =
	 * apps.getNewInstance_Safmarine("https://my.safmarine.com");
	 * 
	 * safPages.getHomePage().checkLoadCondition();
	 * safPages.getHomePage().checkExitCondition();
	 * safPages.getHomePage().navigateToScheduleType(testData);
	 * safPages.getPortCallPage().updatePC_Schedule2(countryName, portName);
	 * 
	 * 
	 * }
	 * 
	 * @DataProvider(name = "portCall") public Object[][] vesselData(){ return new
	 * Object[][]{{"India","Chennai"},{"India","Mundra"},{"India","Visakhapatnam"},{
	 * "India","Kolkata"},{"India","Haldia"}};
	 * 
	 * }
	 */	
}