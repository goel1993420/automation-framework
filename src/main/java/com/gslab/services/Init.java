package com.gslab.services;

import static constants.Constants.*;

import java.io.File;
import java.io.IOException;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



import org.testng.annotations.BeforeSuite;

import atu.testng.reports.ATUReports;
import constants.FileConstants;



/**
 * This class is for initializing webdriver
 * 
 * 
 * 
 */

public class Init {
	
	{
		System.setProperty("atu.reporter.config",FileConstants.ATU_PROPERTY_FILE_PATH);
	}

	private  WebDriver driver;
	private String baseUrl;
	private String browser = null;
	private static int count=0;
	
	/**
	 * 
	 * This Method is used to initialize driver and get base url
	 * 
	 * @throws Exception
	 */
	@BeforeMethod
	public void setUp() throws Exception{
		
		
		ReadPropertiesFile propertiesFile = new ReadPropertiesFile();
		
		baseUrl = propertiesFile.getValueFromPropertiesFile(FileConstants.CONFIG_PROPERTIES_FILE, "SITE_URL");
		
		browser= propertiesFile.getValueFromPropertiesFile(
				FileConstants.CONFIG_PROPERTIES_FILE, "BROWSER");
		//if(driver==null)
		 setDriver(browser);
		
		driver.manage().window().maximize();
		
		ATUReports.setWebDriver(driver);
		
		driver.get(baseUrl);
		
		ATUReports.indexPageDescription = "My Project Description";
		
	}
	
	
	/**
	 * 
	 * This Method is used to set driver
	 * 
	 * 
	 * 
	 */
	public void setDriver(String browserName){
	      
		   if(browserName==null){
			   browserName="firefox";
			   
		   }
		   if(browserName.equalsIgnoreCase("firefox")){
			   
			   System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
			   
			     driver= new FirefoxDriver();
			    
		   }
		   
		   if(browserName.equalsIgnoreCase("chrome")){
			   
			   System.setProperty("webdriver.chrome.driver",CHROME_DRIVER_PATH);
			   
			     driver= new ChromeDriver();
		   }
		   
		   
		   
		   if(browserName.equalsIgnoreCase("ie")){
			   
			   System.setProperty("webdriver.ie.driver",IE_DRIVER_PATH);
			   
			     driver= new InternetExplorerDriver();
			    
		   }
	
			
		
		
	}
	   
	/**
	 * 
	 * This Method is used for closing browser
	 * @throws ATUTestRecorderExcept
	 * ion 
	 * 
	 * 
	 * 
	 */
	  
	  @AfterMethod
		public void tearDown(){
			
		   
			driver.close();
			driver.quit();
				
			}
	   
		/**
		 * @return the webDriver
		 */
		public  WebDriver getWebDriver() {
			return driver;
		}
			
		
	
	

}
