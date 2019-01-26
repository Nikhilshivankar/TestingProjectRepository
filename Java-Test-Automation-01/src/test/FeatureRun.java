package test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		
		features 	= {"src/test/java/Cucumber/"}, // package path of feature file
		glue 		= {"stepDefinition"}, // package of step
		plugin 		= {"pretty",
						"html:testResults/cucumber-html-report",
				        "json:testResults/cucumber-report.json"
					  },// "com.cucumber.listener.ExtentCucumberFormatter:testResults/Cucumber-Reports/report.html"},
		monochrome 	= true

)


public class FeatureRun {

}