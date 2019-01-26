package test;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import libraries.Util_Excel;
import pageObjects.safmarine.PO_lookUp;

public class TestClass {


	@Test
	public void compareResults() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "src\\resources\\Browsers\\chromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http:\\my.safmarine.com");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Util_Excel.openExcel_WorkBook_Sheet();
        
		HashMap<String, String> testData = Util_Excel.getMapTestData("TC_005");
		
		driver.findElement(By.xpath("//*[@id='ss-nav-title-0' and contains (text(), 'Lookup')]")).click();
		
		driver.findElement(By.xpath("//*[@class=\\\"font-links__separators\\\" and contains (text(), 'Schedules')]")).click();

		driver.findElement(By.xpath("//a[@href='javascript:void(0)' and contains (text(), 'Port Call')]")).click();
		
		WebElement country = driver.findElement(By.xpath("//input[@id='country']"));
		WebElement port = driver.findElement(By.xpath("//input[@id='port']"));
		WebElement date = driver.findElement(By.xpath("//input[@id='country']"));
		
		set_dropdown(country, "India");
		set_dropdown(country, "Mundra");

		driver.findElement(By.xpath("//*[@id='psuedo-date-input-undefined']")).sendKeys("12/1/2019");
		
		driver.findElement(By.xpath("//button[@id='searchPortCalls']")).click();
		
		
		}
	
	public void set_dropdown(WebElement element, String strValue) {

		Select select = new Select(element);
		select.selectByValue(strValue);
    }
}
