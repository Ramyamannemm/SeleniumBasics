package crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import crm.Pages.CRMHomePage;
import crm.Pages.CRMLoginPage;

public class TestBase {

	//instantiate the driver and launch the application, properties file
	public static Properties prop;
	public static WebDriver driver;
	public static CRMHomePage homepage;
	public static CRMLoginPage loginpage;
	
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
			System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		
		driver.manage().window().maximize();  //To maximaize the browser window
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
		
		
	}
	
	
	public static void implicitwait(int duration) 
	
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
	}
	
	
	
	
	
	
	
	
	
	
}
