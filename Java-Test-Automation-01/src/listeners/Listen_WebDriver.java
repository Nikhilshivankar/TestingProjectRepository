package listeners;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.WebDriverEventListener;
import helper.Helper_Log;
import java.io.File;
import java.io.IOException;

public class Listen_WebDriver extends AbstractWebDriverEventListener {
	
	
	/*
	 * public void beforeNavigateTo(String arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : BeforeNavigateTo : [" +
	 * arg1.getTitle() + "-->" + arg0 + "]"); }
	 * 
	 * public void afterNavigateTo(String arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : AfterNavigateTo : [" + arg1.getTitle()
	 * + "-->" + arg0 + "]"); }
	 * 
	 * public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : AfterChangeOfValue : [" +
	 * arg0.toString() + " --> " + arg0.getText() + "]"); }
	 * 
	 * public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : BeforeChangeOfValue : [" +
	 * arg0.toString() + " --> " + arg0.getText() + "]"); }
	 * 
	 * 
	 * public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	 * Helper_Log.add_info("Driver Listener : AfterFindBy : [" + arg0.toString() +
	 * "]"); }
	 * 
	 * public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
	 * Helper_Log.add_info("Driver Listener : BeforeFindBy : [" + arg0.toString() +
	 * "]"); }
	 * 
	 * public void beforeClickOn(WebElement arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : BeforeClickOn : [" + arg0.toString() +
	 * "]"); }
	 * 
	 * public void afterClickOn(WebElement arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : AfterClickOn : [" + arg0.toString() +
	 * "]"); }
	 * 
	 * public void beforeScript(String arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : BeforeScript : [" + arg0 + "]"); }
	 * 
	 * public void afterScript(String arg0, WebDriver arg1) {
	 * Helper_Log.add_info("Driver Listener : AfterScript : [" + arg0 + "]"); }
	 * 
	 */    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void onException(Throwable arg0, WebDriver driver) {
        Helper_Log.add_info("Driver Listener : OnException : [" + arg0.getMessage() + "]");

        TakesScreenshot screenshot = ((TakesScreenshot)driver);
        File file_screenshot = screenshot.getScreenshotAs(OutputType.FILE);
        File destin_file = new File("C://Temp/asdhasd.png");
        try {
            FileUtils.copyFile(file_screenshot,destin_file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Helper_Log.add_info("Driver Listener : BeforeChangeOfValue : [" + element.toString() + " --> " + keysToSend + "]");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        Helper_Log.add_info("Driver Listener : AfterChangeOfValue : [" + element.toString() + " --> " + keysToSend + "]");
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }


    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : BeforeAlertAccept : [" + driver.getTitle() + "]");
    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : AfterAlertAccept : [" + driver.getTitle() + "]");
    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : AfterAlertDismiss : [" + driver.getTitle() + "]");
    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : BeforeAlertDismiss : [" + driver.getTitle() + "]");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : BeforeNavigateRefresh : [" + driver.getTitle() + "]");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : AfterNavigateRefresh : [" + driver.getTitle() + "]");
    }

    public void beforeNavigateBack(WebDriver arg0) {
        Helper_Log.add_info("Driver Listener : BeforeNavigateBack : [" + arg0.getTitle() + "]");
    }

    public void beforeNavigateForward(WebDriver arg0) {
        Helper_Log.add_info("Driver Listener : BeforeNavigateForward : [" + arg0.getTitle() + "]");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : AfterNavigateBack : [" + driver.getTitle() + "]");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        Helper_Log.add_info("Driver Listener : AfterNavigateForward : [" + driver.getTitle() + "]");
    }
}
 