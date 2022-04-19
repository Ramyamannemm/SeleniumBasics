package crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import crm.Pages.CRMHomePage;
import crm.Pages.CRMLoginPage;
import crm.Pages.MyProfilePage;

public class TestBase {

	//instantiate the driver and launch the application, properties file
	public static Properties prop;
	public static WebDriver driver;
	public static CRMHomePage homepage;
	public static CRMLoginPage loginpage;
	public static MyProfilePage profilepage;
	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/resources/Properties/Config.properties");
			prop.load(ip);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		
		
	}
	
	
	public static void initialization()
	{
		String browser=prop.getProperty("browser");
		
		
		if(browser.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			 driver=new ChromeDriver();
		}
		
		if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "./src/main/resources/drivers/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();  //To maximaize the browser window
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
		
		
	}
	
	
	public static void implicitwait(int duration) 
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	public static void actions(WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
