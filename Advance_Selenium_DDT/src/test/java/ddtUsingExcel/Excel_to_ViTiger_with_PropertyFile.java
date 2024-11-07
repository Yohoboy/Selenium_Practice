package ddtUsingExcel;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Excel_to_ViTiger_with_PropertyFile 
{
	

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fis = new FileInputStream("C:\\SeleniumExternalData\\ViTigerPropertyFile.properties");
		Properties properties = new Properties();
		properties.load(fis);
		
		String browser = properties.getProperty("Browser");
		
		WebDriver driver = null;

		if (browser!=null)
		{
			if (browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\advance_selenium\\firstAdvanceSeleniumProject\\BrowserDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
				
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\advance_selenium\\firstAdvanceSeleniumProject\\BrowserDrivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				
			}
			else
			{
				System.out.println("Wrong browser in Property file");
				return;
				
			}
			
			driver.get(properties.getProperty("URL"));
			
		}
	}

}
