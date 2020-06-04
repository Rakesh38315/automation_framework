package demo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import demo.pages.LoginPage.LoginPageObjects;
import demo.utils.DriverFactory;
import demo.utils.ElementUtils;
import demo.utils.ElementUtils.LocatorStrategy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SchedulesPage {
	
	@AndroidFindBy(id = "from_city_field")
	private WebElement fromCityTextField;
	
	@AndroidFindBy(id = "to_city_field")
	private WebElement toCityTextField;
	
	@AndroidFindBy(id = "search")
	private WebElement searchTextField;
	
	@AndroidFindBy(id = "point_to_point_search")
	private WebElement searchButton;
	
	@AndroidFindBy(id = "action_share")
	private WebElement shareButton;
	
	@AndroidFindBy(id = "icon")
	private List<WebElement> shareIcon;
	
	@AndroidFindBy(id = "checkBox")
	private List<WebElement> checkBoxList;
	
	private LoginPage loginPage;
	
	public SchedulesPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.driver, Duration.ofSeconds(10)), this);
		loginPage = new LoginPage();
	}
	
	public void searchSchedules(String fromCity, String fromPort, String toCity, String toPort) throws Exception {
		ElementUtils.safeClick(15, loginPage.getObject(LoginPageObjects.SCHEDULES_BUTTON));
		fromCityTextField.click();
		ElementUtils.sendKeys(ElementUtils.deaultTime, searchTextField, fromCity);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, fromPort).click();
		toCityTextField.click();
		ElementUtils.sendKeys(ElementUtils.deaultTime, searchTextField, toCity);
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, toPort).click();
		searchButton.click();
	}
	
	public void shareSchedules(String shareTo) throws Exception {
		ElementUtils.safeClick(15, shareButton);
		for(WebElement element: checkBoxList) {
			element.click();
		}
		shareIcon.get(1).click();
		ElementUtils.getElement(LocatorStrategy.ANDROID_LOCATOR_STRATEGY_TEXT, shareTo).click();
	}

}
