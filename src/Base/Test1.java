package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import PageObjects.AppConstants;

public class Test1 extends Base{

	@Test(enabled=false)
	public void testlogin()
	{
		initDrivers("Firefox", AppConstants.Url);
		login();
		logout();
//		initDrivers("Chrome", AppConstants.Url);
	}
	
	@Test(enabled=true)
	public void newQuestion()
	{
		initDrivers("Firefox", AppConstants.Url);
		login();
//		driver.findElement(By.id("createSurvey")).click();
//		driver.findElement(By.xpath("//button[@id='createSurvey']")).click();
//		driver.findElement(By.cssSelector("#createSurvey")).click();
//		driver.findElement(By.xpath("//span[text()='New Questionnaire']")).click();
		driver.findElement(By.xpath("html/body/div[2]/div[3]/div[1]/div/div[1]/div[3]/div/div/button")).click();
		
		driver.findElement(By.cssSelector("#surveyTitle")).sendKeys("new test");
		WebElement category = driver.findElement(By.id("sector")); 
		Select mySelect= new Select(category);
		mySelect.selectByIndex(2);
		
		WebElement type = driver.findElement(By.id("type"));
		Select mySelect1 = new Select(type);
		mySelect1.selectByValue("Simple");
		
		driver.findElement(By.cssSelector("#saveSurvey")).click();
	}
	
	public void login()
	{
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(AppConstants.adminEemail);
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys(AppConstants.adminPassword);
		driver.findElement(By.cssSelector("button[id='submit']")).click();
	}
	
	public void logout()
	{
		driver.findElement(By.id("logout-profile"));
	}
	
	
	@Test(enabled=false)
	@Override
	public void executeTest() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
