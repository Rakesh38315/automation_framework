package demo.utils;

import org.openqa.selenium.WebDriver;


public class DriverManager {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<GestureUtils> gestureUtils = new ThreadLocal<GestureUtils>();
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(WebDriver driverObject) {
		driver.set(driverObject);
	}
	
	public static GestureUtils getGestureUtils() {
		return gestureUtils.get();
	}

	public static void setGestureUtils(GestureUtils gestureUtilsObject) {
		gestureUtils.set(gestureUtilsObject);
	}

}
