package dataDrivenTesting;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excel_to_ViTiger_with_PropertyFile 
{
	

	public static void main(String[] args) throws Throwable 
	{
		// 1. To Locate or to load the PROPERTY FILE in the Selenium Environment
		FileInputStream fis = new FileInputStream("C:\\SeleniumExternalData\\ViTigerPropertyFile.properties");
		
		// 2. Create Object for Properties class to access the properties
		Properties properties = new Properties();
		// 3. Using the load() method to load the the reference of the the loaded file.
		//properties.load(fis);
		
		// 4. Using the getProperty() method of Properties class to fetch the browser Key Value 
		String browser = properties.getProperty("Browser");
		
		// 5. Declaring the Webdriver reference as null 
		WebDriver driver = null;

		if (browser!=null)
		{
			if (browser.equalsIgnoreCase("chrome"))
			{
				//System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\advance_selenium\\firstAdvanceSeleniumProject\\BrowserDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				//System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\advance_selenium\\firstAdvanceSeleniumProject\\BrowserDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			else
			{
				System.out.println("Wrong browser in Property file");
				return;
				
			}
			
			// 6. Using the get() method from WebDriver interface we are sending the url whic
			
			
			
			driver.get(properties.getProperty("URL"));
			
		}
	}

}
