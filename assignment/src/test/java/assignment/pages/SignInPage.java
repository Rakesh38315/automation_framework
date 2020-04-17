package assignment.pages;

import java.time.Duration;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.Sets.SetView;

import assignment.utils.DriverFactory;
import assignment.utils.ElementUtils;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignInPage {
	
	@AndroidFindBy(id = "Open Drawer")
	public static MobileElement hamburgerMenu;
	
	@AndroidFindBy(id = "tv_right_cta")
	private MobileElement useEmailID;
	
	@AndroidFindBy(id = "phone_input")
	private MobileElement emailIDTextField;
	
	@AndroidFindBy(id = "button")
	private MobileElement continueButton;
	
	@AndroidFindBy(id = "phone_input")
	private MobileElement passwordField;
	
	@AndroidFindBy(id = "Back Button")
	private MobileElement backButton;
	
	public SignInPage() {
		PageFactory.initElements(new AppiumFieldDecorator(DriverFactory.driver, Duration.ofSeconds(10)), this);
	}
	
	public void signIn(String userName, String password) throws Exception {
		ElementUtils.safeClick(10, useEmailID);
		emailIDTextField.setValue(userName);
		continueButton.click();
		passwordField.setValue(password);
		continueButton.click();
	}
	
	
	
	
	
	
	
	
	
	

}
