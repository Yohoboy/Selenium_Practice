//package ddtUsingCMDandMavenandTestNG;
//
//import java.io.FileInputStream;
//import java.time.Duration;
//import java.util.Random;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//
//public class ReadRunTimeMavenParameter 
//{
//	@Test
//	public void runTimeParameter() throws Throwable
//	{
//		System.out.println("Test ng test");
//
//		
//		  	String url = System.getProperty("url");
//		  	String user = System.getProperty("username");
//		  	String password = System.getProperty("password");
//		  	String browser = System.getProperty("browser");
//		  
//		  	WebDriver driver = null;
//		  	
//		  	Random random = new Random();
//		  	int randomInt = random.nextInt(100);
//		  
//		  
//			FileInputStream fis = new FileInputStream("C:\\SeleniumExternalData\\MobileCompanySheet.xlsx");
//			Workbook wb = WorkbookFactory.create(fis);
//			Sheet sheet = wb.getSheet("CompInfo");
//			Row row = sheet.getRow(2);
//			String compName = row.getCell(1).toString()+randomInt;
//			
//			
//			if (browser != null)
//			{
//				if (browser.equalsIgnoreCase("chrome"))
//				{
//					System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\advance_selenium\\ddtUsingCMDandMavenandTestNG\\BrowserDrivers\\chromedriver.exe");
//					driver = new ChromeDriver();
//				}
//				
//				else if (browser.equalsIgnoreCase("firefox"))
//				{
//					System.setProperty("webdriver.gecko.driver","C:\\Users\\User\\advance_selenium\\ddtUsingCMDandMavenandTestNG\\BrowserDrivers\\geckodriver.exe");
//					driver = new FirefoxDriver();
//					
//				}
//				
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.name("user_name")));
//				
//				driver.findElement(By.name("user_name")).sendKeys(user);
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.name("user_password")));
//				
//				driver.findElement(By.name("user_password")).sendKeys(password);
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.id("submitButton")));
//				
//				driver.findElement(By.id("submitButton")).click();
//				
//				wait.until(ExpectedConditions.urlContains("index.php?action=index&module=Home"));
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Organizations' and @href='index.php?module=Accounts&action=index']")));
//				
//				driver.findElement(By.xpath("//a[text()='Organizations' and @href='index.php?module=Accounts&action=index']")).click();
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")));
//				
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.name("accountname")));
//				
//				driver.findElement(By.name("accountname")).sendKeys(compName);
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='crmbutton small save'])[1]")));
//				
//				driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//				
//				wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[contains(text(),'Democomp')])[1]"))));
//				
//				driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//				
//				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sign Out']")));
//				
//				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//				
//			}
//			
//	
//		
//	}
//
//}

package ddtUsingCMDandMavenandTestNG;




import java.io.FileInputStream;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameter {
	@Test
	public void runTimeParameter() throws Throwable {
		
		
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		String BROWSER = System.getProperty("browser");
		String URL = System.getProperty("url");

		WebDriver driver = null;
		
		
		
		if (!BROWSER.equals(null))
		{
			if (BROWSER.equalsIgnoreCase("chrome"))
			{
			
				driver = new ChromeDriver();
								
			}
			else if (BROWSER.equalsIgnoreCase("firefox"))
			{
				
				driver = new FirefoxDriver();
				
			}
			else if (BROWSER.equalsIgnoreCase("edge"))
			{
				driver = new EdgeDriver();
				
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			
			
			driver.get(URL);
			driver.manage().window().maximize();
			
			Random random = new Random();
			int randomInt = random.nextInt(100);
			
			FileInputStream fis = new FileInputStream("C:\\SeleniumExternalData\\MobileCompanySheet.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("CompInfo");
			Row row = sheet.getRow(1);
			String orgName = row.getCell(0).toString()+randomInt;
			
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
			driver.findElement(By.xpath("(//td[@class='small'])[2]/img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			
//			driver.close();
//	
			driver.quit();
			
			
			
			
			
			
			
		}
		else {
			System.out.println("There is a problem in browser loading");
		}
	}

}