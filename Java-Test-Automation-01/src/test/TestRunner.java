package test;

import pageObjects.safmarine.PO_lookUp;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import libraries.Browser;
import libraries.Util_Excel;
import java.util.HashMap;

public class TestRunner {

    HashMap<String, String> mapTestData;
    String strCurrentTestName;

    @BeforeClass
    public static void initFramework(){

    }

    @BeforeMethod
    public void startTest(){
		/*
		 * WebDriver driver = Browser.getBrowserDriver("chrome"); pageFactory = new
		 * SafMarine_PageFactory(driver);
		 * pageFactory.actLaunchWebApp("https://my.safmarine.com");
		 */ 
    	
    }

    @After
    public void finishTest(){
		/* pageFactory.actCloseWebApp(); */
        mapTestData.clear();
    }

    //@Test
    public void TC_001() throws Exception {

        System.out.println("********* Test Name = " + strCurrentTestName);
        mapTestData = Util_Excel.getMapTestData("TC_001");
		/*
		 * PO_lookUp pageLookUP = pageFactory.getPage_LookUp();
		 * pageLookUP.navigateToScheduleType(mapTestData);
		 * pageLookUP.updateP2P_Schedule(mapTestData);
		 * pageLookUP.readPopulated_ScheduleData();
		 */
    }

    @Test
    public void TC_005() throws Exception{

        System.out.println("********* Test Name = " + strCurrentTestName);
        mapTestData = Util_Excel.getMapTestData("TC_005");

		/*
		 * PO_lookUp pageLookUP = page.getPage_LookUp();
		 * pageLookUP.navigateToScheduleType(mapTestData);
		 * pageLookUP.updatePC_Schedule(mapTestData);
		 */    }

    //@Test
    public void TC_007() throws Exception{

        System.out.println("********* Test Name = " + strCurrentTestName);
        mapTestData = Util_Excel.getMapTestData("TC_007");
		/*
		 * PO_lookUp pageLookUP = pageFactory.getPage_LookUp();
		 * pageLookUP.navigateToScheduleType(mapTestData);
		 * pageLookUP.updateVS_Schedule(mapTestData);
		 */
     }
}
