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
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.*;
//import org.testng.annotations.*;

import com.httpwatch.ClassFactory;
import com.httpwatch.IController;
import com.httpwatch.Plugin;
import com.httpwatch.Summary;

import java.io.File;
import com4j.*;


public class Httpauto4 {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	static String title;
	

public static void main(String args[]) {
	File file = new File("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("http://demo.guru99.com/test/ajax.html");
   
	
/*	List<WebElement> elements = driver.findElements(By.name("name"));
    System.out.println("Number of elements:" +elements.size());

    for (int i=0; i<elements.size();i++){
      System.out.println("Radio button text:" + elements.get(i).getAttribute("value"));
    }
*/


/*List<WebElement> links = driver.findElements(By.tagName("a"));
System.out.println("Number of elements:" +links.size());
for (int i=0; i<links.size();i++){
	System.out.println("Link text:" + links.get(i).getText());
    System.out.println("Link url:" + links.get(i).getAttribute("href"));
  }
*/


	List<WebElement> someElements = driver.findElements(By.cssSelector("input")); 

	for (WebElement anElement : someElements) {
	    if (anElement.getAttribute("type").equals("name")) {
	    	System.out.println("Texbox : " + anElement.getText());	   
	    	}
	    
	}

}

	
}
