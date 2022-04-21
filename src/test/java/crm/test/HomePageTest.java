package crm.test;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import crm.Base.TestBase;
import crm.Pages.CRMHomePage;
import crm.Pages.CRMLoginPage;
import crm.utilities.Extentreports;

public class HomePageTest extends TestBase {
    
	public HomePageTest()
	{
		super(); //this instantiates the parent class constructor first
		
	}
	
	/* This method does browser launching and also application launching*/
	@BeforeSuite
	public void setUp()
	{
		//
		initialization();
		homepage=new CRMHomePage();
		loginpage=new CRMLoginPage();
		 
	}
	
	@BeforeTest
	public void LoginPrecondition()
	{
		//precondition for the test cases
		loginpage.loginIntoYourLogoApplication(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@BeforeClass
	public void ExtentReportsSteup()
	{
		Extentreports.extentReports();
	        
	}	
	@Test
	public void HomePageTitleVerification()
	{
		Extentreports.extentReportsTest("HomePageTitleVerification");
		String actualtitle=homepage.HomePageTitle();
		
		Assert.assertEquals(actualtitle, prop.getProperty("expectedtitle"));
	}
	
	
	@Test
	public void LoggedInUserNameValidation()
	{
		
		String actualusername=homepage.HomePageusername();
		Assert.assertEquals(actualusername,prop.getProperty("expectedloggedinuser")); //hard assert
		System.out.println(actualusername);
	}
	
	
	
	@Test
	public void TshirtsOstionUnderWomenMenuTest()
	{
		homepage.HoverOverWomenOptionAndClickOnTshirtsOption();
		String Actualtshirtstitle=homepage.verifyTshirtpageIsOPened();
		Assert.assertEquals(Actualtshirtstitle, "T-shirts");
	}
	
	@AfterMethod
    public void getResult(ITestResult result) {
		Extentreports.extentReportsResults(result);
    }
	
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
	
	
	
	
}
