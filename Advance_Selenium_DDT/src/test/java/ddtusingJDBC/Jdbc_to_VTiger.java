package ddtusingJDBC;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Jdbc_to_VTiger {

	@Test
	public void fetchDataFromJdbc() {
		String CompName = null;
		WebDriver driver = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dummyschema", "root",
					"root");

			Statement statement = connection.createStatement();
			
			ResultSet resultset1 = statement.executeQuery("Select companyname from mobilephones limit 1");

			Random random = new Random();
			int randomNum = random.nextInt(100);
			//int lastNum = resultset1.getFetchSize();
			while (resultset1.next()) 
				CompName = resultset1.getString(1) + randomNum;
			

			
			

			// 1. parse JSON file into Java object using JSonParse class
			JSONParser parser = new JSONParser();

			// to load the JSOn file we can use either FileReader class or we can also use
			// File class
			Object object = parser.parse(new FileReader("C:\\SeleniumExternalData\\appCommonData.json"));

			// 2. Convert this Object into JSON Object using down casting
			JSONObject jsonObject = (JSONObject) object;

			// 3. Get the value using get() method
			String browser = jsonObject.get("browser").toString();
			String url = jsonObject.get("url").toString();
			String user = jsonObject.get("user").toString();
			String password = jsonObject.get("password").toString();
			int timeOut = Integer.parseInt(jsonObject.get("timeout").toString());

			if (!browser.equals(null)) {
				if (browser.equalsIgnoreCase("chrome")) {
					driver = new FirefoxDriver();
				} else if (browser.equalsIgnoreCase("firefox")) {
					driver = new ChromeDriver();
				}
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));

			driver.get(url);
			driver.manage().window().maximize();

			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(user);

			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);

			driver.findElement(By.xpath("//input[@id='submitButton']")).click();

			driver.findElement(
					By.xpath("//a[@href='index.php?module=Accounts&action=index' and text()='Organizations']")).click();

			driver.findElement(By.xpath(
					"//a[@href='index.php?module=Accounts&action=EditView&return_action=DetailView&parenttab=Marketing']/img[@src='themes/softed/images/btnL3Add.gif']"))
					.click();

			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(CompName);

			driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='dvHeaderText']")));

			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

		} catch (ClassNotFoundException | SQLException | IOException | ParseException e) {

			e.printStackTrace();
		}

	}
}
