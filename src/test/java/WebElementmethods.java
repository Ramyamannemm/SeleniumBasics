import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class WebElementmethods {

	static WebDriver driver;

	
	@Test(enabled=false)
	public void sendkeys()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/text-box");
		driver.findElement(By.id("userName")).sendKeys("Ramya Mannem");
		
	}
	
	@Test(enabled=false)
	public void getText()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/text-box");
		String currentaddresslabel=driver.findElement(By.id("currentAddress-label")).getText();
		System.out.println(currentaddresslabel);
	}
	
	@Test(enabled=false)
	public void getAttr()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/text-box");
		String Attributevalue=driver.findElement(By.id("userName")).getAttribute("placeholder");
		System.out.println(Attributevalue);
	}
	
	
	@Test(enabled=false)
	public void SelectDropdown()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/select-menu");
		WebElement dropdown=driver.findElement(By.id("cars"));
		Select select1=new Select(dropdown);
		
		//---------dynamic drop down
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement ele=driver.findElement(By.xpath("(//*[@class=' css-1wa3eu0-placeholder'])[1]"));
		JavascriptExecutor execute=((JavascriptExecutor)(driver));
		execute.executeScript("arguments[0].click();", ele);
		driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]")).sendKeys("A root option");
		driver.findElement(By.xpath("//*[@id=\\\"withOptGroup\\\"]")).click();
		
	}
	
	@Test(enabled=false)
	public void checkbox()
	{
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/checkbox");
		WebElement checkobox=driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-uncheck']"));
		
		if(checkobox.isEnabled())
		{
			checkobox.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(driver.findElement(By.xpath("//*[@class='rct-icon rct-icon-check']")).isSelected())
			{
				System.out.println("checkbox is selected");
			}
			else
			{
				System.out.println("checkbox is not selected");
			}
		}
		else
		{
			System.out.println("check box is not enabled ");
		}
	}
	
	@Test(enabled=false)
	public void Buttons()
	{
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/radio-button");
		WebElement button=driver.findElement(By.id("noRadio"));
		
		if(button.isEnabled())
		{
			button.click();
		}
		else
		{
			System.out.println("check box is not enabled ");
		}
	}
	
	@Test
	public void mouseactions()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/menu");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		WebElement clickme=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		Actions action=new Actions(driver);
		action.moveToElement(clickme).build().perform();
		
	}
	
	@AfterSuite
	public void teardown()
	{
		//driver.quit();
	}
	
	
	
	
}
