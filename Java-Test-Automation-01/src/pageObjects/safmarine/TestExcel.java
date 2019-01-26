package pageObjects.safmarine;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class TestExcel extends PO_LookUp_PortCall {

	public TestExcel(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	static PO_LookUp_PortCall portCall;
	public static void main(String args[]) throws IOException {
		
		
		portCall = new PO_LookUp_PortCall(driver);
	
		portCall.verify_CSVResult_and_PageResult();
	
	
	}

	
	
}
