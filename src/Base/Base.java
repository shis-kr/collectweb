package Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AppConstants;

public abstract class Base {

	protected static WebDriver driver = null;
	protected static WebElement element = null;
	protected WebDriverWait wait = null;
	
	@BeforeTest
	public WebDriver initializeDrivers()
	{
		//this function is with annotation beforeTest, it is called just before every test case function
		return driver;
	}
	
	@Test
	public abstract void executeTest() throws Exception;
	
	protected void initDrivers(String browserName){
		initDrivers(browserName, AppConstants.Url);
	}

	protected void initDrivers(String browserName, String url)
	{
		driver = BrowserFactory.getBrowser(browserName);
		// using BrowserFactory class for every browser instance so which ever browser name is provided, test cases runs on that browser instance
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		// driver.get(url) launches the website provided in the url to the browser instance
		WebDriverWait wait = new WebDriverWait(driver,10);
	}
	
	@AfterTest
	public void closeDrivers() {
		// this function is with annotation AfterTest, which is called after every test case is executed
		// here to close the browser instance 
		BrowserFactory.closeAllDriver();
	}
	
}
