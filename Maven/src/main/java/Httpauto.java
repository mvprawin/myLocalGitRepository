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
import org.junit.Before;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import org.junit.*;
//import org.testng.annotations.*;

import com.httpwatch.ClassFactory;
import com.httpwatch.IController;
import com.httpwatch.Plugin;
import com.httpwatch.Summary;

import java.io.File;
import com4j.*;


public class Httpauto {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	static String title;
	

public static void main(String args[]) {
//Chrome Browser
File file = new File("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\chromedriver.exe");
System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
ChromeOptions options = new ChromeOptions();
options.addExtensions(new File("D:\\Program Files (x86)\\HttpWatch\\HttpWatchForChrome.crx"));
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
driver = new ChromeDriver(capabilities);
driver.manage().window().maximize();
driver.get("https://trailhead.salesforce.com/en/content/learn/modules/sf_cpq");
title =driver.getTitle();

IController controller= ClassFactory.createController();
Plugin plugin = controller.attachByTitle(title);

WebElement element= driver.findElement(By.cssSelector(".slds-button_success"));
plugin.record();
element.click();
controller.wait_(plugin,-1);
plugin.stop();

Summary summary =plugin.log().pages(0).entries().summary();
System.out.println("Summary Time (secs):  "+summary.time());
System.out.println("Total time to load page (secs):  "+summary.time());
System.out.println("Number of bytes received on network :  "+summary.bytesReceived());
System.out.println("Http Compression saving (bytes) :  "+summary.compressionSavedBytes());
System.out.println("Number of round trips:  "+summary.roundTrips());
System.out.println("Number of erros:  "+summary.errors().count());
System.out.println("Page Title is: "+driver.getTitle());
plugin.log().save("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\chrometest_2.hwl");

	}





	
}
