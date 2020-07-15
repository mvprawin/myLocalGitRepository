import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import org.testng.annotations.*;

import com.httpwatch.ClassFactory;
import com.httpwatch.IController;
import com.httpwatch.Plugin;
import com.httpwatch.Summary;

import java.io.File;
import com4j.*;


public class Httpauto2 {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	
	

	public static void main(String[] args) {

//IE Browser
//File file = new File("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\IEDriverServer\\IEDriverServer.exe");
//System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
//DesiredCapabilities capabilitiesIE =  DesiredCapabilities.internetExplorer();
//capabilitiesIE.setCapability(
//InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//WebDriver driver = new InternetExplorerDriver(capabilitiesIE);

		
//Chrome Browser
File file = new File("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\chromedriver.exe");
System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
ChromeOptions options = new ChromeOptions();
options.addExtensions(new File("D:\\Program Files (x86)\\HttpWatch\\HttpWatchForChrome.crx"));
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
WebDriver driver = new ChromeDriver(capabilities);


IController controller= ClassFactory.createController();
driver.manage().window().maximize();
driver.get("http://www.google.com");
String title =driver.getTitle();

Plugin plugin = controller.attachByTitle(title);

WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
element.sendKeys("Cheese!");
plugin.record();
element.submit();
controller.wait_(plugin,-1);
Summary summary =plugin.log().pages(0).entries().summary();
System.out.println("Total time to load page (secs):  "+summary.time());
System.out.println("Page Title is: "+driver.getTitle());


WebElement element2 = driver.findElement(By.className("LC20lb"));
element2.click();
controller.wait_(plugin,-1);
Summary summary2 =plugin.log().pages(1).entries().summary();
System.out.println("Total time to load page (secs):  "+summary2.time());
System.out.println("Page Title is: "+driver.getTitle());


plugin.stop();


plugin.log().save("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\chrometest_All.hwl");












driver.quit();

		}
	
}
