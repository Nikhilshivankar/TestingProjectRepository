package libraries;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import listeners.Listen_WebDriver;

public class Browser {

	public WebDriver driver;
	public EventFiringWebDriver eventDriver;
	public PropertyReader propReader;
	
	public WebDriver getBrowserDriver(String str_BrowserName) {

		if (str_BrowserName.toLowerCase().contains(propReader.getBrowserType())) {
			System.setProperty("webdriver.ie.driver", "src\\resources\\browsers\\IEDriverServer.exe");
			DesiredCapabilities capabilities_ie = DesiredCapabilities.internetExplorer();
			capabilities_ie.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			capabilities_ie.setCapability("requireWindowFocus", true);

			driver = new InternetExplorerDriver(capabilities_ie);
			
		} else if (str_BrowserName.toLowerCase().contains(propReader.getBrowserType())) {
			System.setProperty("webdriver.chrome.driver", "src\\resources\\browsers\\chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			HashMap<String, Object> chromePref = new HashMap<>();
			chromePref.put("download.default_directory", "src\\resources\\Download");
			options.setExperimentalOption("prefs", chromePref);

			driver = new ChromeDriver(options);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			System.out.println("Browsers: Opened Chrome Browser ");

		} else if (str_BrowserName.toLowerCase().contains(propReader.getBrowserType())) {
			System.setProperty("webdriver.gecko.driver", "src\\resources\\browsers\\geckodriver.exe");
			System.setProperty("webdriver.firefox.marionette", "src\\resources\\browsers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else {
			System.out.println("No valid browser name provided. Quitting Run");
			System.exit(0);
		}

		System.out.println("Browsers: Returning opened instanced browser ");

		driver.manage().window().maximize();

		eventDriver = new EventFiringWebDriver(driver);
		Listen_WebDriver eventHandler = new Listen_WebDriver();
		eventDriver.register(eventHandler);
		driver = eventDriver;

		return driver;

	}

	public WebDriver getDriver() {

		return this.driver;
	}

	public void closeActiveDriverSession() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}

}
