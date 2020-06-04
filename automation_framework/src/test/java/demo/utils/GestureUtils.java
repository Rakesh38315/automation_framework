package demo.utils;

import java.time.Duration;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class GestureUtils{
	
	private TouchAction touchAction;
	public int screenOffset = 100;
	
	public GestureUtils() {
		touchAction = new TouchAction((PerformsTouchActions) DriverFactory.driver);
	}
	
	public enum ScrollDirection {
		DOWN, UP, LEFT, RIGHT
	}
	
	public int getScreenWidth() {
		return DriverFactory.driver.manage().window().getSize().width;
	}
	
	public int getScreenHeight() {
		return DriverFactory.driver.manage().window().getSize().height;
	}
	
	public void swipeByCordinates(int swipeStartX, int swipeStartY, int swipeEndX, int swipeEndY) {
			touchAction.press(PointOption.point(swipeStartX, swipeStartY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(swipeEndX, swipeEndY)).release().perform();
	}
}
