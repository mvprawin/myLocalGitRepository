import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.*;

import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
//import org.junit.*;
import org.testng.annotations.*;

import com.httpwatch.ClassFactory;
import com.httpwatch.IController;
import com.httpwatch.Plugin;
import com.httpwatch.Summary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;

import com4j.*;


public class Httpauto3 {
	public static WebDriver driver;
	public static WebDriver driverSwitch = null;
	public WebDriverWait wait;
	public Actions actions;
	public static String fileName1,fileName2; 
	static String title;
	
@BeforeClass
//Chrome Browser
public static void setUp() {
File file = new File("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\chromedriver.exe");
System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());
ChromeOptions options = new ChromeOptions();
options.addExtensions(new File("D:\\Program Files (x86)\\HttpWatch\\HttpWatchForChrome.crx"));
DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(ChromeOptions.CAPABILITY, options);
driver = new ChromeDriver(capabilities);
driver.manage().window().maximize();
driver.get("http://www.google.com");

}
//@Test(priority=0)
public static void otp(){
//Set the Desired Capabilities
	DesiredCapabilities capabilities = new DesiredCapabilities();
capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
capabilities.setCapability("device","Android");
capabilities.setCapability("device ID", "c1cbd64c"); // sony
capabilities.setCapability("platformVersion", "8.0.0");
capabilities.setCapability("platformName", "Android");
capabilities.setCapability("deviceName", "Android");
capabilities.setCapability("unlockType", "pin");
capabilities.setCapability("unlockKey", "6000");
capabilities.setCapability("appPackage", "com.google.android.apps.messaging");
capabilities.setCapability("appActivity", "com.google.android.apps.messaging.ui.ConversationListActivity");		
capabilities.setCapability("noReset", "true");

		//Instantiate Appium Driver
		try {
			driverSwitch = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driverSwitch.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			
		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}

		String otp = driverSwitch.findElement(By.xpath("//*[contains(@text,'code')]")).getText().split(" " )[1];
		System.out.println("The OTP number is: "+otp);
		driverSwitch.quit();
	

}

@Test(priority=0)
public static void scenario() throws IOException {
	//public static void main(String[] args) throws FileNotFoundException {		
fileName1 = new SimpleDateFormat("yyyyMMddHHmm'.hwl'").format(new Date());
//fileName2 = new SimpleDateFormat("yyyyMMddHHmm'.txt'").format(new Date());
fileName2 = new SimpleDateFormat("yyyyMMddHHmm'.xls'").format(new Date());
//String file = "C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\Result\\log_"+fileName2;
String xfile = "C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\Result\\log_"+fileName2;

Workbook workbook = new HSSFWorkbook();
//Workbook workbook = WorkbookFactory.create(new File(xfile));
Sheet sheet = workbook.createSheet("Output");

Row row =sheet.createRow(0);
row.createCell(0).setCellValue("Page Name");
row.createCell(1).setCellValue("Total time(secs)");

//FileOutputStream out = new FileOutputStream(file);
//PrintWriter writer = new PrintWriter(out);

IController controller= ClassFactory.createController();
title =driver.getTitle();
Plugin plugin = controller.attachByTitle(title);

WebElement element = driver.findElement(By.xpath("//input[@name='q']"));
element.sendKeys("Cheese!");
plugin.record();
element.submit();
controller.wait_(plugin,-1);
Summary summary =plugin.log().pages(0).entries().summary();
System.out.println("Page Title is: "+driver.getTitle());
System.out.println("Total time to load page (secs):  "+summary.time());

Row row1 =sheet.createRow(1);
row1.createCell(0).setCellValue(driver.getTitle());
row1.createCell(1).setCellValue(summary.time());

//writer.println("Page: "+driver.getTitle() + "& Total time(secs):  "+summary.time());
//writer.flush();

WebElement element2 = driver.findElement(By.className("LC20lb"));
element2.click();
controller.wait_(plugin,-1);
Summary summary2 =plugin.log().pages(1).entries().summary();
System.out.println("Page Title is: "+driver.getTitle());
System.out.println("Total time to load page (secs):  "+summary2.time());

Row row2 =sheet.createRow(2);
row2.createCell(0).setCellValue(driver.getTitle());
row2.createCell(1).setCellValue(summary2.time());
//writer.println("Page: "+driver.getTitle() + " && Total time(secs):  "+summary2.time());
//writer.flush();

FileOutputStream out = new FileOutputStream(xfile);
workbook.write(out);
workbook.close();
plugin.stop();

plugin.log().save("C:\\Users\\PRAWIN\\Desktop\\Selenium\\Performance\\Result\\Chrome_"+fileName1);
}

@AfterClass
public void tearDown() {
driver.quit();
		}
	
}
