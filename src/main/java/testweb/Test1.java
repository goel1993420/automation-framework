package testweb;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import locators.DragAndDropLocators;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import pages.Home;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.gslab.services.Init;
import com.gslab.services.ReadExcelFiles;
import com.gslab.services.ReadPropertiesFile;
import com.gslab.services.RetryAnalyzer;
import com.gslab.services.Services;


//@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	//MethodListener.class })
public class Test1 extends Init {
	
	Home home;
	
	
	@Test(dataProvider="Authentication",retryAnalyzer=RetryAnalyzer.class)
	public void loginVerification(String user,String pass) throws InterruptedException, IOException{
		//getWebDriver().get("http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml");
		//Services se = new Services(getWebDriver());
		//se.assertDragAndDrop(DragAndDropLocators.FROM, DragAndDropLocators.TO);
		//Thread.sleep(200000);
	
		home = new Home(getWebDriver());
		home.loginVerification(user,pass);
		
		//home.MailVerification();
		
	}
	
	
	
	@DataProvider(name = "Authentication")
	 
	  public static Object[][] credentials() throws Exception {
	 
	   Object[][] test = ReadExcelFiles.getTableArray("Sheet1");
	  
	        return test;
	 
	  }
	
	

}

