package demo.utils;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class AndroidUtils {
	
	public static AndroidDriver<WebElement> getAndroidDriver() {
		return (AndroidDriver<WebElement>) DriverManager.getDriver();
	}

}
