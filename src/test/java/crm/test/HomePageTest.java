package crm.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import crm.Base.TestBase;
import crm.Pages.CRMHomePage;
import crm.Pages.CRMLoginPage;

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
	
	
	@Test
	public void HomePageTitleVerification()
	{
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
	
	
	
	@AfterTest
	public void TearDown()
	{
		driver.close();
	}
	
	
	
	
	
}
