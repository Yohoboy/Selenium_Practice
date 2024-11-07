package dataFromJSON;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {
	WebDriver driver;
@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
private WebElement logout;
@FindBy(xpath ="//a[text()='Sign Out']" )
private WebElement signout;

public Pom(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

public WebElement getLogout() {
	return logout;
}

public WebElement getSignout() {
	return signout;
}
public void act()
{
	Actions ac=new Actions(driver);
	ac.moveToElement(logout).perform();
	signout.click();
}
}
