package demo.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import demo.utils.DriverFactory;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage {
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Schedules']")
	private WebElement schedulesButton;
	
	public LoginPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.driver, Duration.ofSeconds(10)), this);
	}
	
	public enum LoginPageObjects {
		SCHEDULES_BUTTON
	}
		
	public WebElement getObject(LoginPageObjects objectName)
	{
		switch(objectName)
		{
		case SCHEDULES_BUTTON:
			return schedulesButton;
		default:
			return null;
		}
	}
		
}
