package pageObjects.safmarine;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libraries.Page;

public class PO_HomePage extends Page{

	public PO_HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@Override
	public void checkLoadCondition() {
		
		System.out.println("This is a load condition");
	}

	@Override
	public void checkExitCondition() {
		
		System.out.println("This is a exit condition");		
	}
	
	//  MENU ITEMS------****************
    
	@FindBy(xpath = "//a[@class='ss-nav-rev__menu__item__link' and contains (text(), 'Lookup')]")
    protected WebElement menu_lookUp;
    
	@FindBy(xpath = "//*[@class=\"font-links__separators\" and contains (text(), 'Find a Price')]")
    protected WebElement sub1_FindPrice;
    
	@FindBy(xpath = "//*[@class=\"font-links__separators\" and contains (text(), 'Tariff Inquiry')]")
    protected WebElement sub1_TariffInquiry;
    
	@FindBy(xpath = "//*[@class=\"font-links__separators\" and contains (text(), 'Schedules')]")
    protected WebElement sub1_Schedule;
    
	
	// SUBMENU ITEMS----------*******************
	@FindBy(xpath = "//a[@href='javascript:void(0)' and contains (text(), 'Point-to-Point')]")
    protected WebElement sub2_pointToPoint;
    @FindBy(xpath = "//a[@href='javascript:void(0)' and contains (text(), 'Port Call')]")
    protected WebElement sub2_portCall;
    @FindBy(xpath = "//a[@href='javascript:void(0)' and contains (text(), 'Vessel Schedule')]")
    protected WebElement sub2_vesselSchedule;
    
    public HashMap<String,String> navigateToScheduleType(HashMap<String,String> mapData) {

    	System.out.println("clicking on lookUp menu");
    	
    	waitForElementTobeClickable(menu_lookUp);
    	menu_lookUp.click();
        System.out.println("Navigate To Schedule");
        sub1_Schedule.click();

        if(sub2_pointToPoint.getText().contains(mapData.get("ScheduleType")) == true){
            sub2_pointToPoint.click();
        }else if(sub2_portCall.getText().contains(mapData.get("ScheduleType")) == true){
            sub2_portCall.click();
        }else {sub2_vesselSchedule.click();
        }
        System.out.println("selected scheduleType is :"+ mapData.get("ScheduleType"));
        return mapData;
        
    }
    
  
    
    
    
    
  
}