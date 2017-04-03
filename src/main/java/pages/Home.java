package pages;

import java.io.IOException;

import locators.LoginLocators;
import locators.MailLoactors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;

import atu.testng.reports.ATUReports;

import com.gslab.services.ReadPropertiesFile;
import com.gslab.services.Services;

import constants.FileConstants;

public class Home {
	/**
	 * Home Page having methods related to home page functionalities.
	 * 
	 * @author Rahul Kumar
	 * 
	 */
	
	private WebDriver driver ;
	Services services = null;
	private ReadPropertiesFile propertiesFile;
	private String userName;
	private String password;
	private String to;
	private String body;
	/**
	 * Parameterize constructor for initializing web driver.
	 * 
	 * @param webDriver
	 */
	
	public Home(WebDriver driver) {
		this.driver = driver;
		this.services = new Services(this.driver);
		propertiesFile= new ReadPropertiesFile();
	}
	

	
	
	public void loginVerification(String user,String pass) throws InterruptedException{
		
		userName= propertiesFile.getValueFromPropertiesFile(FileConstants.CONFIG_PROPERTIES_FILE,"USER" );
		password= propertiesFile.getValueFromPropertiesFile(FileConstants.CONFIG_PROPERTIES_FILE,"PASSWORD" );
		
		ATUReports.add("Enter UName", user, true);
		services.assertElementAndType(LoginLocators.USER_NAME,user);
		
		ATUReports.add("click on next button", true);
		services.assertAndClickElement(LoginLocators.CLIK_NEXT);
		
		Thread.sleep(1000);
		ATUReports.add("enter the password",pass, true);
		services.assertElementAndType(LoginLocators.PASSWORD,pass);
		
		ATUReports.add("click on sign button", true);
		services.assertAndClickElement(LoginLocators.SIGN_IN);
		Thread.sleep(1000);
	
	}
	
	public void MailVerification() throws InterruptedException, IOException{
		
		to= propertiesFile.getValueFromPropertiesFile(FileConstants.CONFIG_PROPERTIES_FILE,"USER" );
		body= propertiesFile.getValueFromPropertiesFile(FileConstants.CONFIG_PROPERTIES_FILE,"BODY" );
		services.assertPressCtrlAndClick(MailLoactors.COMPOSE_MAIL);
		//services.assertAndClickElement(MailLoactors.COMPOSE_MAIL);
		services.switchToNewWindow();
		services.assertElementAndType(MailLoactors.TO_MAIL, to);
		services.assertElementAndType(MailLoactors.MESSAGE_BODY, body);
		services.assertAndClickElement(MailLoactors.CLICK_ATTCH);
		
		services.assertAndUploadFile(FileConstants.UPLOAD_FILE_PATH);
		services.assertAndClickElement(MailLoactors.SEND);
		Thread.sleep(2000);
		
	}
	
	

}
