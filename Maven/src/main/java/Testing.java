import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.List;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import org.testng.annotations.*;

public class Testing extends Common {
static Common common = new Common();
	
@BeforeClass
public void setUp() {
	
	common.browser("edge");
}

@Test(priority=0)
public void login() {
	
	try {
	WebElement username = driver.findElement(By.name("loginName"));
	common.waitUntilElementVisible(username);
	username.sendKeys("kumar.lister");
	}
	catch(Exception e) {
		System.out.println("Username Element was not found");
	}
	
	try {
	WebElement passwd = driver.findElement(By.name("password"));
	common.waitUntilElementVisible(passwd);
	passwd.sendKeys("Reddy@1234");
	}
	catch (Exception e) {
		System.out.println("password Element was not found");}
	
	try {
	WebElement login = driver.findElement(By.id("login-button"));
	common.waitUntilElementVisible(login);
	login.click();
	}
	catch (Exception e) {
	System.out.println("login button Element was not found");}
	
}

@Test(enabled=false,priority =1)
public void mouseHover() {
	
	try {
	WebElement dropdown = driver.findElement(By.cssSelector("#headerAccount > select:nth-child(1)"));
	
	common.waitUntilElementVisible(dropdown);
	System.out.println("Focus moved towards dropdown");
	common.mouseHover(dropdown);
	System.out.println("mouse hover performed on the dropdown");
	dropdown.click();
	
	Select select = new Select(dropdown);	
	List<WebElement> allOptions = select.getOptions();
	
	for(WebElement options : allOptions){
		String dpdn_value = options.getText();
		System.out.println(dpdn_value);
	}
	
	
	
	}
	catch(Exception e) {
		System.out.println("Dropdown element was not found");
	}
	
	
	
	
}


@Test(enabled =false)
public void java_execution() {
WebDriverWait wait= new WebDriverWait(driver,10);
WebElement element = driver.findElement(By.name("q"));

/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
						.withTimeout(30,TimeUnit.SECONDS)
						.pollingEvery(5,TimeUnit.SECONDS)
						.ignoring(NoSuchElementException.class);
*/

wait.until(ExpectedConditions.elementToBeClickable(element));
System.out.println("WebDriver wait until element is clickable");
element.sendKeys("Cheese");
element.submit();


System.out.println("Execution Success");
}


@AfterClass
public void tearDown(){
	System.out.println("Execution Success");
	driver.quit();
	
}

}
