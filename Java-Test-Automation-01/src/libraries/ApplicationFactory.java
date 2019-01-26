package libraries;

import org.openqa.selenium.WebDriver;
import pageObjects.safmarine.*;

public class ApplicationFactory {

	Safmarine safmarine;

	public Safmarine getNewInstance_Safmarine(String strURL) {
		
		System.out.println("Creating new instance of Safmarine class");
		return new Safmarine(strURL);
	}
	
	public class Application {

		Browser browser = new Browser();
		public WebDriver driver;
		
		public WebDriver launchWebApp(String strURL) {


			driver = browser.getBrowserDriver("chrome");
			
			System.out.println("Launched browser  = " + "chrome ; URL = " + strURL);
			
			driver.get(strURL);
		
			System.out.println("Opened url = " + strURL);
			
			return driver;
		}

		public void closeWebApp() {
			browser.quitBrowser();
		}
	}

	public class Safmarine extends Application {

		private WebDriver driver;
		
		public Safmarine(String strURL) {
			this.driver = launchWebApp(strURL);
		}

		private PO_HomePage po_homepage;
		private PO_LookUp_PortCall po_LookUp_PortCall;

		public PO_HomePage getHomePage() {
			return (po_homepage == null) ? po_homepage = new PO_HomePage(driver) : po_homepage;
		}

		public PO_LookUp_PortCall getPortCallPage() {
			return (po_LookUp_PortCall == null) ? po_LookUp_PortCall = new PO_LookUp_PortCall(driver) : po_LookUp_PortCall;
		}
	}

}
