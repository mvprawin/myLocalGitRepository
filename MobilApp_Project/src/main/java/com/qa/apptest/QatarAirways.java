package com.qa.apptest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class QatarAirways {
	WebDriver driver;

	
	
@BeforeMethod
@BeforeClass
public void setUp() throws MalformedURLException {	
DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
	desiredcapabilities.setCapability("platformName","Android");
	desiredcapabilities.setCapability("VERSION", "8.0.0");
	desiredcapabilities.setCapability("deviceName","G2299");
	desiredcapabilities.setCapability("device ID","c1cbd64c"); //"c1cbd64c"); // sony
	desiredcapabilities.setCapability("unlockType", "pin");
	desiredcapabilities.setCapability("unlockKey", "6666");
	desiredcapabilities.setCapability("appPackage", "com.m.qr");
	desiredcapabilities.setCapability("appActivity", "com.m.qr.activities.misc.QRSplashScreen");
	desiredcapabilities.setCapability("autoAcceptAlerts", true);
	desiredcapabilities.setCapability("noReset", "true");
	
	
	try {
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredcapabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		
	} catch (MalformedURLException e) {
		System.out.println(e.getMessage());
	}
	}


@Test
public void appTest() throws Exception {
	//WebElement bookflight = driver.findElement(By.xpath("//*[@text='Book a flight']"));

	WebElement checkin = driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id= 'com.m.qr:id/hp_check_in']"));
	checkin.click();
	
	WebElement eticket = driver.findElement(By.xpath("//android.widget.EditText[@text= 'Booking reference or e-ticket number']"));
	eticket.sendKeys("Test eticket");
	
	WebElement lname = driver.findElement(By.xpath("//android.widget.EditText[@text= 'Last name']"));
	lname.sendKeys("PRAWIN");
	
	WebElement checkInBtn = driver.findElement(By.xpath("//*[@text='Check in' and @index=0]"));
	
	checkInBtn.click();
	checkInBtn.click();
	

	 
	System.out.println("Clicked");
	
	
	
}


@AfterClass
public void teardown(){
	//close the app
	//driver.quit();
}


}
