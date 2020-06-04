package demo.utils;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class DriverFactory{
	public static WebDriver driver;
	private DesiredCapabilities capabilities;
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder appiumServiceBuilder;
	private AppConfig appConfig;
	private GestureUtils gestureUtils;

	@BeforeTest(alwaysRun = true, groups = {"schedule_tests"})
	@Parameters({"platformVersion", "deviceName", "appPackage", "appActivity"})
	public void init(String platformVersion, String deviceName, String appPackage, String appActivity) throws Exception {
		try {
			appiumServiceBuilder = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingAnyFreePort();
			service = AppiumDriverLocalService.buildService(appiumServiceBuilder);
			service.start();
			capabilities = new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			capabilities.setCapability("appPackage", appPackage );
			capabilities.setCapability("appActivity", appActivity);
			driver = new AndroidDriver<MobileElement>(service.getUrl(), capabilities);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			gestureUtils = new GestureUtils();
			DriverManager.setDriver(driver);
			DriverManager.setGestureUtils(gestureUtils);
			appConfig = new AppConfig();
			appConfig.initAppConfig();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest(groups = {"schedule_tests"})
	public void tearDown() {
		try {
			driver.quit();
			service.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
