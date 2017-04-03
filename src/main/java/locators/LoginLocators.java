package locators;

import org.openqa.selenium.By;

public class LoginLocators {

	public static final By USER_NAME= By.id("Email");
	
	public static final By PASSWORD= By.xpath("//input[@type='password']");
	
	public static final By SIGN_IN= By.xpath("//input[@name='signIn' and @id='signIn']");
	public static final By CLIK_NEXT= By.name("signIn");
	
}
