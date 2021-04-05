package stepDefinitions;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;


import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class FacebookLogin {
	
	WebDriver driver;
	
	
	@Before
	public void setUp() throws Throwable{
		        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
	}  
	
	
    @Given("^Navigate to Facebook Login page$")
    public void navigate_to_facebook_login_page() throws Throwable {
         driver.get("https://www.facebook.com");
    }

    @When("^User enters username and password$")
    public void user_enters_username_and_password() throws Throwable {
        driver.findElement(By.id("email")).sendKeys("prawinmv@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("Prince@30");
        driver.findElement(By.name("login")).click();
        //driver.findElement(By.xpath("//input[@value='Log In']")).click();
    }

    @Then("^User redirected to Home Page$")
    public void user_redirected_to_home_page() throws Throwable {
    	Thread.sleep(50000);
     String ptitle = driver.getTitle();
     //Assert.assertSame(ptitle.contains("Facebook"),"Page Title doesn't match");
     Assert.assertEquals(ptitle,"(20+) Facebook");
    }
	
      
    @After
    public void user_close_the_browser() throws Throwable{	
    	driver.quit();
    }

	
}
