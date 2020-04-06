package com.qa.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception{
		
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tnebnet.org/awp/login");		
	}
	
	
	@Test
	public void loginTest() throws Exception{
		
		System.out.println("Page Title is: "+ driver.getTitle());
		WebElement username = 	driver.findElement(By.id("userName"));
		WebElement password = 	driver.findElement(By.id("password"));
		WebElement submitBtn = driver.findElement(By.name("submit"));	

		waitforVisibility(username);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("test_username");
		waitforVisibility(password);
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("test_password");
		Thread.sleep(1000);
		waitforClickable(submitBtn);
		submitBtn.click();	
		
			
		if(driver.findElements(By.xpath("//span[@title='Click here']")).size() !=0){
		String errorTxt= driver.findElement(By.xpath("//span[@title='Click here']")).getText();
		if(errorTxt.equals("Bad Credentials / Account not activated?")) {
			System.out.println("Invallid Username & password");
			
			driver.navigate().back();
			Thread.sleep(2000);
		}
					
		}
		else {
			WebElement loginName=driver.findElement(By.xpath("//*[contains(text(),'Welcome')]"));
			if(loginName.isDisplayed()) {
				System.out.println("Valid user - Login Success for user "+loginName.getText());
			}
			
		}
		
		
		
		//driver.navigate().refresh();	
		
			
	}
			
	
	public void errorValidation() throws Exception{
		WebElement Error = driver.findElement(By.xpath("//span[(text()='Bad Credentials / Account not activated?')]"));
		waitforVisibility(Error);
		String error_text = Error.getText();		
		Assert.assertEquals(error_text, "Bad Credentials / Account not Activated?");
	}
	
	@AfterClass
	public void tearDown() throws Exception{
		driver.quit();
	}
	
	
	public void waitforVisibility(WebElement e){		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOf(e));		
		
	}

	public void waitforClickable(WebElement e){		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(e))	;	
		
	}
	

}
