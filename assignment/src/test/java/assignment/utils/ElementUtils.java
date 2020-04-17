package assignment.utils;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;


public class ElementUtils {
	
	public static void wait(int seconds)
	{
		try 
		{
			Thread.sleep(1000 * seconds);
		}
		catch(Exception e){ }
	}
	
	public static void safeClick(int timeoutInSeconds, WebElement element) throws Exception {
        for (int i = 0; i < timeoutInSeconds; i++) {
            try {
                if(element.isDisplayed()) {
                	 element.click();
                 return;
                }
            } catch (Exception e) {
                wait(1);
            }
        }
        throw new Exception("ElementUtils.click() failed" +element);
    }
	
	public static void sendKeys(int timeoutInSeconds, MobileElement element, String value) throws Exception {
        for (int i = 0; i < timeoutInSeconds; i++) {
            try {
                if(element.isDisplayed()) {
                	 element.setValue(value);;
                 return;
                }
            } catch (Exception e) {
                wait(1);
            }
        }
        throw new Exception("ElementUtils.click() failed" +element);
    }
	
	public enum LocatorStrategy {
		ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS, ANDROID_LOCATOR_STRATEGY_TEXT, ANDROID_LOCATOR_STRATEGY_ID
	}
	
	 public static MobileElement getElement(LocatorStrategy androidLocatorStrategy, String androidAttributeValue) {
	        MobileElement returnElement = null;
	        DriverFactory.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        try {
	                switch (androidLocatorStrategy) {
	                    case ANDROID_LOCATOR_STRATEGY_TEXT_CONTAINS:
	                        returnElement = DriverFactory.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + androidAttributeValue + "\")"));
	                        break;
	                    case ANDROID_LOCATOR_STRATEGY_TEXT:
	                        returnElement = DriverFactory.driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().text(\"" + androidAttributeValue + "\")"));
	                        break;
	                    case ANDROID_LOCATOR_STRATEGY_ID:
	                        returnElement = DriverFactory.driver.findElement(MobileBy.id(androidAttributeValue));
	                        break;
	                    default:
	                }
	            }
	        catch(NoSuchElementException e) {
	        	e.printStackTrace();
	        }
	        return returnElement;
	 }

}
