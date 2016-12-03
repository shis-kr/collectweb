package Base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

	public static WebDriver getBrowser(String browserName) {
		
		WebDriver driver = null ;
		
		switch(browserName)
		{
		case "Firefox":
			driver = drivers.get("Firefox");
			if (driver == null) {
				System.setProperty("webdriver.gecko.driver", "/home/shishir/Downloads/geckodriver");
				driver = new FirefoxDriver();
				drivers.put("Firefox", driver);
			}
			break;
		case "Chrome":
			driver = drivers.get("chrome");
			if (driver == null) {
				System.setProperty("webdriver.chrome.driver","/home/shishir/Downloads/chromedriver");
				driver = new ChromeDriver();
				drivers.put("Chrome", driver);
			}
			break;
		}
			
		return driver;
	}

	public static void closeAllDriver() {
		for (String key : drivers.keySet()) {
			drivers.get(key).close();
			//drivers.get(key).quit();
		}
	}

	
}
