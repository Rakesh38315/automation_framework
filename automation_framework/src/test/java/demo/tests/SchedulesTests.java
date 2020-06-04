package demo.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import demo.pages.SchedulesPage;
import demo.utils.AndroidUtils;
import demo.utils.ElementUtils;
import demo.utils.ElementUtils.LocatorStrategy;
import demo.utils.FileUtil;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class SchedulesTests {
	
	private SchedulesPage schedulesPage;
	private String filePath = "./src/test/java/demo/test_data/test_data.properties";
	
	@BeforeClass(groups = "schedule_tests")
	public void init() {
		schedulesPage = new SchedulesPage();
	}
	
	@Test(priority = 1, groups = "schedule_tests")
	public void fromPortNameTest() throws Exception {
		schedulesPage.searchSchedules(FileUtil.readFromPropertyFile(filePath, "fromCitySearch"), FileUtil.readFromPropertyFile(filePath, "fromCityPort"), 
				FileUtil.readFromPropertyFile(filePath, "toCitySearch"), FileUtil.readFromPropertyFile(filePath, "toCityPort"));
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, 
				FileUtil.readFromPropertyFile(filePath, "fromPortName")).isDisplayed());
	}
	
	@Test(priority = 2, groups = "schedule_tests")
	public void fromPortCountryTest() throws Exception {
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, 
				FileUtil.readFromPropertyFile(filePath, "fromPortCountry")).isDisplayed());
	}
	
	@Test(priority = 3, groups = "schedule_tests")
	public void toPortNameTest() throws Exception {
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, 
				FileUtil.readFromPropertyFile(filePath, "toPortName")).isDisplayed());
	}
	
	@Test(priority = 4, groups = "schedule_tests")
	public void toPortCountryTest() throws Exception {
		Assert.assertTrue(ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, 
				FileUtil.readFromPropertyFile(filePath, "toPortCountry")).isDisplayed());
	}
	
	@Test(priority = 5, groups = "schedule_tests")
	public void shareSchedulesTest() throws Exception {
		schedulesPage.shareSchedules("Gmail");
		AndroidUtils.getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));
		AndroidUtils.getAndroidDriver().pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}
	
	
	
	
	

}
