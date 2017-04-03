package com.gslab.services;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Services {
	
	private WebDriver driver;
	private boolean isPresent = false;
	private Actions actions;
	/**
	 * Parameterize constructor for initializing web driver.
	 * 
	 * @param webDriver
	 */
	public Services(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	
	public  void waitMyTime(int i) {
		driver.manage().timeouts().implicitlyWait(i, TimeUnit.SECONDS);

		}
	
	/**
	 * This method is used for waiting for elements until it appears or it gets
	 * timed out after 30secs.
	 * 
	 * @param element
	 * @throws InterruptedException
	 * 
	 */
	public void assertAndVerifyElement(By element) throws InterruptedException{
		isPresent = false;
		for (int i = 0; i < 5; i++) {
			try {
				if (driver.findElement(element) != null && driver.findElement(element).isDisplayed()) {
					isPresent = true;
					break;
				}
			} catch (Exception e) {
				// System.out.println(e.getLocalizedMessage());
				Thread.sleep(1000);
			}
		}
		Assert.assertTrue(isPresent, "\"" + element + "\" is not present.");
		
		
		
	}
	
	/**
	 * This method is used for verifying & clicking on element.
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void assertAndClickElement(By element) throws InterruptedException {
		assertAndVerifyElement(element);
		driver.findElement(element).click();
	}
	
	/**
	 * This method is used for verifying input elements and type into it.
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void assertElementAndType(By element, String text)
			throws InterruptedException {
		assertAndVerifyElement(element);
		driver.findElement(element).sendKeys(text);
	}
	
	
	/**
	 * This function is used for uploading file.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException 
	 * @throws InterruptedException 
	 */
	
	public void assertAndUploadFile(String filePath) throws IOException, InterruptedException{
		isPresent = false;
		File file = new File(filePath);
		if(file.exists()){
		 Runtime.getRuntime().exec(filePath);
		 isPresent=true;
		}
		
		Assert.assertTrue(isPresent, "File  is not present.");
		Thread.sleep(6000);
		
		//Mozilla - File Upload
		//Chrome - Open
		//and for IE - Choose File to Upload
	}
	
	
	/**
	 * This method is used for wait for given time period.
	 * 
	 * @param timeInSeconds
	 * @throws InterruptedException
	 */
	public void waitForTime(int timeInSeconds) throws InterruptedException {
		for (int i = 0; i < timeInSeconds; i++) {
			Thread.sleep(1000);
		}
	}
	
	/**
	* <h1>switchToNewWindow!</h1> This method will helps us to switch to a New
	* window
	*/
	public  void switchToNewWindow() {
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w2);
	}
	
	
	/**
	* <h1>switchToNewWindow!</h1> This method will helps us to switch to a New
	* window
	*/
	public  void switchToOldWindow() {
		Set s = driver.getWindowHandles();
		Iterator itr = s.iterator();
		String w1 = (String) itr.next();
		String w2 = (String) itr.next();
		driver.switchTo().window(w1);
		}
	
	/**
	* <h1>assertPressCtrlAndClick</h1> This method will helps us to press ctrl and click mouse button 
	* @param 
	* @throws InterruptedException 
	* 
	*/

	
	public void assertPressCtrlAndClick(By element) throws InterruptedException{
		assertAndVerifyElement(element);
		actions.keyDown(Keys.LEFT_CONTROL)
		.click(driver.findElement(element))
		.keyUp(Keys.LEFT_CONTROL).build().perform();
		
		
	}
	
	/**
	*  This method will helps us to drag and drop web element 
	* @param from
	* @param to
	* @throws InterruptedException 
	* 
	*/
	
	public void assertDragAndDrop(By from ,By to) throws InterruptedException{
		
		assertAndVerifyElement(from);
		assertAndVerifyElement(to);
		
		actions.clickAndHold(driver.findElement(from))
		.moveToElement(driver.findElement(to))
		.perform();
		Thread.sleep(2000);
		actions.release(driver.findElement(to)).build()
		.perform();
		
		
	}
	
	/**
	*  This method will helps us to hover on web elements 
	* @param hoverElement
	* @throws InterruptedException 
	* 
	*/
	
	public  void HoverWebelement(By hoverElement)
			throws InterruptedException {
			
			actions.moveToElement(driver.findElement(hoverElement)).perform();
			Thread.sleep(2000);

			}
	
	
	
	

}
