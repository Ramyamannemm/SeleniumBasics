package crm.test;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import crm.Base.TestBase;
import crm.Pages.CRMHomePage;
import crm.Pages.CRMLoginPage;
import crm.Pages.MyProfilePage;
import crm.utilities.ExcelSheetRead;

public class MyProfileTest extends TestBase {
	
	public MyProfileTest()
	{
		super(); //this instantiates the parent class constructor first
		
	}
	
	/* This method does browser launching and also application launching*/
	@BeforeSuite
	public void setUp()
	{
		//
		initialization();
		loginpage=new CRMLoginPage();
		profilepage=new MyProfilePage();
		 
	}

	@BeforeTest
	public void LoginPrecondition()
	{
		//precondition for the test cases
		loginpage.loginIntoYourLogoApplication(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = ExcelSheetRead.GetTestData();
		return data;
	}
	
	@Test(dataProvider="getCRMTestData")
	public void addressFillValidation(String firstname,String Lastname)
	{
		
		profilepage.AddressFilling(firstname, Lastname);
		
		
		
	}
	
	
	
	
	
}
