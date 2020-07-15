import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import org.testng.annotations.*;

public class Common {
	public static WebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	
	
public void browser(String browsername ){
	if(browsername.equals("firefox")) {
FirefoxProfile profile = new FirefoxProfile();
profile.setAcceptUntrustedCertificates(true);
profile.setAssumeUntrustedCertificateIssuer(false);
FirefoxOptions options = new FirefoxOptions();	
driver = new FirefoxDriver(options.setProfile(profile));
driver.manage().window().maximize();
driver.navigate().to("https://cacert.org/");
driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	else if(browsername.equals("chrome")) {

		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		driver.manage().window().maximize();
		driver.navigate().to("https://cacert.org/");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);		
	}
	
	else if(browsername.equals("ie")) {

		/*driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.get("https://cacert.org/");
		driver.get("javascript:document.getElementById('overridelink').click();");*/
		
		//InternetExplorerOptions options = new InternetExplorerOptions();
		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setAcceptInsecureCerts(true);
		capability.setJavascriptEnabled(true);
		driver = new InternetExplorerDriver(DesiredCapabilities.internetExplorer());
		driver.manage().window().maximize();
		driver.navigate().to("https://cacert.org/");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
						
	}
	
	else if(browsername.equals("edge")) {
		EdgeOptions edoptions = new EdgeOptions();
		edoptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);	
		driver.manage().window().maximize();
		driver.navigate().to("https://cacert.org/");
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);		
	}
	
	else {
		System.out.println("Browser name not provided");
	}
	
	
	
	}
		
	public void waitUntilElementVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 80);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	public void mouseHover(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.click().build().perform();
	}
	
	
}