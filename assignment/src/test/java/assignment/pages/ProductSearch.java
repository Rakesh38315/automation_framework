package assignment.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import assignment.utils.DriverFactory;
import assignment.utils.ElementUtils;
import assignment.utils.ElementUtils.LocatorStrategy;
import assignment.utils.GestureUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductSearch {
	
	@AndroidFindBy(id = "search_widget_textbox")
	private MobileElement searchContainer;
	
	@AndroidFindBy(id = "search_autoCompleteTextView")
	private MobileElement searchTextField;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"in\")")
	private MobileElement searchSelection;
	
	@AndroidFindBy(id = "allow_button")
	private MobileElement locationAllowButton;
	
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement locationSystemAllowButton;
	
	private GestureUtils gestureUtils;
	
	public ProductSearch() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.driver, Duration.ofSeconds(10)), this);
		gestureUtils = new GestureUtils();
	}
	
	public void searchProduct(String productGroup, String productName) throws Exception {
		searchContainer.click();
		ElementUtils.sendKeys(10, searchTextField, productGroup);
		searchSelection.click();
		ElementUtils.wait(10);
		locationAllowButton.click();
		locationSystemAllowButton.click();
		gestureUtils.androidScroll(productName, -450);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, productName).click();
	}

}
