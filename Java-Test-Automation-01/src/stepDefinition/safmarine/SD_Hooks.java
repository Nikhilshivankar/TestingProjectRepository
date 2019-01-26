package stepDefinition.safmarine;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import libraries.ApplicationFactory;
import libraries.Util_Excel;
import libraries.ApplicationFactory.Safmarine;

public class SD_Hooks {
	
	public static ApplicationFactory apps = new ApplicationFactory();
	public static Safmarine sfPages;
	
    public static HashMap<String,String> testData;
    
    String strCurrentTestName;
	
	/*
	 * @Before("@prerequisits") public void start(Scenario scenario) throws
	 * Exception {
	 * 
	 * String strTestID = scenario.getName().substring(0,6);
	 * System.out.println("Name of my test : " + scenario.getName() + "/" +
	 * strTestID);
	 * 
	 * Util_Excel.openExcel_WorkBook_Sheet(); testData =
	 * Util_Excel.getMapTestData(strTestID);
	 * 
	 * System.out.println("prerequisits executed"); }
	 */

    @Given("^User launches browser and open web application$") 
	public void user_launches_browser_and_open_web_application() throws Throwable {
    	
    	sfPages  = apps.getNewInstance_Safmarine("https://www.google.com");
    }
	
	@When("^User navigates to lookup menu for schedule and select schedule type$")
	public void user_navigates_to_lookup_menu_for_schedule_and_select_schedule_type() throws Throwable {

		sfPages.getHomePage().navigateToScheduleType(testData);
	}

	@When("^User enters input to get schedule$")
	public void user_enters_input_to_get_schedule() throws Throwable {

		sfPages.getPortCallPage().updatePC_Schedule(testData);

	}

	@Then("^User gets schedule$")
	public void user_gets_schedule() throws Throwable {

		System.out.println("User can see populated schedule");
	}
	
}
