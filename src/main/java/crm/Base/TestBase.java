package crm.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	//instantiate the driver and launch the application, properties file
	public static Properties prop;
	
	public static WebDriver driver;
	
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
	
	
	public void initialization(String browser)
	{
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
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
