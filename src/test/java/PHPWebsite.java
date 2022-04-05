
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PHPWebsite {
	static WebDriver driver;
	
	
	@BeforeTest //it executes before each @Test
	void startmethod()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/text-box");
		//driver.navigate().to("https://demoqa.com/radio-button");
		//driver.getTitle();
		
	}

	
	//login to php travels and validate that login is successful
	@Test( groups = "RegressionSuite" )
	public void login()
	{
		
		//driver.findElement(By.xpath("//a[contains(@class,'sign-in btn')]")).click();
		
		List<WebElement> listofElements=driver.findElements(By.xpath("//label[@class=\"custom-control-label\"]"));
		for(int i=0;i<listofElements.size();i++)
		{
			//listofElements.get(i).click();
			
		}
		
	}
	
	/*//this test case verifies the title of php travels home page
	@Test(priority = 1,testName = "title",groups = "RegressionSuite" )
	public void verifyTitle()
	{
		String ExpectedTitle="PHPTRAVELS booking script and system for hotels airline flights tours cars online application - PHPTRAVELS";
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, ExpectedTitle);
		
	}*/
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
	}
	
}
