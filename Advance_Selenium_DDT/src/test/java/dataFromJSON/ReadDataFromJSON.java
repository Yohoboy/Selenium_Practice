package dataFromJSON;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReadDataFromJSON 
{

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException
	{
		WebDriver driver = null;
		
		// 1. parse JSON file into Java object using JSonParse class
		JSONParser parser = new JSONParser();
		
		// to load the JSOn file we can use either FileReader class or we can also use File class
		Object object = parser.parse(new FileReader("C:\\SeleniumExternalData\\appCommonData.json"));
		
		// 2. Convert this Object into JSON Object using down casting
		JSONObject jsonObject =  (JSONObject)object;
		
		// 3. Get the value using get() method
		String browser = jsonObject.get("browser").toString();
		String url = jsonObject.get("url").toString();
		String user = jsonObject.get("user").toString();
		String password = jsonObject.get("password").toString();
		int timeOut = Integer.parseInt(jsonObject.get("timeout").toString());
		
		//Read data from Excel sheet
		FileInputStream fis = new FileInputStream("C:\\SeleniumExternalData\\MobileCompanySheet.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("CompInfo");
		Row row = sheet.getRow(2);
		
		Random random = new Random();
		int randomInt = random.nextInt(100);
		
		String compName = row.getCell(0).toString()+randomInt;
		
		
		
		if (!browser.equals(null))
		{
			if (browser.equalsIgnoreCase("chrome"))
			{
				driver = new FirefoxDriver();
			}
			else if (browser.equalsIgnoreCase("firefox"))
			{
				driver = new ChromeDriver();
			}
			
			
			
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
			
			driver.get(url);
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(user);
			
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
			
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();
			
			driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(compName);
			
			driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
			
		//	driver.findElement(By.xpath("(//td[@class='small'])[2]/img[@src='themes/softed/images/user.PNG']")).click();
			
			//driver.findElement(By.xpath("//a[@class='drop_down_usersettings' and text()='Sign Out']")).click();
			
			
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='dvHeaderText']")));
			
			Pom p=new Pom(driver);
			p.act();
			
		//	Actions ac=new Actions(driver);
//			webelemm
//			ac.moveToElement(logout).perform();
//			signout.click();

			
//			driver.close();
//			driver.quit();
			
		}
		
		
		
		
		
		

	}

}
