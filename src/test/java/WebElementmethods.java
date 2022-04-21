import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	public void SelectDropdown() throws AWTException
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/select-menu");
		WebElement dropdown=driver.findElement(By.id("cars"));
		Select select1=new Select(dropdown);
		
		//---------dynamic drop down
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement ele=driver.findElement(By.xpath("(//*[@class=' css-1wa3eu0-placeholder'])[1]"));
		Actions action=new Actions(driver);
		action.click(ele).build().perform();
		action.sendKeys(driver.findElement(By.xpath("//*[@id=\"withOptGroup\"]")),"A root option" ).build().perform();
		Robot robot =new Robot(); //to perfrom keyboard actions
		robot.keyPress(KeyEvent.VK_ENTER);
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
	
	@Test(enabled=false)
	public void mouseactions()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/slider");
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//WebElement clickme=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ESCAPE);
		//action.moveToElement(clickme).build().perform(); //mouse hover action
		/*WebElement doubleclick=driver.findElement(By.id("doubleClickBtn"));
		action.doubleClick(doubleclick).build().perform();
		String doubleclickmessage= driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals(doubleclickmessage, "You have done a double click");*/
		
		//assignment on right click
		//action.contextClick(doubleclick
		
		WebElement slider=driver.findElement(By.xpath("//*[@class='range-slider range-slider--primary']"));
		action.dragAndDropBy(slider, 0, 100).build().perform();	
	}
	
	@Test(enabled = false)
	public void alerts()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/alerts");
		
		WebElement promtalert=driver.findElement(By.id("promtButton"));
		Actions action=new Actions(driver);
		action.click(promtalert).build().perform();
		driver.switchTo().alert().getText();
		
	}
	
	
	@Test(enabled=false)
	public void frames()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/frames");
		//driver.switchTo().frame("frame1");
		System.out.println(driver.findElement(By.id("sampleHeading")).getText());
		
		driver.switchTo().defaultContent();
		for(int i=1;i<=2;i++)
		{
			driver.switchTo().frame(i);
		}
		
	}
	
	@Test(enabled=false)
	public void Webtables()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		//driver.get("https://cosmocode.io/automation-practice-webtable/");
		//static webtable
		
		
	/*	int noOfRows=197;
		int noOfcol=5;
		
		for(int row=2;row<=noOfRows;row++)   //row traversing
		{
			for(int col=2;col<noOfcol;col++)   //column traversing
			{
				//table//tbody//tr[2]/td[2]
			  String cellvalue=driver.findElement(By.xpath("//table//tbody//tr["+ row + "]/td[" + col + "]" )).getText();
				System.out.println(cellvalue);
				
			}
		}*/
		
		
		//dynamic webtables
		driver.get("https://demoqa.com/webtables");
		
		int noOfRows=driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-tbody']//div[@class='rt-tr-group']")).size();
		int noOfcols=driver.findElements(By.xpath("//div[@class='rt-table']//div[@class='rt-tr-group'][1]//div[@class='rt-td']")).size();
		
		
		
		
		
		
		
	}
	
	@Test(enabled=false)
	public void WindowsHandles()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/browser-windows");
		
		driver.findElement(By.id("windowButton")).click();
		
		String ParentWindow =driver.getWindowHandle(); //the current window id
		System.out.println(ParentWindow);
		Set<String> Allwindows=driver.getWindowHandles(); //gives all the windwos that are opened
		
		for(String window: Allwindows)
		{
			System.out.println(window);
			if(!window.equals(ParentWindow))
			{
				driver.switchTo().window(window);
				String text=driver.findElement((By.id("sampleHeading"))).getText();
				System.out.println(text);
			}
			
			
		}
		
		
	}
	
	@Test(enabled=false)
	public void implicitwait()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/dynamic-properties");
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("visibleAfter")))).getText();
		String text=driver.findElement(By.id("visibleAfter")).getText();
		System.out.println(text);
		
		Wait wait1=new FluentWait(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(getClass());;
		
	}
	
	@Test(enabled=false)
	public void scrolling()
	{
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//h5[text()='Elements']"));
		JavascriptExecutor js=((JavascriptExecutor)(driver));
		//js.executeScript("window.scrollBy(0,1000)");
		js.executeScript("arguments[0].scrollIntoView();", ele);
		ele.click();
		
		
	}
	
	@Test
	public void takescreenshot() 
	{
		
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		driver=new ChromeDriver();//Run time polymorphysim
		driver.get("https://demoqa.com/");
		driver.manage().window().maximize();
		WebElement ele=driver.findElement(By.xpath("//h5[text()='Elements']"));
		try
		{
		ele.click();
		}
		catch(ElementClickInterceptedException e)
		{
		TakesScreenshot screenshot=((TakesScreenshot)(driver));
		
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		File dest=new File("./test-output/screenshot.png");
		
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			// TODO Auto-generated catch block
			
		}
	}
	
	
	
	
	@AfterSuite
	public void teardown()
	{
		//driver.quit();
	}
	
	
	
	
}
