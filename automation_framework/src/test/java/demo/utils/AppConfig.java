package demo.utils;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppConfig{
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ENGLISH']")
	public static MobileElement selectEnglishLanguage;
	
	@AndroidFindBy(id = "continue_button")
	private MobileElement selectLanguageContinueButton;
	
	@AndroidFindBy(id = "continue_button")
	private MobileElement acceptTermsAndConditionsButton;
	
	@AndroidFindBy(id = "none_of_the_above_button")
	private MobileElement noneOfTheAboveButton;
	
	@AndroidFindBy(id = "got_it_btn")
	private MobileElement gotItButton;
		
	public AppConfig() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.driver, Duration.ofSeconds(10)), this);
	}
	
	public void initAppConfig() throws Exception{
		selectEnglishLanguage.click();
		selectLanguageContinueButton.click();
		ElementUtils.safeClick(10, acceptTermsAndConditionsButton);
		noneOfTheAboveButton.click();
		ElementUtils.wait(3);
		DriverManager.getGestureUtils().swipeByCordinates(DriverManager.getGestureUtils().getScreenWidth() - DriverManager.getGestureUtils().screenOffset, 
				DriverManager.getGestureUtils().getScreenHeight() / 2, DriverManager.getGestureUtils().screenOffset, 
				DriverManager.getGestureUtils().getScreenHeight() / 2);
		gotItButton.click();
	}
	
	
	
	
	
	
	
	
	
	

}
